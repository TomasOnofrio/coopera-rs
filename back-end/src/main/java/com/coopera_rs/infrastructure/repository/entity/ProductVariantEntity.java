package com.coopera_rs.infrastructure.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "product_variant")
public class ProductVariantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product_variant")
    private long idProductVariant;

    @ManyToOne
    @JoinColumn(name = "id_product", nullable = false)
    private ProductEntity product;

    @Column(nullable = false)
    private int stock;

    @Column(nullable = false, precision = 8, scale = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private String details;

    @UpdateTimestamp
    @Column(name = "last_updated", nullable = false)
    private LocalDateTime lastUpdated;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;
}
