package com.coopera_rs.infrastructure.repository.mapper;

import com.coopera_rs.core.domain.StorePhoto;
import com.coopera_rs.infrastructure.repository.entity.StorePhotoEntity;

public class StorePhotoMapper {
    
    public static StorePhoto toDomain(StorePhotoEntity entity){
        StorePhoto domain = new StorePhoto();

        domain.setIdStore(entity.getStore().getStoreId());
        domain.setIdStorePhoto(entity.getIdStorePhoto());
        domain.setPhotoUrl(entity.getPhotoUrl());
        domain.setPosition(entity.getPosition());

        return domain;
    }
}
