package ua.com.apricortka.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "expense")
public class Expense {
    @Id
    @SequenceGenerator(name = "expense_id_seq_gen", sequenceName = "expense_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expense_id_seq_gen")
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "timestamp", nullable = false)
    private Timestamp timestamp;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "initial_price", nullable = false)
    private Double initialPrice;

    @Column(name = "ex_quantity", nullable = false)
    private Long exQuantity;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "sum", nullable = false)
    private Double sum;

    @Column(name = "type")
    private String type;
}
