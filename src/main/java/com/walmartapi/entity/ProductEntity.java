package com.walmartapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")

public class ProductEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
}
