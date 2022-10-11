package ua.com.apricortka.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "incoming_product_detail")
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
}
