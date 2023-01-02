package vn.edu.hcmuaf.fit.model;

public class ShippingInfoModel extends AbstractModel<BillModel> {
    private String idOrder;
    private String fullName;
    private long price;
    private String shippingInfo;

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getShippingInfo() {
        return shippingInfo;
    }

    public void setShippingInfo(String shippingInfo) {
        this.shippingInfo = shippingInfo;
    }
    @Override
    public String toString() {
        return "ShippingInfo{" +
                "idOrder='" + idOrder + '\'' +
                ", fullName='" + fullName + '\'' +
                ", price='" + price + '\'' +
                ", shippingInfo='" + shippingInfo + '\'' +
                '}';
    }

}
