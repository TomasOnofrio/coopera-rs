package com.coopera_rs.core.domain;

public class VariantCategory {
    private long idVariantCategory;
    private String name;

    public VariantCategory(long idVariantCategory, String name) {
        this.idVariantCategory = idVariantCategory;
        this.name = name;
    }

    public VariantCategory(){
    }

    public long getIdVariantCategory() {
        return idVariantCategory;
    }

    public void setIdVariantCategory(long idVariantCategory) {
        this.idVariantCategory = idVariantCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
