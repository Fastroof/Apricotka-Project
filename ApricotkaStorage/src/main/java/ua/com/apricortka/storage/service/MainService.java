package ua.com.apricortka.storage.service;

import org.springframework.stereotype.Service;
import ua.com.apricortka.storage.entity.Product;
import ua.com.apricortka.storage.entity.ProductWithImages;
import ua.com.apricortka.storage.pojo.Available;

import java.util.List;

@Service
public interface MainService {
    String getCategories();
    String addCategory(String name);
    String updateCategory(Long id, String name);
    String deleteCategory(Long id);
    String getProducts();
    Iterable<Product> getProductsWithoutIncoming();
    String addProduct(Long categoryId, String name, Double price, String info);
    String updateProduct(Long id, Long categoryId, String name, Double price, String info);
    String deleteProduct(Long id);
    String getAllProductImages();
    String getIncomings();
    ProductWithImages getProductWithImagesById(Long id);
    String getProductImages(Long id);
    String getIncomingByProductId(Long productId);
    String addIncoming(Long productId, String supplier, Double initial_price, Long quantity);
    String updateIncoming(Long id, Long quantity);
    String deleteIncoming(Long id);
   boolean sendMessage(String mail, String title, String body);
    String getHowManyByProductId(Long productId) throws Exception;
    List<Available> getHowManyAll();
}
