package vn.edu.hcmuaf.fit.model;

public class BookDetails  extends AbstractModel<BookDetails> {
    private int id;
    private String name;
    private String nameAuthor;
    private int year;
    private int weight;
    private String isbn;
    private String size;
    private int page;
    private String language;
    private String description;


    public BookDetails() {
    }

    public BookDetails(int id, String name, String nameAuthor, int year, int weight, String isbn, String size, int page, String language, String description) {
        this.id = id;
        this.name = name;
        this.nameAuthor = nameAuthor;
        this.year = year;
        this.weight = weight;
        this.isbn = isbn;
        this.size = size;
        this.page = page;
        this.language = language;
        this.description = description;
    }

    public BookDetails(int id, int weight, String size) {
        this.id = id;
        this.weight = weight;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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
        return "BookDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nameAuthor='" + nameAuthor + '\'' +
                ", year=" + year +
                ", weight=" + weight +
                ", isbn='" + isbn + '\'' +
                ", size='" + size + '\'' +
                ", page=" + page +
                ", language='" + language + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
