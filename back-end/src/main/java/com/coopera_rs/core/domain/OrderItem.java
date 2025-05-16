package com.coopera_rs.core.domain;

public class OrderItem {
    private long idOrder;
    private int quantity;
    private long idProductVariant;

    public OrderItem(long idOrder, int quantity, long idProductVariant) {
        this.idOrder = idOrder;
        this.quantity = quantity;
        this.idProductVariant = idProductVariant;
    }

    public OrderItem(){

    }

    public long getidOrder() {
        return idOrder;
    }

    public void setidOrder(long idOrder) {
        this.idOrder = idOrder;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getIdProductVariant() {
        return idProductVariant;
    }

    public void setIdProductVariant(long idProductVariant) {
        this.idProductVariant = idProductVariant;
    }   
    
    
}
