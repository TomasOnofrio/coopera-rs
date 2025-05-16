package com.coopera_rs.core.domain;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Address {
    private long idAddress;
    private String cep;
    private String street;
    private int number;
    private String unit;
    private String neighborhood;
    private String city;
    private String state;
    private String country;
    private User user;
    private LocalDateTime lastUpdated;
    private boolean isActive;

    public Address(String cep, String street, int number, String unit, String neighborhood, String city,
            String state, String country, User user) {
        this.cep = cep;
        this.street = street;
        this.number = number;
        this.unit = unit;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.country = country;
        this.user = user;
        this.lastUpdated = LocalDateTime.now() ;
        this.isActive = true;

    }

    public Address() {
    }

    public long getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(long idAddress) {
        this.idAddress = idAddress;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    

    



}
