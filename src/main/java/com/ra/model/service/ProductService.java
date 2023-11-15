package com.ra.model.service;
import com.ra.model.dao.ProductDAO;
import com.ra.model.entity.Product;

import java.util.List;

public class ProductService implements IGenericService<Product, Integer> {
    ProductDAO productDAO = new ProductDAO();


    @Override
    public List<Product> getAll() {
        return productDAO.getAll();
    }

    @Override
    public boolean save(Product product) {
        return productDAO.save(product);
    }

    @Override
    public boolean save(Product product, Integer integer) {
        return productDAO.save(product,integer);
    }

    @Override
    public boolean delete(Integer integer) {
        return productDAO.delete(integer);
    }

    @Override
    public Product findById(Integer integer) {
        return productDAO.findById(integer);
    }
}
