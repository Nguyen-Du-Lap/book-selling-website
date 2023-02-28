package vn.edu.hcmuaf.fit.model;

public class Bill {
    private int idOrder;
    private int idUser;

    private int idBook;
    private String name;
    private String paymentMethod;
    private String pack;
    private int quantity;
    private double totalPrice;
    private String shippingInfo;
    private String info;
    private String phone;
    private String image;

    public Bill() {
    }

    public Bill(int idOrder, int idUser, int idBook, String name,
                String paymentMethod, String pack, int quantity,
                double totalPrice, String shippingInfo,
                String info, String phone,String image) {
        this.idOrder = idOrder;
        this.idUser = idUser;
        this.idBook = idBook;
        this.name = name;
        this.paymentMethod = paymentMethod;
        this.pack = pack;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.shippingInfo = shippingInfo;
        this.info = info;
        this.phone = phone;
        this.image = image;
    }
    public Bill(int idUser, int idBook, String name,
                String paymentMethod, String pack, int quantity,
                double totalPrice, String shippingInfo,
                String info, String phone,String image) {
        this.idUser = idUser;
        this.idBook = idBook;
        this.name = name;
        this.paymentMethod = paymentMethod;
        this.pack = pack;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.shippingInfo = shippingInfo;
        this.info = info;
        this.phone = phone;
        this.image = image;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPack() {
        return pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
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

    public String getShippingInfo() {
        return shippingInfo;
    }

    public void setShippingInfo(String shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
