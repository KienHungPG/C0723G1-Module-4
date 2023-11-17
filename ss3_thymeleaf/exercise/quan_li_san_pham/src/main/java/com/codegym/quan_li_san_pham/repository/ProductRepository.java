package com.codegym.quan_li_san_pham.repository;

import com.codegym.quan_li_san_pham.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepository implements IProductRepository{
    public static final List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product(1,"IPhone 15 Pro Max",1199,"Natural Titanium","LL/A"));
        productList.add(new Product(2,"IPhone 15 Pro ",999,"Black Titianium","LL/A"));
        productList.add(new Product(3,"IPhone 15 Plus",899,"Pink","LL/A"));
        productList.add(new Product(4,"IPhone 15",799,"Yellow","LL/A"));
        productList.add(new Product(5,"IPhone SE",429,"Red","LL/A"));

    }
    @Override
    public List<Product> getAll() {
        return productList;
    }

    @Override
    public void add(Product product) {
        product.setId(productList.get(productList.size()-1).getId()+1);
        productList.add(product);
    }

    @Override
    public void update(Product product) {
        for (Product product1 : productList) {
            if (product.getId() == product1.getId()){
                product1.setName(product.getName());
                product1.setPrice(product.getPrice());
                product1.setDescription(product.getDescription());
                product1.setManufacturer(product.getManufacturer());
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        for (Product product : productList){
            if (product.getId() == id){
                productList.remove(product);
                break;
            }
        }
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> product = new ArrayList<>();
        for (Product product1 : productList) {
            if (product1.getName().contains(name)){
                product.add(product1);
            }
        }
        return product;
    }

    @Override
    public Product searchById(int id) {
        for (Product product : productList) {
            if (product.getId() == id){
                return product;
            }
        }
        return null;
    }
}
