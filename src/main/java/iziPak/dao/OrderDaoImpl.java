package iziPak.dao;

import iziPak.entity.Order;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;


    @Override
    public List<Order> getOrders(String user) {
        Session session = sessionFactory.getObject().getCurrentSession();
        return  session.createQuery("from Order where account ='" + user+"'", Order.class).getResultList();
    }

    @Override
    public void registerOrder(Order order) {

    }

    @Override
    public Order getOrder(int id) {
        return null;
    }

    @Override
    public void deleteOrder(int id) {

    }
}
