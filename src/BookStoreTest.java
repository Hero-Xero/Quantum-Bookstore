import Books.Book;
import Books.EBook;
import Books.PaperBook;
import Books.ShowcaseBook;
import Service.DummyMailService;
import Service.DummyShippingService;
import Service.MailService;
import Service.ShippingService;
import Storage.Inventory;

import java.util.List;

public class BookStoreTest {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        MailService mailService = new DummyMailService();
        ShippingService shippingService = new DummyShippingService();
        Checkout checkout = new Checkout(inventory, shippingService, mailService);

        Book ebook = new EBook("pdf", "Effective Java", "123", 2018, 30);
        Book paperBook = new PaperBook("Clean Code", "111", 2008, 134);
        Book showcaseBook = new ShowcaseBook("life", "435", 2003, 114);

        inventory.addBook(showcaseBook, 1);
        inventory.addBook(ebook, 5);
        inventory.addBook(paperBook, 2);

        try {
            checkout.buyBook("435", 1, "user@example.com", "Nowhere");
            throw new AssertionError("Expected error when buying a ShowcaseBook");
        } catch (IllegalArgumentException e) {
            System.out.println("Quantum book store: Correctly blocked purchase of ShowcaseBook.");
        }


        if (inventory.getItem("111").getQuantity() != 5) {
            throw new AssertionError("Expected quantity 5 for ebook before purchase");
        }

        checkout.buyBook("111", 1, "user@example.com", null);

        if (inventory.getItem("111").getQuantity() != 4) {
            throw new AssertionError("Expected quantity 4 for ebook after purchase");
        }

        checkout.buyBook("222", 2, "user2@example.com", "123 Street");

        if (inventory.getItem("222") != null) {
            throw new AssertionError("Expected printed book to be removed or have 0 stock");
        }

        List<Book> removed = inventory.removeOutdatedBooks(10);  // Remove books older than 10 years

        boolean foundCleanCode = false;
        boolean foundEffectiveJava = false;

        for (Book b : removed) {
            if (b.getIsbn().equals("222")) {
                foundCleanCode = true;
            }
            if (b.getIsbn().equals("111")) {
                foundEffectiveJava = true;
            }
        }

        if (!foundCleanCode) {
            throw new AssertionError("Expected Clean Code to be removed as outdated.");
        }

        if (foundEffectiveJava) {
            throw new AssertionError("Did NOT expect Effective Java to be removed.");
        }


        System.out.println(" All tests passed.");
    }
}
