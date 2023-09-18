package controller;

import dao.ProductDao;
import dao.dto.ProductDto;
import dao.impl.ProductDaoImplH2;
import entities.Product;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDaoImplH2();

        // Product product = new Product(7, "Samsung Galaxy", 350.00);

        // productDao.insert(productDto);
        //productDao.update(product);

        productDao.delete(7);

        List<Product> products = productDao.getAll();
        for (Product item : products) {
            System.out.println("ID: " + item.getId());
            System.out.println("Nombre: " + item.getName());
            System.out.println("Precio: " + item.getPrice());
            System.out.println("---------------------------");
        }
    }
}