package com.coopera_rs.infrastructure.repository.entity;

import com.coopera_rs.core.domain.Category;
import com.coopera_rs.core.domain.VariantCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private long idProduct;

    @Column(nullable = false)
    @NotBlank
    private String name;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_store", nullable = false)
    private StoreEntity store;

    @UpdateTimestamp
    @Column(name = "last_updated", nullable = false)
    private LocalDateTime lastUpdated;

    @ManyToMany
    @JoinTable(
            name = "product_category",
            joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_category")
    )
    private List<CategoryEntity> categories;

    @ManyToMany
    @JoinTable(
            name = "variant_category_product",
            joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_variant_category")
    )
    private List<VariantCategoryEntity> variantCategories;

}
