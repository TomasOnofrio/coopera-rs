package com.coopera_rs.core.domain;

import java.sql.Date;
import java.time.LocalDateTime;

public class Metrics {
    private long idMetrics;
    private long idStore;
    private int removals;
    private int visits;
    private int views;
    private int carts;
    private int reviews;
    private int completed;
    private Date date;
    private java.time.LocalDateTime lastUpdated;

    public Metrics(long idMetrics, long idStore, int removals, int visits, int views, int carts, int reviews,
            int completed, Date date, LocalDateTime lastUpdated) {
        this.idMetrics = idMetrics;
        this.idStore = idStore;
        this.removals = removals;
        this.visits = visits;
        this.views = views;
        this.carts = carts;
        this.reviews = reviews;
        this.completed = completed;
        this.date = date;
        this.lastUpdated = lastUpdated;
    }

    public Metrics(){

    }

    public long getIdMetrics() {
        return idMetrics;
    }

    public void setIdMetrics(long idMetrics) {
        this.idMetrics = idMetrics;
    }

    public long getIdStore() {
        return idStore;
    }

    public void setIdStore(long idStore) {
        this.idStore = idStore;
    }

    public int getRemovals() {
        return removals;
    }

    public void setRemovals(int removals) {
        this.removals = removals;
    }

    public int getVisits() {
        return visits;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getCarts() {
        return carts;
    }

    public void setCarts(int carts) {
        this.carts = carts;
    }

    public int getReviews() {
        return reviews;
    }

    public void setReviews(int reviews) {
        this.reviews = reviews;
    }

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    
    
}
