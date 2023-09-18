package dao.impl;

import config.JdbcConfiguration;
import dao.ProductDao;
import dao.dto.ProductDto;
import entities.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImplH2 implements ProductDao {

    private final Connection connection;

    public ProductDaoImplH2() {
        this.connection = JdbcConfiguration.getDBConnection();
    }

    @Override
    public void insert(ProductDto productDto) {
        try {

            Product newProduct = new Product();
            newProduct.setName(productDto.getName());
            newProduct.setPrice(productDto.getPrice());

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO product.product (name, price) VALUES (?, ?)");

            preparedStatement.setString(1, newProduct.getName());
            preparedStatement.setDouble(2, newProduct.getPrice());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM product.product");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");

                Product newProducto = new Product(id, name, price);
                products.add(newProducto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public void update(Product product) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE product.product SET name = ?, price = ? WHERE id = ?");

            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int productId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM product.product WHERE id = ?");

            preparedStatement.setInt(1, productId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
