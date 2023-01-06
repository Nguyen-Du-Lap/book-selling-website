package vn.edu.hcmuaf.fit.model;

public class BookManagementModel {

    private int id;
    private String name;
    private String image;
    private int quantity;
    private String status;
    private double price;
    private String category;

    private double discount;

    public BookManagementModel(int id, String name, String image, int quantity,
                               String status, double price, String category, double discount) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.quantity = quantity;
        this.status = status;
        this.price = price;
        this.category = category;
        this.discount = discount;
    }
    public BookManagementModel() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "BookManagementModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", quantity=" + quantity +
                ", status='" + status + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", discount=" + discount +
                '}';
    }
}
