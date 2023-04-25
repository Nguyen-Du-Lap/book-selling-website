package vn.edu.hcmuaf.fit.model;

import java.sql.Date;
import java.sql.Timestamp;

public class BillModel extends AbstractModel<BillModel> {
    private String idOrder;
    private String idUser;
    private String idBook;
    private String shippingInfo;
    private String idDiscount;
    private Date shipTime;
    private Timestamp create_order_time;

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

    @Override
    public String toString() {
        return "BillModel{" +
                "idOrder='" + idOrder + '\'' +
                ", idUser='" + idUser + '\'' +
                ", shippingInfo='" + shippingInfo + '\'' +
                ", idDiscount='" + idDiscount + '\'' +
                ", shipTime=" + shipTime +
                ", create_order_time=" + create_order_time +
                '}';
    }
}
