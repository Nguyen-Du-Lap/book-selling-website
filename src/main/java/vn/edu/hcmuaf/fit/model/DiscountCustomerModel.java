package vn.edu.hcmuaf.fit.model;

public class DiscountCustomerModel {
    private int idDiscount;
    private int idUser;
    private String name;
    private int percent_discount;
    private String diktat;

    public DiscountCustomerModel(int idDiscount, int idUser, String name, int percent_discount, String diktat) {
        this.idDiscount = idDiscount;
        this.idUser = idUser;
        this.name = name;
        this.percent_discount = percent_discount;
        this.diktat = diktat;
    }
    public DiscountCustomerModel(){}

    public int getIdDiscount() {
        return idDiscount;
    }

    public void setIdDiscount(int idDiscount) {
        this.idDiscount = idDiscount;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPercent_discount() {
        return percent_discount;
    }

    public void setPercent_discount(int percent_discount) {
        this.percent_discount = percent_discount;
    }

    public String getDiktat() {
        return diktat;
    }

    public void setDiktat(String diktat) {
        this.diktat = diktat;
    }

    @Override
    public String toString() {
        return "DiscountCustomerModel{" +
                "idDiscount=" + idDiscount +
                ", idUser=" + idUser +
                ", name='" + name + '\'' +
                ", percent_discount=" + percent_discount +
                ", diktat='" + diktat + '\'' +
                '}';
    }
}
