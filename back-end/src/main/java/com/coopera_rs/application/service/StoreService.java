package com.coopera_rs.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coopera_rs.core.domain.StorePhoto;
import com.coopera_rs.core.port.StoreRepository;

@Service
public class StoreService {
    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository){
        this.storeRepository = storeRepository;
    }

    public List<StorePhoto> getStorePhotos(long idStore){
        return storeRepository.getStorePhotos(idStore);
    }
}
