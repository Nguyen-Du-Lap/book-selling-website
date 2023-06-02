package vn.edu.hcmuaf.fit.model;

import java.sql.Timestamp;
import java.util.Date;

public class BillManagementModel extends AbstractModel<BillManagementModel> {
    private int idOrder;
    private String nameUser;
    private String address;
    private String paymethod;
    private int totalProduct;
    private double totalPrice;
    private String statusBill;
    private Timestamp create_Order;
    private Date shipdate;
    private Date receiveDate;
    private int idCart;


    public BillManagementModel(int idOrder, String nameUser, String address, String paymethod, int totalProduct, double totalPrice, String statusBill, Timestamp create_Order, Date shipdate, Date receiveDate) {
        this.idOrder = idOrder;
        this.nameUser = nameUser;
        this.address = address;
        this.paymethod = paymethod;
        this.totalProduct = totalProduct;
        this.totalPrice = totalPrice;
        this.statusBill = statusBill;
        this.create_Order = create_Order;
        this.shipdate = shipdate;
        this.receiveDate = receiveDate;
    }

    public BillManagementModel() {

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

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPaymethod() {
        return paymethod;
    }

    public void setPaymethod(String paymethod) {
        this.paymethod = paymethod;
    }

    public int getTotalProduct() {
        return totalProduct;
    }

    public void setTotalProduct(int totalProduct) {
        this.totalProduct = totalProduct;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatusBill() {
        return statusBill;
    }

    public void setStatusBill(String statusBill) {
        this.statusBill = statusBill;
    }

    public Timestamp getCreate_Order() {
        return create_Order;
    }

    public void setCreate_Order(Timestamp create_Order) {
        this.create_Order = create_Order;
    }

    public Date getShipdate() {
        return shipdate;
    }

    public void setShipdate(Date shipdate) {
        this.shipdate = shipdate;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    @Override
    public String toString() {
        return "BillManagementModel{" +
                "idOrder=" + idOrder +
                ", nameUser='" + nameUser + '\'' +
                ", address='" + address + '\'' +
                ", paymethod='" + paymethod + '\'' +
                ", totalProduct=" + totalProduct +
                ", totalPrice=" + totalPrice +
                ", statusBill='" + statusBill + '\'' +
                ", create_Order=" + create_Order +
                ", shipdate=" + shipdate +
                ", receiveDate=" + receiveDate +
                '}';
    }
}
