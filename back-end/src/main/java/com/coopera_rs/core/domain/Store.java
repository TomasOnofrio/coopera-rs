package com.coopera_rs.core.domain;

public class Store {

    private long idStore;
    private User user; 
    private String storeName;
    private String cnpj;
    private Address mainAddress;   //Address ou so id?
    private String description;
    private String profileImgUrl;


    public Store() {
    }

    public Store(User user, String storeName, String cnpj, Address mainAddress, String description, String profileImgUrl) {
        this.idStore = user.getId();
        this.user = user;
        this.storeName = storeName;
        this.cnpj = cnpj;
        this.mainAddress = mainAddress;
        this.description = description;
        this.profileImgUrl = profileImgUrl;
    }

    public long getIdStore() {
        return idStore;
    }

    public void setIdStore(long idStore) {
        this.idStore = idStore;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Address getMainAddress() {
        return mainAddress;
    }

    public void setMainAddress(Address mainAddress) {
        this.mainAddress = mainAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProfileImgUrl() {return profileImgUrl;}

    public void setProfileImgUrl(String profileImgUrl) {this.profileImgUrl = profileImgUrl;}
}
