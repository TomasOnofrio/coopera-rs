package com.coopera_rs.core.domain;

public class ProductPhoto {
    private long idProductPhoto;
    private long idProduct;
    private String photoUrl;

    public ProductPhoto(long idProductPhoto, long idProduct, String photoUrl) {
        this.idProductPhoto = idProductPhoto;
        this.idProduct = idProduct;
        this.photoUrl = photoUrl;
    }

    public ProductPhoto(){

    }

    public long getIdProductPhoto() {
        return idProductPhoto;
    }

    public void setIdProductPhoto(long idProductPhoto) {
        this.idProductPhoto = idProductPhoto;
    }

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    

    
}
