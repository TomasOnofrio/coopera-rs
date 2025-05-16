package com.coopera_rs.infrastructure.repository.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "variant_category")
public class VariantCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_variant_category")
    private long idVariantCategory;

    @NotBlank
    @Column(nullable = false, length = 127, unique = true)
    private String name;

    @ManyToMany(mappedBy = "variantCategories")
    private List<ProductEntity> products;
}
