package vn.edu.hcmuaf.fit.model;

public class CartDetailModel {
    private  int id;
    private String nameSach;
    private int quantity;
    private String image;
    private double totalPrice;

    public CartDetailModel(int id, String nameSach, int quantity, String image, double totalPrice) {
        this.id = id;
        this.nameSach = nameSach;
        this.quantity = quantity;
        this.image = image;
        this.totalPrice = totalPrice;
    }

    public CartDetailModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSach() {
        return nameSach;
    }

    public void setNameSach(String nameSach) {
        this.nameSach = nameSach;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
