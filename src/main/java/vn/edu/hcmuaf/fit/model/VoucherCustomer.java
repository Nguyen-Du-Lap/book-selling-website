package vn.edu.hcmuaf.fit.model;

public class VoucherCustomer {
    private int idCustomer;
    private int idUser;
    private int quantity;

    public VoucherCustomer() {
    }

    public VoucherCustomer(int idCustomer, int idUser, int quantity) {
        this.idCustomer = idCustomer;
        this.idUser = idUser;
        this.quantity = quantity;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
