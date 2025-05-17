package com.coopera_rs.infrastructure.repository.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "store_photo")
public class StorePhotoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_store_photo")
    private long idStorePhoto;

    @Column(nullable = false)
    @NotBlank
    private String photoUrl;

    @ManyToOne
    @JoinColumn(name = "id_store", nullable = false)
    private StoreEntity store;

    @Column
    private Integer position;
}
