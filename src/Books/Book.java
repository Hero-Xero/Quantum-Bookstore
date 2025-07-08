import java.time.LocalDate;


public abstract class Book {

    protected String title;
    protected String ISBN;
    protected LocalDate publishDate;
    protected int price;

    public Book(String title, String ISBN, LocalDate publishDate, int price) {
        this.title = title;
        this.ISBN = ISBN;
        this.publishDate = publishDate;
        this.price = price;
    }
}
