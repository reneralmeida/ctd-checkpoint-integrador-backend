package com.projeto.ctd.service.impl;

import com.projeto.ctd.exception.ResourceNotFoundException;
import com.projeto.ctd.models.Category;
import com.projeto.ctd.repository.CategoryRepository;
import com.projeto.ctd.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements IService<Category> {

    @Autowired
    CategoryRepository repository;

    @Override
    public List<Category> getAll() {
        return repository.findAll();
    }

    @Override
    public Category getById(Long id) {
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Categoria não encontrada"));
    }

    @Override
    public List<Category> getAllByName(String type) {
        return repository.findByNameLikeIgnoreCase(type);
    }

}
