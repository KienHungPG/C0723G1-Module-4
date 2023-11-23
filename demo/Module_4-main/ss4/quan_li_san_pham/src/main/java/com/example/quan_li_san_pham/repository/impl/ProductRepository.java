package com.example.quan_li_san_pham.repository.impl;

import com.example.quan_li_san_pham.model.Product;
import com.example.quan_li_san_pham.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    public static final List<Product> list = new ArrayList<>();

    //    Integer id, String name, double price, String status, String producer
    static {
        list.add(new Product(1, "AF1", 1000, "Used", "Nike"));
        list.add(new Product(2, "UltraBoots", 1200, "Used", "Adidas"));
        list.add(new Product(3, "AirMax 97", 2000, "New", "Nike"));
        list.add(new Product(4, "AF1", 1400, "New", "Nike"));
        list.add(new Product(5, "Jordan 1", 9990, "New", "Nike"));
    }

    @Override
    public List<Product> getProduct() {
        return list;
    }

    @Override
    public Product findById(int id) {
        for (Product p : list) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void createProduct(Product product) {
        product.setId(list.size() + 1);
        list.add(product);
    }

    @Override
    public void update(Product product) {
        for (Product p : list) {
            if (product.getId() == p.getId()) {
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                p.setStatus(product.getStatus());
                p.setProducer(product.getProducer());
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        for (Product p : list) {
            if (p.getId() == id) {
                list.remove(p);
                break;
            }
        }
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> list = new ArrayList<>();
        for (Product p : ProductRepository.list) {
            if (p.getName().contains(name)) {
                list.add(p);
            }
        }
        return list;
    }
}
