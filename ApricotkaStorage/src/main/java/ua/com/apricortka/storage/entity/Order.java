package ua.com.apricortka.storage.entity;

import lombok.*;
import ua.com.apricortka.storage.enums.OrderStatus;
import ua.com.apricortka.storage.enums.OrderType;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @SequenceGenerator(name = "order_id_seq_gen", sequenceName = "order_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_id_seq_gen")
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private OrderType type;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(cascade = CascadeType.ALL)
    List<OrderItem> orderItems;

    @Column(name = "timestamp", nullable = false)
    private Timestamp timestamp;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "address", nullable = false, length = 1000)
    private String address;

    @Column(name = "payment_type", nullable = false)
    private String paymentType;

    @Column(name = "payment", nullable = false, length = 1000)
    private String payment;

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"type\":" + type +
                ", \"status\":" + status +
                ", \"orderItems\":" + orderItems +
                ", \"timestamp\":" + timestamp +
                ", \"userId\":" + userId +
                ", \"username\":\"" + username + '\"' +
                ", \"email\":\"" + email + '\"' +
                ", \"phone\":\"" + phone + '\"' +
                ", \"address\":\"" + address + '\"' +
                ", \"paymentType\":\"" + paymentType + '\"' +
                ", \"payment\":\"" + payment + '\"' +
                '}';
    }
}
