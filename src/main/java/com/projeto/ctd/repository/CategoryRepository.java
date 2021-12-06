package com.projeto.ctd.repository;

import com.projeto.ctd.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query
    public List<Category> findByNameLikeIgnoreCase(String type);
}