package com.coopera_rs.core.domain;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import com.coopera_rs.core.enums.PaymentMethod;
import com.coopera_rs.core.enums.Status;

public class Order {
    private long idOrder;
    private long idStore;
    private long idCustomer;
    private Date date;
    private Status status;
    private PaymentMethod paymentMethod;
    private long idAddress;
    private LocalDateTime lastUpdated;
    private List<OrderItem> orderItens;

    public Order(long idOrder, long idStore, long idCustomer, Date date, Status status, PaymentMethod paymentMethod,
            long idAddress, LocalDateTime lastUpdated, List<OrderItem> orderItens) {
        this.idOrder = idOrder;
        this.idStore = idStore;
        this.idCustomer = idCustomer;
        this.date = date;
        this.status = status;
        this.paymentMethod = paymentMethod;
        this.idAddress = idAddress;
        this.lastUpdated = lastUpdated;
        this.orderItens = orderItens;
    }
    
    public Order(){

    }

    public long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(long idOrder) {
        this.idOrder = idOrder;
    }

    public long getIdStore() {
        return idStore;
    }

    public void setIdStore(long idStore) {
        this.idStore = idStore;
    }

    public long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public long getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(long idAddress) {
        this.idAddress = idAddress;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public List<OrderItem> getOrderItens() {
        return orderItens;
    }

    public void setOrderItens(List<OrderItem> orderItens) {
        this.orderItens = orderItens;
    }

    
}
