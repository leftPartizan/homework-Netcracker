package homework.Netcracker.swing;

public class Book {
    private String name;
    private Author author;
    private String genre;
    private String inLanguage;
    private int numberOfPages;
    private int count;

    public Book() {
    }

    public Book(String name, Author author, String genre, String inLanguage, int numberOfPages, int count) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.inLanguage = inLanguage;
        this.numberOfPages = numberOfPages;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getInLanguage() {
        return inLanguage;
    }

    public void setInLanguage(String inLanguage) {
        this.inLanguage = inLanguage;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name  +
                ", author= " + author.toString() +
                ", genre= " + genre +
                ", language= " + inLanguage +
                ", numberOfPages= " + numberOfPages +
                ", count= " + count + '\'' +
                '}';
    }
}