package ua.com.apricortka.storage.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductWithImages {
    private Long id;
    private Long categoryId;
    private List<String> images;
    private String name;
    private String info;
    private Double price;
}
