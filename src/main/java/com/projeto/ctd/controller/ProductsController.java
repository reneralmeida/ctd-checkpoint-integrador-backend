package com.projeto.ctd.controller;

import com.projeto.ctd.dto.ProductDTO;
import com.projeto.ctd.models.Product;
import com.projeto.ctd.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    IService<Product> service;

    @GetMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<ProductDTO>> getAll(){
        return ResponseEntity.ok(
                service.getAll().stream().map(ProductDTO::productToDTO).collect(Collectors.toList())
        );
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<ProductDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(
               ProductDTO.productToDTO(service.getById(id))
        );
    }

    @GetMapping("/category/{type}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<ProductDTO>> getByType(@PathVariable String type){
        return ResponseEntity.ok(
                service.getAllByName(type).stream().map(ProductDTO::productToDTO).collect(Collectors.toList())
        );
    }

}
