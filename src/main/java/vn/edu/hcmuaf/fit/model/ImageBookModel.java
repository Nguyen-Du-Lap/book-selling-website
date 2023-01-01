package vn.edu.hcmuaf.fit.model;

public class ImageBookModel  extends AbstractModel<ImageBookModel>  {
    private String idBook;
    private String image;
    private String idImage;
    public ImageBookModel(String idBook, String image, String idImage) {
        this.idBook = idBook;
        this.image = image;
        this.idImage = idImage;
    }

    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIdImage() {
        return idImage;
    }

    public void setIdImage(String idImage) {
        this.idImage = idImage;
    }
}
