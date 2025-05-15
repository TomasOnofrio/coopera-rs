package com.coopera_rs.core.domain;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Evaluation {
    private long idEvaluation;
    private long idOrder;
    private int rating;
    private String comment;
    private String answer;
    private Date date;
    private LocalDateTime lastUpdated;

    public Evaluation(long idEvaluation, long idOrder, int rating, String comment, String answer, Date date,
                      LocalDateTime lastUpdated) {
        this.idEvaluation = idEvaluation;
        this.idOrder = idOrder;
        this.rating = rating;
        this.comment = comment;
        this.answer = answer;
        this.date = date;
        this.lastUpdated = lastUpdated;
    }

    public Evaluation(){

    }

    public long getIdEvaluation() {
        return idEvaluation;
    }

    public void setIdEvaluation(long idEvaluation) {
        this.idEvaluation = idEvaluation;
    }

    public long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(long idOrder) {
        this.idOrder = idOrder;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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
