package ua.com.apricortka.storage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @SequenceGenerator(name = "product_id_seq_gen", sequenceName = "product_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_seq_gen")
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "category_id")
    private Long categoryId;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    List<IncomingProductDetail> incomingProductDetails;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "info", columnDefinition="text")
    private String info;

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"category_id\":" + categoryId +
                ", \"incoming_product_details\":" + incomingProductDetails +
                ", \"name\":\"" + name + '\"' +
                ", \"price\":" + price +
                ", \"info\":\"" + info + '\"' +
                '}';
    }
}
