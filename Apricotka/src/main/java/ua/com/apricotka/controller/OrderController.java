package ua.com.apricotka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.com.apricotka.entity.Order;
import ua.com.apricotka.entity.OrderItem;
import ua.com.apricotka.entity.User;
import ua.com.apricotka.repository.OrderItemRepository;
import ua.com.apricotka.repository.OrderRepository;
import ua.com.apricotka.repository.UserRepository;
import ua.com.apricotka.request.OrderFormRequest;
import ua.com.apricotka.request.OrderItemRequest;
import ua.com.apricotka.request.OrderRequest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class OrderController {

    private List<OrderItemRequest> orderItemRequests;
    private double totalPrice;

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderController(UserRepository userRepository, OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @PostMapping("/order_items")
    @ResponseBody
    public void redirectToOrderPage(@RequestBody OrderRequest orderRequest) {
        orderItemRequests = orderRequest.getOrderItemRequests();
        totalPrice = orderRequest.getTotalPrice();
    }

    @GetMapping("/order")
    public String showOrderPage(Principal principal, ModelMap model) {
        if (principal != null) {
            User user = userRepository.findByEmail(principal.getName());
            model.addAttribute("fullName", user.getLastName() + " " + user.getFirstName());
            model.addAttribute("email", principal.getName());
        }
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("items", orderItemRequests);
        model.addAttribute("dollarRate", 1);
        return "order";
    }

    @PostMapping("/order")
    public String createAndSaveOrder(Principal principal, ModelMap model, OrderFormRequest form) {
        User user = userRepository.findByEmail(principal.getName());

        Order order = new Order();
        order.setUserId(user.getId());
        order.setOrderDate(LocalDateTime.now());
        order.setTotalPrice(totalPrice);
        order.setTotalPriceHryvnia((new BigDecimal(totalPrice * 1).setScale(2, RoundingMode.HALF_UP)).doubleValue());
        order.setOrderDetails("Створено");

        order.setFullname(form.getFname());
        order.setEmail(form.getEmail());
        order.setAddress(form.getAdr());
        order.setCity(form.getCity());
        order.setPayment(form.getPayment());
        orderRepository.save(order);

        orderItemRequests.forEach(orderItemRequest -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(order.getId());
            orderItem.setApricotId(orderItemRequest.getApricotId());
            orderItem.setQuantity(orderItemRequest.getQuantity());
            orderItemRepository.save(orderItem);
        });

        String details = "Замовлення номер: " + order.getId() +
                "\nЗамовник: " + form.getFname() +
                "\nEmail: " + form.getEmail() +
                "\nАдреса: " + form.getAdr() +
                "\nНаселений пункт: " + form.getCity() +
                "\nСпосіб оплати: " + form.getPayment();

        model.addAttribute("details", details);
        model.addAttribute("text", "Натисніть, щоб перейти до магазину");
        model.addAttribute("link", "/");
        model.addAttribute("msg", "Замовлення сформовано");
        return "info";
    }
}
