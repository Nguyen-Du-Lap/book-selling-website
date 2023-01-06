package vn.edu.hcmuaf.fit.model;

public class BillManagementModel extends AbstractModel<BillManagementModel> {
    private String idOrder;
    private String nameUser;
    private String address;
    private String paymethod;
    private int totalProduct;
    private double totalPrice;
    private String statusBill;

    public BillManagementModel(String idOrder, String nameUser, String address, String paymethod, int totalProduct, double totalPrice, String statusBill) {
        this.idOrder = idOrder;
        this.nameUser = nameUser;
        this.address = address;
        this.paymethod = paymethod;
        this.totalProduct = totalProduct;
        this.totalPrice = totalPrice;
        this.statusBill = statusBill;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
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
}
