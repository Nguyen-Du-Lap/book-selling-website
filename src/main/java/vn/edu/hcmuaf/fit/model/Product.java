package vn.edu.hcmuaf.fit.model;

public class Product {
    private int idBook;
    private String name;
    private double priceDiscount;
    private double price;
    private String image;
    private String size;
    private int quantity;
    private double weight;

    public Product() {
    }

    public Product(int idBook, String name, double priceDiscount, double price, String image, int quantity) {
        this.idBook = idBook;
        this.name = name;
        this.priceDiscount = priceDiscount;
        this.price = price;
        this.image = image;
        this.quantity = quantity;
    }
    public Product(int idBook, String name, double priceDiscount, double price, String image, String size, int quantity, double weight) {
        this.idBook = idBook;
        this.name = name;
        this.priceDiscount = priceDiscount;
        this.price = price;
        this.image = image;
        this.size = size;
        this.quantity = quantity;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
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

    @Override
    public String toString() {
        return "Product{" +
                "idBook=" + idBook +
                ", name='" + name + '\'' +
                ", priceDiscount=" + priceDiscount +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
