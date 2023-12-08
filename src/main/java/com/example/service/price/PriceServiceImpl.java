package com.example.service.price;

import com.example.model.Price;
import com.example.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class PriceServiceImpl implements IPriceService{
    @Autowired
    private PriceRepository priceRepository;
    @Override
    public List<Price> findAll() {
        return null;
    }

    @Override
    public Optional<Price> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Price price) {

    }

    @Override
    public void update(Long id, Price price) {

    }
}
