package iziPak.components;

import iziPak.entity.Product;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;
import java.util.Random;


@SessionScope
@Component
public class Cart {

    private List<Product> productList;

}
