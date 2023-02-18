package vn.edu.hcmuaf.fit.model;

public class VoucherModel {
    private int idVoucher;
    private String name;
    private String diktat;

    public VoucherModel() {
    }

    public VoucherModel(int idVoucher, String name, String diktat) {
        this.idVoucher = idVoucher;
        this.name = name;
        this.diktat = diktat;
    }

    public int getIdVoucher() {
        return idVoucher;
    }

    public void setIdVoucher(int idVoucher) {
        this.idVoucher = idVoucher;
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
