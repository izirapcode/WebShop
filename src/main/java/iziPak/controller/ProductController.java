package iziPak.controller;


import iziPak.entity.NewAccountForm;
import iziPak.entity.Product;
import iziPak.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

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

}
