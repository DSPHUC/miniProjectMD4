package com.example.service.color;

import com.example.model.Color;
import com.example.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ColorServiceImpl implements IColorService {

    @Autowired
    private ColorRepository colorRepository;

    @Override
    public List<Color> findAll() {
        return colorRepository
                .findAll()
               /* .stream()
                .map(
                        color -> new ColorResponse(
                                color.getId().toString()
                                ,color.getName()))
                .collect(
                        Collectors
                                .toList())*/;
    }

    @Override
    public Optional<Color> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Color color) {

    }

    @Override
    public void update(Long id, Color color) {

    }
}
