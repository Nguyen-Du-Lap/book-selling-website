package vn.edu.hcmuaf.fit.model;

public class CatalogModel extends AbstractModel<CatalogModel>  {
    private int idCatalog;
    private String name;
    private int parentId;

    public int getIdCatalog() {
        return idCatalog;
    }

    public void setIdCatalog(int idCatalog) {
        this.idCatalog = idCatalog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "CatalogModel{" +
                "idCatalog='" + idCatalog + '\'' +
                ", name='" + name + '\'' +
                ", parentId='" + parentId + '\'' +
                '}';
    }
}
