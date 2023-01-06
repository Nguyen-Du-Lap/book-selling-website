package vn.edu.hcmuaf.fit.model;

import java.sql.Date;
import java.sql.Timestamp;

public class BillModel extends AbstractModel<BillModel> {
    private String idOrder;
    private String idUser;
    private String shippingInfo;
    private String idDiscount;
    private String address;
    private String paymentMethod;
    private double total;
    private Date shipTime;
    private Timestamp create_order_time;
    private Date receiveTime;

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getShippingInfo() {
        return shippingInfo;
    }

    public void setShippingInfo(String shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    public String getIdDiscount() {
        return idDiscount;
    }

    public void setIdDiscount(String idDiscount) {
        this.idDiscount = idDiscount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getShipTime() {
        return shipTime;
    }

    public void setShipTime(Date shipTime) {
        this.shipTime = shipTime;
    }

    public Timestamp getCreate_order_time() {
        return create_order_time;
    }

    public void setCreate_order_time(Timestamp create_order_time) {
        this.create_order_time = create_order_time;
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
                "idOrder='" + idOrder + '\'' +
                ", idUser='" + idUser + '\'' +
                ", shippingInfo='" + shippingInfo + '\'' +
                ", idDiscount='" + idDiscount + '\'' +
                ", address='" + address + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", shipTime=" + shipTime +
                ", create_order_time=" + create_order_time +
                ", receiveTime=" + receiveTime +
                '}';
    }
}
