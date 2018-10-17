package iziPak.dao;


import iziPak.entity.Product;
import java.util.List;

public interface ProductDao {

    List<Product> getProducts();

    void addProduct(Product product);

    Product getProduct(int id);

    void deleteProduct(int id);

}
