package com.ra.model.dao;

import com.ra.model.entity.Product;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.ra.util.ConnectionDB.*;

public class ProductDAO implements IGenericDAO<Product, Integer> {

    @Override
    public List<Product> getAll() {
        Connection connection = null;
        List<Product> products = new ArrayList<>();
        try {
            connection = openConnection();
            CallableStatement callableStatement = connection.prepareCall("{CALL PROC_GET_ALL_PRODUCT()}");
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next())
                products.add(new Product(resultSet.getInt("productId"), resultSet.getString("productName"), resultSet.getString("description")));
        } catch (SQLException e) {
            System.out.println("Lỗi 3");
        } finally {
            closeConnection(connection);
        }
        return products;
    }

    @Override
    public boolean save(Product product) {
        Connection connection = null;
        try {
            connection = openConnection();
            CallableStatement callableStatement = connection.prepareCall("{CALL PROC_INSERT_PRODUCT(?,?)}");
            callableStatement.setString(1, product.getProductName());
            callableStatement.setString(2, product.getDescription());
            int count = callableStatement.executeUpdate();
            if (count > 0) return true;
        } catch (SQLException e) {
            System.out.println("Lỗi 4");
        } finally {
            closeConnection(connection);
        }
        return false;
    }

    @Override
    public boolean save(Product product, Integer integer) {
        Connection connection = null;
        try {
            connection = openConnection();
            CallableStatement callableStatement = connection.prepareCall("{CALL PROC_UPDATE_PRODUCT(?,?,?)}");
            callableStatement.setString(1, product.getProductName());
            callableStatement.setString(2, product.getDescription());
            callableStatement.setInt(3, integer);
            int count = callableStatement.executeUpdate();
            if (count > 0) return true;
        } catch (SQLException e) {
            System.out.println("Lỗi 5");
        } finally {
            closeConnection(connection);
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        Connection connection = null;
        try {
            connection = openConnection();
            CallableStatement callableStatement = connection.prepareCall("{CALL PROC_DELETE_PRODUCT(?)}");
            callableStatement.setInt(1, id);
            int count = callableStatement.executeUpdate();
            if (count > 0) return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection(connection);
        }
        return false;
    }

    @Override
    public Product findById(Integer id) {
        Connection connection = null;
        Product product = new Product();
        try {
            connection = openConnection();
            CallableStatement callableStatement = connection.prepareCall("{CALL PROC_FIND_PRODUCT(?)}");
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                product.setProductId(resultSet.getInt("productId"));
                product.setProductName(resultSet.getString("productName"));
                product.setDescription(resultSet.getString("description"));
            }
        } catch (SQLException e) {
            System.out.println("Lỗi 7");
        } finally {
            closeConnection(connection);
        }
        return product;
    }
}
;