package com.codegym.quan_ly_san_pham.repository;

import com.codegym.quan_ly_san_pham.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> getAll() {
        List<Product> productList;
        TypedQuery<Product> query = entityManager.createQuery("from Product", Product.class);
//        TypedQuery<Product> query = entityManager.createNativeQuery("select  * from product", Product.class);
        productList = query.getResultList();
        return productList;
    }

    @Transactional
    @Override
    public void add(Product product) {
        entityManager.persist(product);
    }

    @Transactional
    @Override
    public void update(Product product) {
        Product productUpdate = searchById(product.getId());
        if (productUpdate != null) {
            productUpdate.setName(product.getName());
            productUpdate.setPrice(product.getPrice());
            productUpdate.setDescription(product.getDescription());
            productUpdate.setManufacturer(product.getManufacturer());
            entityManager.merge(productUpdate);
        }
    }

    @Transactional
    @Override
    public void delete(int id) {
        Product productDelete = searchById(id);
        if (productDelete != null) {
            entityManager.remove(productDelete);
        }
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> products;
        String sqlQuery = "select p from Product p where p.name like :name";

        try {
            TypedQuery<Product> query = entityManager.createQuery(sqlQuery,Product.class);
            query.setParameter("name", "%" + name + "%");
            products = query.getResultList();
        } catch (Exception e) {
            return null;
        }

        return products;
    }

    @Override
    public Product searchById(int id) {
        return entityManager.find(Product.class, id);
    }
}
