package com.coopera_rs.core.domain;

public class StorePhoto {
    private long idStorePhoto;
    private String photoUrl;
    private long idStore;
    private Integer position;


    public StorePhoto(long idStorePhoto, String photoUrl, long idStore, Integer position) {
        this.idStorePhoto = idStorePhoto;
        this.photoUrl = photoUrl;
        this.idStore = idStore;
        this.position = position;

    }

    public StorePhoto(){

    }

    public long getIdStorePhoto() {
        return idStorePhoto;
    }

    public void setIdStorePhoto(long idStorePhoto) {
        this.idStorePhoto = idStorePhoto;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public long getIdStore() {
        return idStore;
    }

    public void setIdStore(long idStore) {
        this.idStore = idStore;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
    
}
