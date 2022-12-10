package com.OOPSg22.major.controller;

import com.OOPSg22.major.global.GlobalData;
import com.OOPSg22.major.model.Product;
import com.OOPSg22.major.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CartController {
    @Autowired
    ProductService productService;

    @GetMapping("/addToCart/{id}")
    public String addtoCart(@PathVariable Long id) {
        GlobalData.cart.add(productService.getProductById(id).get());
        return "redirect:/shop";
    }

    @GetMapping("/cart")
    public String cartGet(Model model) {
        model.addAttribute("cartCount", GlobalData.cart.size());
        // double total_price=GlobalData.cart.stream().mapToDouble(Product::getPrice).sum();
        model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
        model.addAttribute("cart", GlobalData.cart);
        return "cart";
    }

    @GetMapping("/cart/removeItem/{index}")
    public String cartItemRemove(@PathVariable int index) {
        GlobalData.cart.remove(index);
        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
        return "checkout";
    }

    @GetMapping("/checkout2")
    public String checkout2(Model model) {
        double total_price=GlobalData.cart.stream().mapToDouble(Product::getPrice).sum();
        total_price-=total_price/10;
        model.addAttribute("total", total_price);
        return "checkout2";
    }
}

