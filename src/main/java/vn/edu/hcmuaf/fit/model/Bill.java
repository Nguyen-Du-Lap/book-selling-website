package vn.edu.hcmuaf.fit.model;

public class Bill {
    private int idOrder;
    private int idUser;

    private int idBook;
    private String name;
    private String image;
    private int quantity;
    private double totalPrice;

    public Bill() {
    }

    public Bill(int idOrder, int idUser, String name, String image, int quantity, double totalPrice, int idBook) {
        this.idOrder = idOrder;
        this.idUser = idUser;
        this.name = name;
        this.image = image;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.idBook = idBook;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
