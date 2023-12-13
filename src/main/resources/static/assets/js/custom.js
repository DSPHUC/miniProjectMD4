const urlApi = "http://localhost:8081/api";
const urlCategory = urlApi + "/categories";
const urlProduct = urlApi + "/products";
const urlCompany = urlApi + "/companies";
const urlColor = urlApi + "/colors";
const urlPrice = urlApi + "/prices";
let pageCurrent = 0;
const page = {
    url: {
        getAllColors: urlColor,
        getAllCategories: urlCategory,
        getAllProduct: urlProduct,
        getAllCompanies: urlCompany,
        getAllPrices: urlPrice
    },
    elements: {},
    loadData: {},
    commands: {}
}
const categoryConten = $("#categoryContent");
const productContent = $("#productContent");
const companyContent = $("#companyContent");
const colorContent = $("#colorContent");
const priceContent = $("#priceContent");
const searchProduct = $("#inputSearch");
const sortPrice = $('#sortPrice');

async function fetchALlProduct() {
    return await $.ajax({
        url: page.url.getAllProduct,
        method: "GET",
        dataType: "json"
    })
}

getAllProduct = async () => {
    const products = await fetchALlProduct();
    products.content.forEach(item => {
        const str = renderProducts(item);
        productContent.append(str);
    })
}
renderProducts = (product) => {
    return `
            <div class="col-md-3 mb-4 ">
                <div class="card d-flex align-items-center pt-2">
                    <img src="${product.img}" class="card-image-top"  style="width: 150px;height:120px">
                    <div class="card-body">
                        <p class="fw-bolder">${product.name}</p>
                        <div class="d-flex align-items-center justify-content-between">
                            <div>
                                <del class="line-through me-2">${product.prevPrice}</del>
                                <span>${product.newPrice}</span>
                            </div>
                            <button class="icon-button" id="${product.id}">
                                <i class="fa-solid fa-cart-arrow-down fa-lg"></i>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
            `;
};

async function fetchALlCategory() {
    return await $.ajax({
        url: page.url.getAllCategories,
        method: "GET",
        dataType: "json"
    })
}

getAllCategory = async () => {
    const categories = await fetchALlCategory();
    categories.forEach(item => {
        const str = renderCategories(item);
        categoryConten.append(str);
    })
}
renderCategories = (category) => {
    return `<div class="form-check py-1">
            <input class="form-check-input" type="radio" name="category" id="cat_${category.id}" value="${category.name}">
            <label for="cat_${category.id}" role="button" class="form-check-label ">${category.name}</label>
          </div>
            `;
};

async function fetchALlCompany() {
    return await $.ajax({
        url: page.url.getAllCompanies,
        method: "GET",
        dataType: "json"
    })
}

getAllCompany = async () => {
    const companies = await fetchALlCompany();
    companies.forEach(item => {
        const str = renderCompanies(item);
        companyContent.append(str);
    })
}
renderCompanies = (company) => {
    return `
        <button class="btn btn-sm btn-outline-secondary me-1 " type="button" id=cpn_${company.id} value="${company.name}">
            ${company.name}
        </button>
    `;
};

async function fetchALlPrice() {
    return await $.ajax({
        url: page.url.getAllPrices,
        method: "GET",
        dataType: "json"
    })
}

getAllPrice = async () => {
    const prices = await fetchALlPrice();
    prices.forEach(item => {
        const str = renderPrices(item);
        priceContent.append(str);
    })
}
renderPrices = (price) => {
    return `
    <div class="form-check py-1">
      <input class="form-check-input" type="radio" name="price" id="price_${price.id}" value="${price.value}">
      <label role="button" for="price_${price.id}" class="form-check-label ">${price.name}</label>
    </div>
    `;
};

async function fetchALlColor() {
    return await $.ajax({
        url: page.url.getAllColors,
        method: "GET",
        dataType: "json"
    })
}

