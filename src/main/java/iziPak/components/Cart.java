package iziPak.components;

import iziPak.entity.Product;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;


@SessionScope
@Component
public class Cart {

    private List<Product> productList;

    public Cart(){
        productList = new LinkedList<>();
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void add(Product product){
        productList.add(product);
    }

    public void clearCart(){
        productList.clear();
    }
}
