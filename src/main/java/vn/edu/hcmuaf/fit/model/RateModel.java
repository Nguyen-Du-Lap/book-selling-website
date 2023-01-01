package vn.edu.hcmuaf.fit.model;

import java.sql.Timestamp;

public class RateModel  extends AbstractModel<RateModel>  {
    private String idUser;
    private String idBook;
    private String idOrder;
    private int startRate;
    private String comment;
    private Timestamp rate_time;

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public int getStartRate() {
        return startRate;
    }

    public void setStartRate(int startRate) {
        this.startRate = startRate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getRate_time() {
        return rate_time;
    }

    public void setRate_time(Timestamp rate_time) {
        this.rate_time = rate_time;
    }

    @Override
    public String toString() {
        return "RateModel{" +
                "idUser='" + idUser + '\'' +
                ", idBook='" + idBook + '\'' +
                ", idOrder='" + idOrder + '\'' +
                ", startRate=" + startRate +
                ", comment='" + comment + '\'' +
                ", rate_time=" + rate_time +
                '}';
    }
}
