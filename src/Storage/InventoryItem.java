package Storage;

import Books.Book;

public class InventoryItem {

    private Book book;
    private int quantity;

    public InventoryItem(Book book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    public void increaseQuantity(int amount) {
        this.quantity += amount;
    }

    public void decreaseQuantity(int amount) {
        if (amount > this.quantity) {
            throw new IllegalArgumentException("Not enough stock.");
        }
        this.quantity -= amount;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
