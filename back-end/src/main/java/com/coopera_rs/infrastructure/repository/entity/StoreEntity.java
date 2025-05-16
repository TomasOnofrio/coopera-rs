package com.coopera_rs.infrastructure.repository.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "store")
public class StoreEntity {

    @Id
    @Column(name = "id_store")
    private long storeId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(nullable = false, name = "store_name", length = 127)
    @NotBlank(message = "Store name cannot be blank")
    private String storeName;

    @Column(unique = true, nullable = false, length = 14)
    @NotBlank(message = "CNPJ cannot be blank")
    @Size(min = 14, max = 14, message = "CNPJ must be 14 characters long")
    private String cnpj;

    @Column(columnDefinition = "TEXT")
    private String description;


    @ManyToOne
    @JoinColumn(name = "id_address_main")
    private AddressEntity addressMain;

    @Column(name = "profile_img_url")
    private String profileImgUrl;
}
