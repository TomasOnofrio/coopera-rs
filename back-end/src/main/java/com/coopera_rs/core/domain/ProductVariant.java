package com.coopera_rs.core.domain;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.time.LocalDateTime;

public class ProductVariant {
    private long idProductVariant;
    private long idProduct;
    private int stock;
    private BigDecimal price;
    private String details;
    private LocalDateTime lastUpdated;
    private boolean isActive;


    public ProductVariant(long idProductVariant, long idProduct, int stock, BigDecimal price, String details,
                          LocalDateTime lastUpdated, boolean isActive) {
        this.idProductVariant = idProductVariant;
        this.idProduct = idProduct;
        this.stock = stock;
        this.price = price;
        this.details = details;
        this.lastUpdated = lastUpdated;
        this.isActive = isActive;
    }

    public ProductVariant(){
        
    }


    public long getIdProductVariant() {
        return idProductVariant;
    }


    public void setIdProductVariant(long idProductVariant) {
        this.idProductVariant = idProductVariant;
    }


    public long getIdProduct() {
        return idProduct;
    }


    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }


    public int getStock() {
        return stock;
    }


    public void setStock(int stock) {
        this.stock = stock;
    }


    public BigDecimal getPrice() {
        return price;
    }


    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public String getDetails() {
        return details;
    }


    public void setDetails(String details) {
        this.details = details;
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
