package vn.edu.hcmuaf.fit.model;

public class BookDetails  extends AbstractModel<BookDetails> {
    private String idBook;
    private int year;
    private double weight;
    private String size;
    private int page;
    private String language;
    private String description;

    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "BookDetailsDAO{" +
                "idBook='" + idBook + '\'' +
                ", year=" + year +
                ", weight=" + weight +
                ", size='" + size + '\'' +
                ", page=" + page +
                ", language='" + language + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
