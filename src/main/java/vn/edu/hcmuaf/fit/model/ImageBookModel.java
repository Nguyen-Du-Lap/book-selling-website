package vn.edu.hcmuaf.fit.model;

public class ImageBookModel  extends AbstractModel<ImageBookModel>  {
    private int idBook;
    private String image;
    private int idImage;

    public ImageBookModel() {
    }

    public ImageBookModel(int idBook, String image, int idImage) {
        this.idBook = idBook;
        this.image = image;
        this.idImage = idImage;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    @Override
    public String toString() {
        return "ImageBookModel{" +
                "idBook=" + idBook +
                ", image=" + image +
                ", idImage=" + idImage +
                '}';
    }
}
