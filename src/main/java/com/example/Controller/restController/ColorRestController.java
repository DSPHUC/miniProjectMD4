package com.example.Controller.restController;

import com.example.model.Color;
import com.example.service.color.ColorServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/colors")
@AllArgsConstructor
public class ColorRestController {
    private final ColorServiceImpl colorService;

    @GetMapping
    public ResponseEntity<?> getAllProduct() {
        List<Color> colors = colorService.findAll();
        return new ResponseEntity<>(colors, HttpStatus.OK);
    }
}
