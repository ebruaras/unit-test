package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product create(Product product){
        return productRepository.save(product);
    }
    public List<Product> listAll(){
        return productRepository.findAll();
    }
    public Product listById(int id){
        return productRepository.findById(id);
    }
    public void delete(Product product){
        productRepository.delete(product);
    }
}
