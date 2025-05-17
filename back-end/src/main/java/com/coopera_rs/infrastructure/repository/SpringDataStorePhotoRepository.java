package com.coopera_rs.infrastructure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coopera_rs.infrastructure.repository.entity.StorePhotoEntity;

public interface SpringDataStorePhotoRepository extends JpaRepository<StorePhotoEntity, Long>{
    List<StorePhotoEntity> findByStoreStoreId(long idStore);
}
