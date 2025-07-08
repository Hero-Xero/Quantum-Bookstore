package Books;

public abstract class Book {

    protected String title;
    protected String isbn;
    protected int year;
    protected int price;

    public Book(String title, String isbn, int year, int price) {
        this.title = title;
        this.isbn = isbn;
        this.year = year;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Boolean isforSale()
    {
        return true;
    }

    public abstract boolean isDigital();
}
