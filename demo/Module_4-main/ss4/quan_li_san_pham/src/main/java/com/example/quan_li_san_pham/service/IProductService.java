package com.example.quan_li_san_pham.service;

import com.example.quan_li_san_pham.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getProduct();

    Product findById(int id);

    void createProduct(Product product);

    void update(Product product);

    void delete(int id);

    List<Product> findByName(String name);
}
