package iziPak.dao;


import iziPak.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface OrderDao {

    List<Order> getOrders(String user);

    void registerOrder(Order order);

    Order getOrder(int id);

    void deleteOrder(int id);
}