getAllColor = async () => {
    const colors = await fetchALlColor();
    colors.forEach(item => {
        const str = renderColors(item);
        colorContent.append(str);
    })
}
renderColors = (color) => {
    return `
    <div class="form-check py-1">
      <input class="form-check-input" type="radio" name="color"
          id="color_${color.id}"value="${color.name}" style="background-color: ${color.name};">
      <label role="button" for="color_${color.id}" class="form-check-label ">${color.name}</label>
    </div>
    `;
};

$(async () => {
    await getAllCompany();
    await getAllCategory();
    await getAllPrice();
    await getAllColor();
    await getAllProduct();
    getOption();
    await renderPagination()


});

function getOption() {
    $(document).on("click", "button.btn-sm", async function () {
        $("button.btn-sm").removeClass("active");
        $(this).addClass("active");
        pageCurrent = 0;
        await filterProduct();
    });
    $(document).on("click", 'input[name="category"]', async function () {
        const labels = $('label[for^="cat_"]');
        labels.removeClass("text-decoration-underline fw-bolder");
        const selectedLabel = $(`label[for="${this.id}"]`);
        selectedLabel.addClass("text-decoration-underline fw-bolder");
        pageCurrent = 0;
        await filterProduct();
    });

    $(document).on("click", 'input[name="color"]', async function () {
        const labels = $('label[for^="color_"]');
        labels.removeClass("text-decoration-underline fw-bolder");
        const selectedLabel = $(`label[for="${this.id}"]`);
        selectedLabel.addClass("text-decoration-underline fw-bolder");
        pageCurrent = 0;
        await filterProduct();
    });
    $(document).on("click", 'input[name="price"]', async function () {
        const labels = $('label[for^="price_"]');
        labels.removeClass("text-decoration-underline fw-bolder");
        const selectedLabel = $(`label[for="${this.id}"]`);
        selectedLabel.addClass("text-decoration-underline fw-bolder");
        pageCurrent = 0;
        await filterProduct();
    });
    $(document).on("input", "input.form-control-sm", async function (event) {
        event.preventDefault();
        const inputSearch = $(this).val();
        pageCurrent = 0;
        await filterProduct();
    });
    $('#sortPrice').on("change", async function () {
            pageCurrent = 0;
            await filterProduct();
        }
    )
    $('#selectPage').on("change", async function () {
            pageCurrent = 0;
            await filterProduct();
        }
    )
}

async function filterProduct() {
    const inputSearch = searchProduct.val().trim();
    const inputCompany = $(".btn-sm.active").val();
    const inputColor = $('input[name="color"]:checked').val();
    const inputCategory = $('input[name="category"]:checked').val();

    const inputPrice = $('input[name="price"]:checked').val();
    const parts = inputPrice.split(",");
    const sortPrice = $('#sortPrice').find(":selected").val();
    const sizePage = $('#selectPage').find(":selected").val();
    const minPrice = parseInt(parts[0]);
    const maxPrice = parseInt(parts[1]);
    $.ajax({
        url: urlProduct,
        contentType: 'application/json',
        method: 'GET',
        data: {
            search: inputSearch,
            category: inputCategory,
            company: inputCompany,
            color: inputColor,
            maxPrice: maxPrice,
            minPrice: minPrice,
            page: pageCurrent,
            size: sizePage,
            sort: "newPrice," + sortPrice
        },
    }).done(function (filteredProducts) {
        productContent.empty();
        filteredProducts.content.forEach(item => {
            const str = renderProducts(item);
            productContent.append(str);
        })
        renderPagination(filteredProducts.totalPages)
    }).fail(function (jqXHR, textStatus, errorThrown) {
        console.log("lỗi")
    });
}

async function renderPagination(totalPages) {
    const page = $("#page");
    page.empty()
    for (let i = 0; i < totalPages; i++) {
        const strRenderPage = `<li class="page-item btn-get-page"><a class="page-link ${i === pageCurrent ? 'active' : ''}">${i + 1}</a></li>`
        page.append(strRenderPage)
    }
    $('.btn-get-page').on("click", function () {
        pageCurrent = parseInt(this.querySelector('.page-link').innerText) - 1;
        console.log(pageCurrent);
        filterProduct();
    })
}