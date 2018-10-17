package iziPak.dao;

import iziPak.entity.Account;
import iziPak.entity.Product;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Product> getProducts() {

        Session session = sessionFactory.getObject().getCurrentSession();
        return session.createQuery("from Product ", Product.class).getResultList();

    }

    @Override
    public void addProduct(Product product) {

        Session session = sessionFactory.getObject().getCurrentSession();
        session.saveOrUpdate(product);

    }

    @Override
    public Product getProduct(int id) {

        Session session = sessionFactory.getObject().getCurrentSession();
        return session.get(Product.class, id);

    }

    @Override
    public void deleteProduct(int id) {

        Session session = sessionFactory.getObject().getCurrentSession();
        session.delete(session.get(Account.class, id));

    }

}
