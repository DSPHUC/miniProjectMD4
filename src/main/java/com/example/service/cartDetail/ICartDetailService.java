package com.example.service.cartDetail;

import com.example.model.CartDetail;
import com.example.service.IGeneralService;

public interface ICartDetailService extends IGeneralService<CartDetail, Long> {
    void deleteById(Long id);
}
