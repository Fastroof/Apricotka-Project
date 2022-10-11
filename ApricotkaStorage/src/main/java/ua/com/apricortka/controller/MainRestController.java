package ua.com.apricortka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.com.apricortka.service.MainService;

@RestController
public class MainRestController {

    private final MainService mainService;

    @Autowired
    public MainRestController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/")
    public String alive() {
        return "Слава Україні \uD83C\uDDFA\uD83C\uDDE6!\nApricotka Storage";
    }

    // Category

    @GetMapping("/categories")
    public String getCategories() {
        return mainService.getCategories();
    }

    @PostMapping("/category")
    public String addCategory(String name) {
        return mainService.addCategory(name);
    }

    @PutMapping("/category/{id}")
    public String updateCategory(@PathVariable Long id, String name) {
        return mainService.updateCategory(id, name);
    }

    @DeleteMapping("/category/{id}")
    public String deleteCategory(@PathVariable Long id) {
        return mainService.deleteCategory(id);
    }

    // Product
//
//    @GetMapping("/products")
//    public String getProducts() {
//        return mainService.getProducts();
//    }
//
//    @PostMapping("/product")
//    public String addProduct(Long categoryId, String name, Long price) {
//        return mainService.addProduct(categoryId, name, price);
//    }
//
//    @DeleteMapping("/product/{id}")
//    public String deleteProduct(@PathVariable Long id) {
//        return mainService.deleteProduct(id);
//    }
}
