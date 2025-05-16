package com.coopera_rs.infrastructure.repository.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name= "address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAddress;

    @Column(nullable = false, length = 8)
    @Size(min = 8, max = 8, message = "CEP must be 8 characters long")
    private String cep;
    
    @Column (nullable = false)
    private String street;

    @Column (nullable = false)
    private int number;
    
    @Column
    private String unit;

    @Column
    private String neighborhood;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private String country;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;

    @Column(name = "is_active")
    private boolean isActive;
    
    public AddressEntity(String cep, String street, int number, String unit, String neighborhood, String city,
            String state, String country, UserEntity user) {
        this.cep = cep;
        this.street = street;
        this.number = number;
        this.unit = unit;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.country = country;
        this.user = user;
        this.lastUpdated = LocalDateTime.now() ;
        this.isActive = true;

    }
}
