package ua.com.apricortka.storage.pojo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderItemCreateRequest {
    private Long productId;
    private Double initialPrice;
    private Long exQuantity;
    private Double price;
}
