package org.pixeltoparcel.controller;

import org.pixeltoparcel.service.ProductService;
import org.pixeltoparcel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/marketplace")
public class MarketplaceController {

    private final ProductService productService;
    private final UserService userService;

    @Autowired
    public MarketplaceController(ProductService productService, UserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    @GetMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "product-list";
    }

    @GetMapping("/product")
    public String viewProduct(@RequestParam("id") Long productId, Model model) {
        model.addAttribute("product", productService.getProductById(productId));
        return "product-view";
    }

    @PostMapping("/purchase")
    public String purchaseProduct(@RequestParam("productId") Long productId, @RequestParam("userId") Long userId) {
        return "purchase-confirmation";
    }
}
