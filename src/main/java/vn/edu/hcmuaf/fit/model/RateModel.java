package vn.edu.hcmuaf.fit.model;

import java.sql.Timestamp;

public class RateModel  extends AbstractModel<RateModel>  {
    private int idUser;
    private int idBook;
    private int idOrder;
    private String nameUser;
    private int startRate;
    private String comment;
    private Timestamp rate_time;
    private int status;
    public RateModel() {
    }

    public RateModel(int idUser, int idBook, int idOrder, String nameUser, int startRate, String comment, Timestamp rate_time, int status) {
        this.idUser = idUser;
        this.idBook = idBook;
        this.idOrder = idOrder;
        this.nameUser = nameUser;
        this.startRate = startRate;
        this.comment = comment;
        this.rate_time = rate_time;
        this.status = status;
    }

    public RateModel(int idUser, int idBook, int idOrder, int startRate, String comment, Timestamp rate_time, String nameUser) {
        this.idUser = idUser;
        this.idBook = idBook;
        this.idOrder = idOrder;
        this.startRate = startRate;
        this.comment = comment;
        this.rate_time = rate_time;
        this.nameUser = nameUser;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getStartRate() {
        return startRate;
    }

    public void setStartRate(int startRate) {
        this.startRate = startRate;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
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
}
