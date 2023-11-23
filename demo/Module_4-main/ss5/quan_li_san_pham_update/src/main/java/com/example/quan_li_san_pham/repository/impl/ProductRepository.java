package com.example.quan_li_san_pham.repository.impl;

import com.example.quan_li_san_pham.model.Product;
import com.example.quan_li_san_pham.repository.IProductRepository;
import com.example.quan_li_san_pham.utils.ConnectionUltis;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.transaction.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
//    public static final List<Product> list = new ArrayList<>();
//
//    //    Integer id, String name, double price, String status, String producer
//    static {
//        list.add(new Product(1, "AF1", 1000, "Used", "Nike"));
//        list.add(new Product(2, "UltraBoots", 1200, "Used", "Adidas"));
//        list.add(new Product(3, "AirMax 97", 2000, "New", "Nike"));
//        list.add(new Product(4, "AF1", 1400, "New", "Nike"));
//        list.add(new Product(5, "Jordan 1", 9990, "New", "Nike"));
//    }

    private static final String SELECT_ALL_PRODUCTS = "FROM Product"; // HQL
    private static final String SELECT_BY_ID = "SELECT p FROM Product AS p WHERE p.id = :id";
    private static final String SELECT_BY_NAME = "SELECT p FROM Product AS p WHERE p.name like :name";

    @Override
    public List<Product> getProduct() {
        return ConnectionUltis.entityManager().createQuery(SELECT_ALL_PRODUCTS).getResultList();
    }

    @Override
    public Product findById(int id) {
        TypedQuery<Product> productTypedQuery = ConnectionUltis.entityManager().createQuery(SELECT_BY_ID, Product.class);
        productTypedQuery.setParameter("id", id);
        for (Product p : productTypedQuery.getResultList()) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void createProduct(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUltis.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        } catch (Exception ex) {
            ex.getStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void update(Product product) {
        if (product.getId() != null) {
            ConnectionUltis.entityManager().merge(product);
        } else {
            ConnectionUltis.entityManager().persist(product);
        }
    }

    @Override
    public void delete(int id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUltis.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Product product = findById(id);
            session.remove(product);
            transaction.commit();
        } catch (Exception ex) {
            ex.getStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Product> findByName(String name) {
        TypedQuery<Product> productTypedQuery = ConnectionUltis.entityManager().createQuery(SELECT_BY_NAME, Product.class);
        productTypedQuery.setParameter("name", name);
        return productTypedQuery.getResultList();
    }

}
