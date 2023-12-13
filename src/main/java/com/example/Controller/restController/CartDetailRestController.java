package com.example.Controller.restController;

import com.example.model.CartDetail;
import com.example.model.Customer;
import com.example.model.Product;
import com.example.model.dto.CartDetailCreDTO;
import com.example.repository.CartDetailRepository;
import com.example.repository.CartRepository;
import com.example.repository.CustomerRepository;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cartDetail")
public class CartDetailRestController {
    @Autowired
    private CartDetailRepository cartDetailRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping
    public ResponseEntity<?> createCartDetail(@RequestBody CartDetailCreDTO cartDetailCreDTO) {
        Product product = productRepository.findById(cartDetailCreDTO.getIdProduct()).get();
        if (cartDetailRepository.existsByProduct_Id(cartDetailCreDTO.getIdProduct())) {
            CartDetail cartDetail = cartDetailRepository.getCartDetailByProduct_Id(cartDetailCreDTO.getIdProduct());
            Integer quantityNew = cartDetail.getQuantity() + 1;
            cartDetail.setQuantity(quantityNew);
            cartDetailRepository.save(cartDetail);
        } else {
            CartDetail cartDetail = new CartDetail();
            cartDetail.setCart(cartRepository.findById(1L).get())
                    .setQuantity(1).setProduct(product).setAmount(product.getNewPrice());
            cartDetailRepository.save(cartDetail);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllCartDetail() {
        Long idUser = 1L;
        Customer customer = customerRepository.findById(idUser).get();
        List<CartDetail> cartDetails = cartDetailRepository.findAllByCart_Id(customer.getId());
        return new ResponseEntity<>(cartDetails, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idCartDetail}")
    public ResponseEntity<?> deleteCartDetail(@PathVariable Long idCartDetail) {
        cartDetailRepository.deleteById(idCartDetail);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}