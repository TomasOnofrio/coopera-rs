package com.coopera_rs.infrastructure.repository.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="metrics", uniqueConstraints = @UniqueConstraint(name = "metrics_id_store_date_unique", columnNames = {"id_store", "date"}))
public class MetricsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_metrics")
    private long idMetrics;

    @ManyToOne
    @JoinColumn(name = "id_store", unique = true, nullable = false)
    private StoreEntity store;

    @Column(nullable = false)
    private int removals;

    @Column(nullable = false)
    private int visits;

    @Column(nullable = false)
    private int views;

    @Column(nullable = false)
    private int carts;

    @Column(nullable = false)
    private int reviews;

    @Column(nullable = false)
    private int completed;

    @Column(nullable = false)
    private Date date;

    @UpdateTimestamp
    @Column(name = "last_updated", nullable = false)
    private LocalDateTime lastUpdated;
}
