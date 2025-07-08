import Books.Book;
import Books.EBook;
import Books.PaperBook;
import Service.DummyMailService;
import Service.DummyShippingService;
import Service.MailService;
import Service.ShippingService;
import Storage.Inventory;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        MailService mailService = new DummyMailService();
        ShippingService shippingService = new DummyShippingService();
        Checkout checkout = new Checkout(inventory, shippingService, mailService);

        Book ebook = new EBook("pdf", "The Restaurant at the End of the Universe", "111", 2018, 30);
        Book paperBook = new PaperBook("Clean Code", "222", 2008, 45);

        inventory.addBook(ebook, 5);
        inventory.addBook(paperBook, 5);

        checkout.buyBook("111", 1, "user@example.com", null);
        checkout.buyBook("222", 2, "user2@example.com", "123 Main St");


        System.out.println("Purchase complete.");
    }
}
