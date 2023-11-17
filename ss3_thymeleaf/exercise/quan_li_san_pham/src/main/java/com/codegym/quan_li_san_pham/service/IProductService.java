package com.codegym.quan_li_san_pham.service;

import com.codegym.quan_li_san_pham.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    void add(Product product);
    void update(Product product);
    void delete(int id);
    List<Product> searchByName(String name);
    Product searchById(int id);

}
