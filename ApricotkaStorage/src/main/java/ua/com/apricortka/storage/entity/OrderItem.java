package ua.com.apricortka.storage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    @SequenceGenerator(name = "order_item_id_seq_gen", sequenceName = "order_item_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_item_id_seq_gen")
    @Column(name = "id", nullable = false, unique = true)
    @JsonIgnore
    private Long id;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "initial_price", nullable = false)
    @JsonIgnore
    private Double initialPrice;

    @Column(name = "ex_quantity", nullable = false)
    private Long exQuantity;

    @Column(name = "price", nullable = false)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private Order order;

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"product_id\":" + productId +
                ", \"initial_price\":" + initialPrice +
                ", \"ex_quantity\":" + exQuantity +
                ", \"price\":" + price +
                ", \"order_id\":" + order.getId() +
                '}';
    }
}
