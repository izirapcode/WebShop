package iziPak.service;

import iziPak.entity.Account;
import iziPak.entity.Order;
import iziPak.entity.Product;

import java.util.List;

public interface ProductService {

    public List<Order> getOrders(String user);

    List<Product> getProducts();

    void addProduct(Product product);

    Product getProduct(int id);

    void deleteProduct(int id);
}
