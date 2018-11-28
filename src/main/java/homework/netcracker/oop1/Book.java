package homework.netcracker.oop1;

import java.util.Arrays;

public class Book {
    private String name;
    private Author[] authors;
    private double price;
    private int qty = 0;

    public Book(String name, Author[] authors, double price) {
        this.name = name;
        this.authors = authors;
        this.price = price;
    }

    public Book(String name, Author[] authors, double price, int qty) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name=?" +
                ", authors={Author[name=?, email=?, gender=?],......}" +
                ", price=?" +
                ", qty=?" +
                '}';
    }

    public String getAuthorNames() {
        return "authorName1,authorName2";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return book.price == price &&
                qty == book.qty &&
                name.equals(book.name) &&
                Arrays.equals(authors, book.authors);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + name.hashCode();
        result = result * 31 + Arrays.hashCode(authors);
        result = result * 31 + Double.hashCode(price);
        result = result * 31 + qty;
        return result;
    }
}
