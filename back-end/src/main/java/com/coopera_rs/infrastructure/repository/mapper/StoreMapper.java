package com.coopera_rs.infrastructure.repository.mapper;

import com.coopera_rs.core.domain.Address;
import com.coopera_rs.core.domain.Store;
import com.coopera_rs.core.domain.User;
import com.coopera_rs.infrastructure.repository.entity.AddressEntity;
import com.coopera_rs.infrastructure.repository.entity.StoreEntity;
import com.coopera_rs.infrastructure.repository.entity.UserEntity;

public class StoreMapper {


    public static Store toDomain(StoreEntity entity) {

        User userDomain = UserMapper.toDomain(entity.getUser());
        Address addressDomain = AddressMapper.toDomain(entity.getAddressMain());

        Store store = new Store(
                userDomain,
                entity.getStoreName(),
                entity.getCnpj(),
                addressDomain,
                entity.getDescription(),
                entity.getProfileImgUrl()
        );

        store.setIdStore(entity.getStoreId());
        return store;
    }

    public static StoreEntity toEntity(Store store) {

        StoreEntity entity = new StoreEntity();

        UserEntity userEntity = UserMapper.toEntity(store.getUser());
        AddressEntity addressEntity = AddressMapper.toEntity(store.getMainAddress());

        entity.setStoreId(store.getIdStore());
        entity.setUser(userEntity);
        entity.setStoreName(store.getStoreName());
        entity.setCnpj(store.getCnpj());
        entity.setAddressMain(addressEntity);
        entity.setDescription(store.getDescription());
        entity.setProfileImgUrl(store.getProfileImgUrl());
        return entity;
    }
}
