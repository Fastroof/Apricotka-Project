package ua.com.apricortka.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @SequenceGenerator(name = "product_id_seq_gen", sequenceName = "product_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_seq_gen")
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "category_id")
    private Long categoryId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<IncomingProductDetail> incomingProductDetails;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;
}
