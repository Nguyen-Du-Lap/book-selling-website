package vn.edu.hcmuaf.fit.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Bill {
    private int idOrder;
    private int idUser;

    private int idBook;
    private String name;
    private int paymentMethod;
    private int pack;
    private int quantity;
    private int totalPrice;
    private int shippingInfo;
    private String info;
    private String phone;
    private String image;

    private String address;

    private Timestamp ship_time;
    private Timestamp receive_time;
    private int idCart;

    public Bill() {
    }

    public Bill(int idOrder, int idUser, int idBook, String name,
                int paymentMethod, int pack, int quantity,
                int totalPrice, int shippingInfo,
                String info, String phone,String image, String address, Timestamp ship_time, Timestamp receive_time) {
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
        this.address = address;
        this.ship_time = ship_time;
        this.receive_time = receive_time;
    }
    public Bill(int idUser, int idBook, String name,
                int paymentMethod, int pack, int quantity,
                int totalPrice, int shippingInfo,
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

    public Bill(int idOrder, int idUser, int idBook, String name, String paymentMethod, String pack, int quantity, int totalPrice, int shippingInfo, String info, String phone, String image, String address, Timestamp ship_time, Timestamp receive_time, int idCart) {
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
        this.address = address;
        this.ship_time = ship_time;
        this.receive_time = receive_time;
        this.idCart = idCart;
    }

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
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

        return paymentMethod == 0 ? "tiền mặt" : "online";
    }

    public void setPaymentMethod(int paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPack() {

        return pack == 0 ? "Bọc blastic" : "Để nguyên seal";
    }

    public void setPack(int pack) {
        this.pack = pack;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getShippingInfo() {

        return getNameShippingInfo(shippingInfo);
    }

    public void setShippingInfo(int shippingInfo) {
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
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getShip_time() {
        if(ship_time.equals("")) return "";
        LocalDateTime dateTime = ship_time.toLocalDateTime();
        String ngayThangNam = dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return ngayThangNam;
    }

    public void setShip_time(Timestamp ship_time) {

        this.ship_time = ship_time;
    }

    public String getReceive_time() {
        if(ship_time.equals("")) return "";
        LocalDateTime dateTime = receive_time.toLocalDateTime();
        String ngayThangNam = dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return ngayThangNam;
    }

    public void setReceive_time(Timestamp receive_time) {
        this.receive_time = receive_time;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "idOrder=" + idOrder +
                ", idUser=" + idUser +
                ", idBook=" + idBook +
                ", name='" + name + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", pack='" + pack + '\'' +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", shippingInfo='" + shippingInfo + '\'' +
                ", info='" + info + '\'' +
                ", phone='" + phone + '\'' +
                ", image='" + image + '\'' +
                ", address='" + address + '\'' +
                ", ship_time=" + ship_time +
                ", receive_time=" + receive_time +
                '}';
    }
    public String getNameShippingInfo(int shippingInfo) {
        switch (shippingInfo) {
            case 1: return "Chờ xử lý";
            case 2: return "Đang vận chuyển";
            case 3: return "Đã hoàn thành";
            case 4: return "Đã hủy";
            default: return "error";
        }
    }
}
