package com.example.zadanie21;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    private List<Product> products;

    public ProductController() {
        products = new ArrayList<>();
        products.add(new Product("masło", 4.49, Category.FOOD));
        products.add(new Product("mleko", 7.49, Category.FOOD));
        products.add(new Product("krzesło", 250.00, Category.HOME));
        products.add(new Product("stół", 350.00, Category.HOME));
        products.add(new Product("łopata", 79.49, Category.OTHER));
        products.add(new Product("sznurek", 4.48, Category.OTHER));
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("product", new Product());
        return "index";
    }


    @PostMapping("/add")
    public String add(Product product) {
        products.add(product);
        return "redirect:/";
    }

    @GetMapping("/list")
    public String list(@RequestParam(required = false) Category category, Model model) {
        List<Product> displayProducts = new ArrayList<>();
        double priceSum = 0.0;
        if (category == null) {
            displayProducts = products;
            priceSum = sumAllProductPrices();
        } else {
            for (Product product : products) {
                if (product.getCategory().equals(category)) {
                    displayProducts.add(product);
                    priceSum += product.getPrice();
                }
            }
        }
        model.addAttribute("products", displayProducts);
        model.addAttribute("priceSum", priceSum);
        return "list";
    }

    private double sumAllProductPrices() {
        double result = 0.0;
        for (Product product : products) {
            result += product.getPrice();
        }
        return result;
    }
}
