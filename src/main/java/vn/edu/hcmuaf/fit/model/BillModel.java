package vn.edu.hcmuaf.fit.model;

import java.sql.Date;
import java.sql.Timestamp;

public class BillModel extends AbstractModel<BillModel> {
    private int idOrder;
    private int idUser;
    private String shippingInfo;
    private int idDiscount;
    private String address;
    private String payMethod;
    private double totalPrice;
    private double totalQuantity;
    private Timestamp create_order_time;
    private Date ship_time;
    private Date receiveTime;

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

    public String getShippingInfo() {
        return shippingInfo;
    }

    public void setShippingInfo(String shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    public int getIdDiscount() {
        return idDiscount;
    }

    public void setIdDiscount(int idDiscount) {
        this.idDiscount = idDiscount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(double totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public Timestamp getCreate_order_time() {
        return create_order_time;
    }

    public void setCreate_order_time(Timestamp create_order_time) {
        this.create_order_time = create_order_time;
    }

    public Date getShip_time() {
        return ship_time;
    }

    public void setShip_time(Date ship_time) {
        this.ship_time = ship_time;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    @Override
    public String toString() {
        return "BillModel{" +
                "idOrder=" + idOrder +
                ", idUser=" + idUser +
                ", shippingInfo='" + shippingInfo + '\'' +
                ", idDiscount=" + idDiscount +
                ", address='" + address + '\'' +
                ", payMethod='" + payMethod + '\'' +
                ", totalPrice=" + totalPrice +
                ", totalQuantity=" + totalQuantity +
                ", create_order_time=" + create_order_time +
                ", ship_time=" + ship_time +
                ", receiveTime=" + receiveTime +
                '}';
    }
}
