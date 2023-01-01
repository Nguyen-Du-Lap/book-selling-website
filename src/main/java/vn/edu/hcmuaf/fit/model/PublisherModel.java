package vn.edu.hcmuaf.fit.model;

public class PublisherModel  extends AbstractModel<PublisherModel>  {
    private String idP;
    private String name;

    public String getIdP() {
        return idP;
    }

    public void setIdP(String idP) {
        this.idP = idP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PublisherModel{" +
                "idP='" + idP + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
