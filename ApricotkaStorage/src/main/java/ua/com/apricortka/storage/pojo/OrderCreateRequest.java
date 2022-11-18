package ua.com.apricortka.storage.pojo;

import lombok.*;
import ua.com.apricortka.storage.enums.OrderStatus;
import ua.com.apricortka.storage.enums.OrderType;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderCreateRequest {
    private OrderStatus status;
    private OrderType type;
    private Long user_id;
    private String address;
    private String email;
    private String payment;
    private String paymentType;
    private String phone;
    private String username;
    private List<OrderItemCreateRequest> orderItemCreateRequests;
}
