package com.codegym.quan_ly_san_pham.repository;

import com.codegym.quan_ly_san_pham.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAll();
    void add(Product product);
    void update(Product product);
    void delete(int id);
    List<Product> searchByName(String name);
    Product searchById(int id);

}
