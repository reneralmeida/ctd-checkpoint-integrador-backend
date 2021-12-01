package com.projeto.ctd.utils;

import com.projeto.ctd.models.Category;
import com.projeto.ctd.models.Product;
import com.projeto.ctd.repository.CategoryRepository;
import com.projeto.ctd.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader implements ApplicationRunner {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public DataLoader(ProductRepository productRepository,CategoryRepository categoryRepository ) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public void run(ApplicationArguments args) {

        Category eletronicos = new Category("Eletronicos");
        Category smartphone = new Category("Smartphone");

        //Categories inital data
        categoryRepository.save(eletronicos);
        System.out.println(categoryRepository.save(smartphone));
        //Products inital data
        productRepository.save(new Product(null,1300.d,"Monitor","4k","https://google.com",eletronicos));
    }
}
