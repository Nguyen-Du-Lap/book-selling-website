package vn.edu.hcmuaf.fit.model;

public class AuthorModel extends AbstractModel<AuthorModel>{
    private int idAuthor;
    private String name;
    private String img;
    private String information;

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Override
    public String toString() {
        return "AuthorModel{" +
                "idAuthor='" + idAuthor + '\'' +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", information='" + information + '\'' +
                '}';
    }
}
