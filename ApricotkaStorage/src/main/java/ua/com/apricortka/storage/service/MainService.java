package ua.com.apricortka.storage.service;

import org.springframework.stereotype.Service;
import ua.com.apricortka.storage.entity.Order;
import ua.com.apricortka.storage.entity.Product;
import ua.com.apricortka.storage.entity.ProductWithImages;
import ua.com.apricortka.storage.enums.OrderStatus;
import ua.com.apricortka.storage.enums.OrderType;
import ua.com.apricortka.storage.pojo.Available;
import ua.com.apricortka.storage.pojo.OrderItemCreateRequest;

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
    String getOrderItemById(Long id);
    String addOrderItem(Long productId, Double initial_price, Long exQuantity, Double price, Long orderId) throws Exception;
    boolean addOrderItem(Long productId, Double initial_price, Long exQuantity, Double price, Order order) throws Exception;
    String deleteOrderItem(Long id);
    String getAllOrders();
    String getOrderById(Long id);
    String getOrderByUserId(Long user_id);
    String createOrder(OrderStatus status, OrderType type, Long user_id, String address, String email, String payment, String paymentType, String phone, String username, List<OrderItemCreateRequest> orderItemCreateRequests) throws Exception;
    String updateOrderStatus(Long id, OrderStatus status);
    boolean sendMessage(String mail, String title, String body);
    List<Order> getOrderByEmailOrUserId(String email, Long userId);
    String getHowManyByProductId(Long productId) throws Exception;
    List<Available> getHowManyAll();
}
