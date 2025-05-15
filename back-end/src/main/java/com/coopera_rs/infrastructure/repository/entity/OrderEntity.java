package com.coopera_rs.infrastructure.repository.entity;

import com.coopera_rs.core.enums.PaymentMethod;
import com.coopera_rs.core.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private long idOrder;

    @ManyToOne
    @JoinColumn(name = "id_store", nullable = false)
    private StoreEntity store;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private UserEntity user;

    @Column(nullable = false)
    private Date date;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column(name ="payment_method", nullable= false)
    private PaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn(name = "id_address", nullable = false)
    private AddressEntity address;

    @UpdateTimestamp
    @Column(name = "last_updated", nullable = false)
    private LocalDateTime lastUpdated;

    @OneToMany(mappedBy = "order")
    private List<OrderItemEntity> orderItems;
}
