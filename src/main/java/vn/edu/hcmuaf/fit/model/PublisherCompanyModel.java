package vn.edu.hcmuaf.fit.model;

public class PublisherCompanyModel  extends AbstractModel<PublisherCompanyModel>  {
    private int idPc;
    private String name;

    public int getIdPc() {
        return idPc;
    }

    public void setIdPc(int idPc) {
        this.idPc = idPc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PublisherCompanyModel{" +
                "idPc='" + idPc + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
