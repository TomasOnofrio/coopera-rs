package com.coopera_rs.infrastructure.repository.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "order_item")
public class OrderItemEntity {

    @EmbeddedId
    private OrderItemId id;

    @ManyToOne
    @MapsId("order")
    @JoinColumn(name = "id_order", nullable = false)
    private OrderEntity order;

    @ManyToOne
    @MapsId("productVariant")
    @JoinColumn(name = "id_product_variant", nullable = false)
    private ProductVariantEntity productVariant;

    @Column(nullable = false)
    private int quantity;
}
