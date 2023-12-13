package com.example.service.cartDetail;

import com.example.model.CartDetail;
import com.example.repository.CartDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CartDetailServiceImpl implements ICartDetailService {
    @Autowired
    private CartDetailRepository cartDetailRepository;

    @Override
    public List<CartDetail> findAll() {
        return cartDetailRepository.findAll();
    }

    @Override
    public Optional<CartDetail> findById(Long id) {
        return cartDetailRepository.findById(id);
    }

    @Override
    public void save(CartDetail cartDetail) {
        cartDetailRepository.save(cartDetail);
    }

    @Override
    public void update(Long id, CartDetail cartDetail) {
    }

    @Override
    public void deleteById(Long id) {
        cartDetailRepository.deleteById(id);
    }
}
