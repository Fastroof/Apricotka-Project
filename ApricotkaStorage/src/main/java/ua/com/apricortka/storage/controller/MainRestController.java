package ua.com.apricortka.storage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.com.apricortka.storage.entity.Product;
import ua.com.apricortka.storage.entity.ProductWithImages;
import ua.com.apricortka.storage.enums.OrderStatus;
import ua.com.apricortka.storage.enums.OrderType;
import ua.com.apricortka.storage.service.MainService;

@RestController()
@RequestMapping(produces="application/json")
@CrossOrigin(origins = "*")
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

    @GetMapping("/products")
    public String getProducts() {
        return mainService.getProducts();
    }

    @GetMapping("/products-without-incoming")
    public Iterable<Product> getProductsWithoutIncoming() {
        return mainService.getProductsWithoutIncoming();
    }

    @PostMapping("/product")
    public String addProduct(Long categoryId, String name, Double price, String info) {
        return mainService.addProduct(categoryId, name, price, info);
    }

    @PutMapping("/product/{id}")
    public String updateProduct(@PathVariable Long id, Long categoryId, String name, Double price, String info) {
        return mainService.updateProduct(id, categoryId, name, price, info);
    }

    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable Long id) {
        return mainService.deleteProduct(id);
    }

    // Product Images

    @GetMapping("/products-images")
    public String getProductImages() {
        return mainService.getAllProductImages();
    }

    @GetMapping("/product-with-images/{id}")
    public ProductWithImages getProductWithImages(@PathVariable Long id) {
        return mainService.getProductWithImagesById(id);
    }

    @GetMapping("/product-images/{id}")
    public String getProductImagesById(@PathVariable Long id) {
        return mainService.getProductImages(id);
    }

    // Incoming Product Details

    @GetMapping("/incoming/{productId}")
    public String getIncomingByProductId(@PathVariable Long productId) {
        return mainService.getIncomingByProductId(productId);
    }

    @PostMapping("/incoming")
    public String addIncoming(Long productId, String supplier, Double initial_price, Long quantity) {
        return mainService.addIncoming(productId, supplier, initial_price, quantity);
    }

    @PutMapping("/incoming/{id}")
    public String updateIncoming(@PathVariable Long id, Long productId, String supplier, Double initial_price, Long quantity) {
        return mainService.updateIncoming(id, productId, supplier, initial_price, quantity);
    }

    @DeleteMapping("/incoming/{id}")
    public String deleteIncoming(@PathVariable Long id) {
        return mainService.deleteIncoming(id);
    }

    // Order Item

    @GetMapping("/order-item/{id}")
    public String getOrderItemById(@PathVariable Long id) {
        return mainService.getOrderItemById(id);
    }

    @PostMapping("/order-item")
    public String addOrderItem(Long productId, Double initial_price, Long exQuantity, Double price, Long orderId) {
        return mainService.addOrderItem(productId, initial_price, exQuantity, price, orderId);
    }

    @DeleteMapping("/order-item/{id}")
    public String deleteOrderItem(@PathVariable Long id) {
        return mainService.deleteOrderItem(id);
    }

    // Order

    @GetMapping("/orders")
    public String getAllOrders() {
        return mainService.getAllOrders();
    }

    @GetMapping("/order/{id}")
    public String getOrderById(@PathVariable Long id) {
        return mainService.getOrderById(id);
    }

    @GetMapping("/order/user/{user_id}")
    public String getOrderByUserId(@PathVariable Long user_id) {
        return mainService.getOrderByUserId(user_id);
    }

    @PostMapping("/order")
    public String createOrder(OrderStatus status, OrderType type, Long user_id) {
        return mainService.createOrder(status, type, user_id);
    }

    @PutMapping("/order/{id}")
    public String updateOrderStatus(@PathVariable Long id, OrderStatus status) {
        return mainService.updateOrderStatus(id, status);
    }

}
