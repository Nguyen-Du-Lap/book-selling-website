package vn.edu.hcmuaf.fit.model;

import java.sql.Date;
import java.sql.Timestamp;

public class BookModel  extends AbstractModel<BookModel> {
    private int idBook;
    private String name;
    private String nameAuthor;
    private double priceDiscount;
    private double price;
    private int discount;
    private int quantityStart;
    private int quantityComment;

    private String image;
    private String idCP;
    private String idP;
    private int quantity;
    private String catalog;

    public BookModel() {
    }

    public BookModel(int idBook, String name, String nameAuthor, double priceDiscount, double price, int discount, int quantityStart, int quantityComment, String image) {
        this.idBook = idBook;
        this.name = name;
        this.nameAuthor = nameAuthor;
        this.priceDiscount = priceDiscount;
        this.price = price;
        this.discount = discount;
        this.quantityStart = quantityStart;
        this.quantityComment = quantityComment;
        this.image = image;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public double getPriceDiscount() {
        return priceDiscount;
    }

    public void setPriceDiscount(double priceDiscount) {
        this.priceDiscount = priceDiscount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getQuantityStart() {
        return quantityStart;
    }

    public void setQuantityStart(int quantityStart) {
        this.quantityStart = quantityStart;
    }

    public int getQuantityComment() {
        return quantityComment;
    }

    public void setQuantityComment(int quantityComment) {
        this.quantityComment = quantityComment;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIdCP() {
        return idCP;
    }

    public void setIdCP(String idCP) {
        this.idCP = idCP;
    }
    public String getIdP() {
        return idP;
    }

    public void setIdP(String idP) {
        this.idP = idP;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "BookModel{" +
                "idBook=" + idBook +
                ", name='" + name + '\'' +
                ", nameAuthor='" + nameAuthor + '\'' +
                ", priceDiscount=" + priceDiscount +
                ", price=" + price +
                ", discount=" + discount +
                ", quantityStart=" + quantityStart +
                ", quantityComment=" + quantityComment +
                ", image='" + image + '\'' +
                '}';
    }
}
