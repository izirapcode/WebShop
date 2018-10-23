package iziPak.controller;


import iziPak.components.Cart;
import iziPak.entity.Account;
import iziPak.entity.Order;
import iziPak.entity.Product;
import iziPak.service.AccountService;
import iziPak.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.HashSet;


@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    AccountService accountService;

    @Autowired
    Cart cart;

    @RequestMapping("/product")

    public String productPage(@RequestParam("id") int id,
                              Model model){

        model.addAttribute("product",productService.getProduct(id));
        return "product";
    }

    @RequestMapping("/add-product")
    public String addNewProduct(Model model){

        model.addAttribute("product",new Product());
        return "add-product";
    }

    @RequestMapping("/process-product")
    public String saveNewProdduct(@ModelAttribute("product") Product product,
                                  Model model){

        productService.addProduct(product);
        model.addAttribute("product",product);
        return "product";
    }


    @RequestMapping("/cart")
    public String cartPage(Model model){

        model.addAttribute("cart", cart);
        return "cart-page";
    }

    @RequestMapping("/buyProduct")
    public String buyProduct(@RequestParam("id") int id,
                             Model model){

        cart.add(productService.getProduct(id));
        model.addAttribute("products",productService.getProducts());
        return "home";

    }

    @RequestMapping("/orders")
    public String ordersPage(Model model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Account account = accountService.getAccount(name);
        model.addAttribute("user",productService.getOrders(account.getUsername()));
        return "orders";
    }

    @RequestMapping("/buyCart")
    public String buyCart(Model model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Account account = accountService.getAccount(name);
        account.setOrders(new HashSet<Order>(productService.getOrders(name)));
        Order order = new Order();
        order.setProducts(cart.getProductList());
        order.setDate(new Date());
        account.addOrder(order);
        accountService.registerAccount(account);
        model.addAttribute("products",productService.getProducts());
        cart.clearCart();
        return "home";
    }

}
