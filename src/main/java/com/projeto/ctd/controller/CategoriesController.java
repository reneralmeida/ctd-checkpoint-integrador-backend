package com.projeto.ctd.controller;

import com.projeto.ctd.dto.CategoryDTO;
import com.projeto.ctd.models.Category;
import com.projeto.ctd.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class CategoriesController {

    @Autowired
    private IService<Category> service;

    @GetMapping("/products/categories")
    public ResponseEntity<List<String>> getAll(){
        return ResponseEntity.ok(
                service.getAll().stream().map( CategoryDTO::categoryToDTO).map( CategoryDTO::getName).collect(Collectors.toList())
        );
    }

}
