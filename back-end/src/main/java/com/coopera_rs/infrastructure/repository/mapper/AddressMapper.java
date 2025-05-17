package com.coopera_rs.infrastructure.repository.mapper;

import com.coopera_rs.core.domain.Address;
import com.coopera_rs.core.domain.User;
import com.coopera_rs.infrastructure.repository.entity.AddressEntity;

public class AddressMapper {

    public static Address toDomain(AddressEntity entity) {
        if (entity == null) return null;

        User userDomain = UserMapper.toDomain(entity.getUser());

        Address address = new Address(
                entity.getCep(),
                entity.getStreet(),
                entity.getNumber(),
                entity.getUnit(),
                entity.getNeighborhood(),
                entity.getCity(),
                entity.getState(),
                entity.getCountry(),
                userDomain
        );

        address.setIdAddress(entity.getIdAddress());

        if (entity.getLastUpdated() != null) {
            address.setLastUpdated(entity.getLastUpdated());
        }

        address.setActive(entity.isActive());

        return address;
    }

    public static AddressEntity toEntity(Address address) {

        AddressEntity entity = new AddressEntity();

        entity.setIdAddress(address.getIdAddress());
        entity.setCep(address.getCep());
        entity.setStreet(address.getStreet());
        entity.setNumber(address.getNumber());
        entity.setUnit(address.getUnit());
        entity.setNeighborhood(address.getNeighborhood());
        entity.setCity(address.getCity());
        entity.setState(address.getState());
        entity.setCountry(address.getCountry());
        entity.setUser(UserMapper.toEntity(address.getUser()));
        entity.setLastUpdated(address.getLastUpdated());
        entity.setActive(address.isActive());

        return entity;
    }
}
