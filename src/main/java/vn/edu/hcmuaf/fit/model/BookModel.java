package vn.edu.hcmuaf.fit.model;

import java.sql.Date;
import java.sql.Timestamp;

public class BookModel  extends AbstractModel<BookModel> {
    private String idBook;
    private String name;
    private String idAuthor;
    private String idCatalog;
    private int quantity;
    private double priceCost;
    private boolean isNew;
    private boolean isActive;
    private String idPc;
    private String idP;
    private Date publishedTime;
    private Timestamp created;

    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(String idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getIdCatalog() {
        return idCatalog;
    }

    public void setIdCatalog(String idCatalog) {
        this.idCatalog = idCatalog;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPriceCost() {
        return priceCost;
    }

    public void setPriceCost(double priceCost) {
        this.priceCost = priceCost;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getIdPc() {
        return idPc;
    }

    public void setIdPc(String idPc) {
        this.idPc = idPc;
    }

    public String getIdP() {
        return idP;
    }

    public void setIdP(String idP) {
        this.idP = idP;
    }

    public Date getPublishedTime() {
        return publishedTime;
    }

    public void setPublishedTime(Date publishedTime) {
        this.publishedTime = publishedTime;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "BookModel{" +
                "idBook='" + idBook + '\'' +
                ", name='" + name + '\'' +
                ", idAuthor='" + idAuthor + '\'' +
                ", idCatalog='" + idCatalog + '\'' +
                ", quantity=" + quantity +
                ", priceCost=" + priceCost +
                ", isNew=" + isNew +
                ", isActive=" + isActive +
                ", idPc='" + idPc + '\'' +
                ", idP='" + idP + '\'' +
                ", publishedTime=" + publishedTime +
                ", created=" + created +
                '}';
    }
}
