package com.coopera_rs.core.domain;

public class Category {
    private long idCategory;
    private String name;

    public Category(long idCategory, String name) {
        this.idCategory = idCategory;
        this.name = name;
    }

    public Category(){
    }

    public long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(long idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
