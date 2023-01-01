package vn.edu.hcmuaf.fit.model;

public class CatalogModel extends AbstractModel<CatalogModel>  {
    private String idCatalog;
    private String name;
    private String parentId;

    public String getIdCatalog() {
        return idCatalog;
    }

    public void setIdCatalog(String idCatalog) {
        this.idCatalog = idCatalog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
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
