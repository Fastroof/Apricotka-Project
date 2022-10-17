package com.fastroof.serviceI.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ApricotWithImages {
    private Long id;
    private List<String> images;
    private String name;
    private String info;
    private Double price;
}
