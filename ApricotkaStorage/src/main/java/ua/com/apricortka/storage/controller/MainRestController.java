package ua.com.apricortka.storage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.apricortka.storage.entity.Product;
import ua.com.apricortka.storage.entity.ProductWithImages;
import ua.com.apricortka.storage.pojo.Available;
import ua.com.apricortka.storage.service.MainService;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@RestController
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

    @Value("${link.to.service.image.storage}")
    private String linkToImageStorage;

    @Value("${link.to.service.security}")
    private String linkToSecurity;

    @GetMapping("/test/mail")
    public boolean checkAliveMessenger() {
        return mainService.sendMessage("lytvdan@gmail.com", "ApricotkaStorage", "Слава Україні \uD83C\uDDFA\uD83C\uDDE6!");
    }

    @ResponseBody
    @GetMapping("/alive/services")
    public ResponseEntity<Boolean> checkLiveServices() {
        System.out.println(linkToImageStorage);
        System.out.println(linkToSecurity);
        boolean alive = false;
        try {
            alive = okReq(linkToImageStorage) && okReq(linkToSecurity);
            System.out.println(okReq(linkToImageStorage));
            System.out.println(okReq(linkToSecurity));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (alive) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
    }

    private boolean okReq(String link) throws IOException {
        URL url = new URL(link);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        return responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_UNAUTHORIZED;
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

    @GetMapping("/incomings")
    public String getIncomings() {
        return mainService.getIncomings();
    }

    @GetMapping("/incoming/{productId}")
    public String getIncomingByProductId(@PathVariable Long productId) {
        return mainService.getIncomingByProductId(productId);
    }

    @GetMapping("/how/many/{productId}")
    public String getHowManyByProductId(@PathVariable Long productId) throws Exception {
        return mainService.getHowManyByProductId(productId);
    }

    @GetMapping("/how/many/all")
    public List<Available> getHowManyAll() {
        return mainService.getHowManyAll();
    }

    @PostMapping("/incoming")
    public String addIncoming(Long productId, String supplier, Double initial_price, Long quantity) {
        return mainService.addIncoming(productId, supplier, initial_price, quantity);
    }

    @PutMapping("/incoming/{id}")
    public String updateIncoming(@PathVariable Long id, Long quantity) {
        return mainService.updateIncoming(id, quantity);
    }

    @DeleteMapping("/incoming/{id}")
    public String deleteIncoming(@PathVariable Long id) {
        return mainService.deleteIncoming(id);
    }
}
