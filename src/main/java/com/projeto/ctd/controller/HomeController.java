package com.projeto.ctd.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public ResponseEntity<String> home(){
        return ResponseEntity.ok(
                "/products -> Todos os produtos cadastrados em um JSON " +
                        "/products/{id} -> Dados de um produto específico em um JSON " +
                        "/products/categories -> Todas categorias em um JSON " +
                        "/products/category/{category} ->  Os produtos de uma determinada categoria, em um JSON ");
    }
}
