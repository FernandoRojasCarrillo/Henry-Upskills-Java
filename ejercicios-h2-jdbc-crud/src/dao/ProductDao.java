package dao;

import dao.dto.ProductDto;
import entities.Product;

import java.util.List;

public interface ProductDao {
    // CREATE
    void insert(ProductDto product);

    // READ
    List<Product> getAll();

    // UPDATE
    void update(Product product);

    //DELETE
    void delete(int productId);
}
