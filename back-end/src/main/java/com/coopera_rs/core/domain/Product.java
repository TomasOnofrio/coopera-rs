package com.coopera_rs.core.domain;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class Product {
    private long idProduct;
    private String name;
    private String description;
    private long idStore;
    private LocalDateTime lastUpdated;
    private List<Category> categories;
    private List<VariantCategory> variantCategories;

    public Product(long idProduct, String name, String description, long idStore, LocalDateTime lastUpdated,
            List<Category> categories, List<VariantCategory> variantCategories) {
        this.idProduct = idProduct;
        this.name = name;
        this.description = description;
        this.idStore = idStore;
        this.lastUpdated = lastUpdated;
        this.categories = categories;
        this.variantCategories = variantCategories;
    }

    public Product() {

    }

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getIdStore() {
        return idStore;
    }

    public void setIdStore(long idStore) {
        this.idStore = idStore;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<VariantCategory> getVariantCategories() {
        return variantCategories;
    }

    public void setVariantCategories(List<VariantCategory> variantCategories) {
        this.variantCategories = variantCategories;
    }

    

    



}
