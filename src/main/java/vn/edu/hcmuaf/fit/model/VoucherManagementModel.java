package vn.edu.hcmuaf.fit.model;

public class VoucherManagementModel {
    // have attribute id_discount, name, quantity, percent_discount, diktat, status, price_minimum
    private int id_discount, quantity, percent_discount, price_minimum, status;
    private String name, diktat;

    public VoucherManagementModel(int id_discount, int quantity, int percent_discount, int price_minimum, int status, String name, String diktat) {
        this.id_discount = id_discount;
        this.quantity = quantity;
        this.percent_discount = percent_discount;
        this.price_minimum = price_minimum;
        this.status = status;
        this.name = name;
        this.diktat = diktat;
    }

    public VoucherManagementModel() {
    }

    public int getId_discount() {
        return id_discount;
    }

    public void setId_discount(int id_discount) {
        this.id_discount = id_discount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPercent_discount() {
        return percent_discount;
    }

    public void setPercent_discount(int percent_discount) {
        this.percent_discount = percent_discount;
    }

    public int getPrice_minimum() {
        return price_minimum;
    }

    public void setPrice_minimum(int price_minimum) {
        this.price_minimum = price_minimum;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiktat() {
        return diktat;
    }

    public void setDiktat(String diktat) {
        this.diktat = diktat;
    }
}
