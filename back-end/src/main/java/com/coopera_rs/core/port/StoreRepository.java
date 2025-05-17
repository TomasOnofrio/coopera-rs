package com.coopera_rs.core.port;

import java.util.List;

import com.coopera_rs.core.domain.StorePhoto;

public interface StoreRepository {
    List<StorePhoto> getStorePhotos(long idStore);
}
