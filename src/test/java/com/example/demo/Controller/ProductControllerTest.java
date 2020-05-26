package com.example.demo.Controller;

import com.example.demo.controller.ProductController;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {
    @InjectMocks
    ProductController productController;
    @Mock
    ProductService productService;
    @Mock
    Product product;

    private static final int ID=3;

    @Test
   public void getAllProducts() {
        product.setProductName("test-name");
        product.setAmount(2500.0);
        product.setId(5);
        List<Product> productList=new ArrayList<>();
        productList.add(product);
        when(productService.listAll()).thenReturn(productList);
        assertEquals(productController.getAllProducts().getBody().size(),productList.size());
    }

    @Test
    public void getProductById() {
        when(productService.listById(ID)).thenReturn(product);
        assertEquals(productController.getProductById(ID).getBody(),product);
    }

    @Test
    public void createProduct() {
        product.setId(9);
        product.setAmount(6200.4);
        product.setProductName("test-product");
        when(productService.create(product)).thenReturn(product);
        assertEquals(productController.createProduct(product).getStatusCode(),HttpStatus.CREATED);
    }

    @Test
    public void deleteProduct() {
        when(productService.listById(ID)).thenReturn(product);
        assertEquals(productController.deleteProduct(ID).getStatusCode(),HttpStatus.OK);
    }
}