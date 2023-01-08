package vn.edu.hcmuaf.fit.model;

import java.awt.print.Book;

public class ItemModel {
    private BookModel book;
    private int quantity;
    private double price;

    public ItemModel() {
    }

    public ItemModel(BookModel book, int quantity, double price) {
        this.book = book;
        this.quantity = quantity;
        this.price = price;
    }

    public BookModel getBook() {
        return book;
    }

    public void setBook(BookModel book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
