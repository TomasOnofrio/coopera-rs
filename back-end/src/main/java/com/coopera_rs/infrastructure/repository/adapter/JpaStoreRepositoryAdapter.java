package com.coopera_rs.infrastructure.repository.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.coopera_rs.core.domain.StorePhoto;
import com.coopera_rs.core.port.StoreRepository;
import com.coopera_rs.infrastructure.repository.SpringDataStorePhotoRepository;
import com.coopera_rs.infrastructure.repository.entity.StorePhotoEntity;
import com.coopera_rs.infrastructure.repository.mapper.StorePhotoMapper;

@Component
public class JpaStoreRepositoryAdapter implements StoreRepository{
    private final SpringDataStorePhotoRepository storePhotoRepository;

    public JpaStoreRepositoryAdapter(SpringDataStorePhotoRepository StorePhotoRepository){
        this.storePhotoRepository = StorePhotoRepository;
    }

    @Override
    public List<StorePhoto> getStorePhotos(long idStore) {
        List<StorePhotoEntity> storePhotos = storePhotoRepository.findByStoreStoreId(idStore);
        return storePhotos.stream()
                          .map(e -> StorePhotoMapper.toDomain(e)).
                          collect(Collectors.toList());
                        
    }
    
}
