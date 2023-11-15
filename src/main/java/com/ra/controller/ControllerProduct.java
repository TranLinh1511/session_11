package com.ra.controller;

import com.ra.model.entity.Product;
import com.ra.model.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/product")
public class ControllerProduct {
    private final ProductService productService = new ProductService();

    @RequestMapping(value = "")
    private String product(Model model) {
        List<Product> products = productService.getAll();
        model.addAttribute("products", products);
        return "product";
    }

    @RequestMapping(value = "/form-add")
    private String formProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "form-add-product";
    }

    @RequestMapping(value = "/form-update/{id}")
    private String formUpdateProduct(Model model, @PathVariable("id") int id) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "form-update-product";
    }

    @RequestMapping(value = "/save/{id}")
    private String save(@ModelAttribute("product") Product product, @PathVariable("id") int id) {
        if (id == -1) {
            productService.save(product);
        } else {
            productService.save(product, id);
        }
        return "redirect:/product";
    }

    @RequestMapping(value = "/delete/{id}")
    private String delete(@PathVariable("id") int id) {
        productService.delete(id);
        return "redirect:/product";
    }

}
