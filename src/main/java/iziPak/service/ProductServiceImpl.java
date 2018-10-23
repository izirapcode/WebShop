package iziPak.service;

import com.sun.org.apache.xpath.internal.operations.Or;
import iziPak.dao.OrderDao;
import iziPak.dao.ProductDao;
import iziPak.entity.Account;
import iziPak.entity.Order;
import iziPak.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    OrderDao orderDao;

    @Autowired
    ProductDao productDao;

    @Override
    @Transactional
    public List<Order> getOrders(String user){
        return orderDao.getOrders(user);
    }

    @Override
    @Transactional
    public List<Product> getProducts() {
        return productDao.getProducts();
    }

    @Override
    @Transactional
    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    @Override
    @Transactional
    public Product getProduct(int id) {
        return productDao.getProduct(id);
    }

    @Override
    @Transactional
    public void deleteProduct(int id) {
        productDao.deleteProduct(id);

    }
}
