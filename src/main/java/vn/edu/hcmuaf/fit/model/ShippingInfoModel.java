package vn.edu.hcmuaf.fit.model;

public class ShippingInfoModel extends AbstractModel<BillModel> {
    private int idOrder;
    private String fullName;
    private long price;
    private int shippingInfo;

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
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

    public int getShippingInfo() {
        return shippingInfo;
    }

    public void setShippingInfo(int shippingInfo) {
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
