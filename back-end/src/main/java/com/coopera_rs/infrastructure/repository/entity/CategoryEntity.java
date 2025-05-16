package com.coopera_rs.infrastructure.repository.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_category")
    private long idCategory;

    @NotBlank
    @Column(nullable = false, length = 127, unique = true)
    private String name;

    @ManyToMany(mappedBy = "categories")
    private List<ProductEntity> products;
}
