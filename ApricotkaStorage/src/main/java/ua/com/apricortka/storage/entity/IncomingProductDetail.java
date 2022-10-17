package ua.com.apricortka.storage.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "incoming_product_details")
public class IncomingProductDetail {
    @Id
    @SequenceGenerator(name = "incoming_id_seq_gen", sequenceName = "incoming_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "incoming_id_seq_gen")
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "supplier")
    private String supplier;

    @Column(name = "initial_price", nullable = false)
    private Double initial_price;

    @Column(name = "quantity", nullable = false)
    private Long quantity;

    @Column(name = "timestamp", nullable = false)
    private Timestamp timestamp;

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"product_id\":" + product.getId() +
                ", \"supplier\":\"" + supplier + '\"' +
                ", \"initial_price\":" + initial_price +
                ", \"quantity\":" + quantity +
                ", \"timestamp\":" + timestamp +
                '}';
    }
}
