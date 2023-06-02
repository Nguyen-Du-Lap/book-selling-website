package vn.edu.hcmuaf.fit.model;

public class InformationDeliverModel {
    int id, idOrder, x,y,z,w;
    String districtTo, warTo;

    public InformationDeliverModel(int id, int idOrder, int x, int y, int z, int w, String districtTo, String warTo) {
        this.id = id;
        this.idOrder = idOrder;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.districtTo = districtTo;
        this.warTo = warTo;
    }

    public InformationDeliverModel() {
    }

    public InformationDeliverModel(int idOrder, int x, int y, int z, int w, String districtTo, String warTo) {
        this.idOrder = idOrder;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.districtTo = districtTo;
        this.warTo = warTo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public String getDistrictTo() {
        return districtTo;
    }

    public void setDistrictTo(String districtTo) {
        this.districtTo = districtTo;
    }

    public String getWarTo() {
        return warTo;
    }

    public void setWarTo(String warTo) {
        this.warTo = warTo;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }
}
