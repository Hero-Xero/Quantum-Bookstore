package Storage;

import Books.Book;

import java.time.Year;
import java.util.*;

public class Inventory {
    private Map<String, InventoryItem> items = new HashMap<>();

    public void addBook(Book book, int quantity) {
        String isbn = book.getIsbn();
        if (items.containsKey(isbn)) {
            items.get(isbn).increaseQuantity(quantity);
        } else {
            items.put(isbn, new InventoryItem(book, quantity));
        }
    }

    public InventoryItem getItem(String isbn) {
        return items.get(isbn);
    }

    public boolean hasStock(String isbn, int requestedQuantity) {
        InventoryItem item = items.get(isbn);
        return item != null && item.getQuantity() >= requestedQuantity;
    }

    public void reduceStock(String isbn, int quantity) {
        InventoryItem item = items.get(isbn);
        if (item == null || item.getQuantity() < quantity) {
            throw new IllegalArgumentException("Insufficient stock.");
        }
        item.decreaseQuantity(quantity);
    }

    public List<Book> removeOutdatedBooks(int maxAgeYears) {
        List<Book> removedBooks = new ArrayList<>();
        int currentYear = Year.now().getValue();

        Iterator<Map.Entry<String, InventoryItem>> iterator = items.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, InventoryItem> entry = iterator.next();
            Book book = entry.getValue().getBook();
            int age = currentYear - book.getYear();

            if (age > maxAgeYears) {
                removedBooks.add(book);
                iterator.remove();
            }
        }

        return removedBooks;
    }

}
