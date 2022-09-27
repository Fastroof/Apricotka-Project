package ua.com.apricotka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ua.com.apricotka.entity.Order;
import ua.com.apricotka.repository.OrderRepository;

@Controller
public class OrderInfoController {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderInfoController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/order_info")
    public String showOrderInfoPage() {
        return "order_info";
    }

    @PostMapping("/order_info")
    public String showOrderInfoPageWithInformationAboutSearchingOrderByID(long orderId, ModelMap model) {
        String info = "Замовлення номер " + orderId + " не знайдено";
        Order order = orderRepository.findById(orderId);
        if (order != null) {
            info = "Замовлення номер: " + order.getId() +
                    "\nЗамовник: " + order.getFullname() +
                    "\nEmail: " + order.getEmail() +
                    "\nАдреса: " + order.getAddress() +
                    "\nНаселений пункт: " + order.getCity() +
                    "\nСпосіб оплати: " + order.getPayment();
        }
        model.addAttribute("info", info);
        return "order_info";
    }
}
