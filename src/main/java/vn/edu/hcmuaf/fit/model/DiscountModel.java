package vn.edu.hcmuaf.fit.model;

public class DiscountModel  extends AbstractModel<DiscountModel>  {
    private String idDiscount;
    private String name;
    private int quantity;
    private String percentDiscount;
    private String diktat;

    public String getIdDiscount() {
        return idDiscount;
    }

    public void setIdDiscount(String idDiscount) {
        this.idDiscount = idDiscount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPercentDiscount() {
        return percentDiscount;
    }

    public void setPercentDiscount(String percentDiscount) {
        this.percentDiscount = percentDiscount;
    }

    public String getDiktat() {
        return diktat;
    }

    public void setDiktat(String diktat) {
        this.diktat = diktat;
    }

    @Override
    public String toString() {
        return "DiscountModel{" +
                "idDiscount='" + idDiscount + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", percentDiscount='" + percentDiscount + '\'' +
                ", diktat='" + diktat + '\'' +
                '}';
    }
}
