package com.coopera_rs.infrastructure.repository.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
@Table(name= "evaluation")
public class EvaluationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evaluation")
    private long idEvaluation;

    @ManyToOne()
    @JoinColumn(name = "id_order", unique = true, nullable = false)
    private OrderEntity order;

    @Column(nullable = false)
    private int rating;

    @Column(length = 511, nullable = false)
    private String comment;

    @Column(length = 511)
    private String answer;

    @Column(nullable = false)
    private Date date;

    @UpdateTimestamp
    @Column(name = "last_updated", nullable = false)
    private LocalDateTime lastUpdated;
}
