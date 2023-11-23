package com.example.quan_li_san_pham.service.impl;

import com.example.quan_li_san_pham.model.Product;
import com.example.quan_li_san_pham.repository.IProductRepository;
import com.example.quan_li_san_pham.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> getProduct() {
        return iProductRepository.getProduct();
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void createProduct(Product product) {
        iProductRepository.createProduct(product);
    }

    @Override
    public void update(Product product) {
        iProductRepository.update(product);
    }

    @Override
    public void delete(int id) {
        iProductRepository.delete(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return iProductRepository.findByName(name);
    }
}
