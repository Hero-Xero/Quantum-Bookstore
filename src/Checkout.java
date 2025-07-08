import Books.EBook;
import Books.Book;
import Books.PaperBook;
import Service.MailService;
import Service.ShippingService;
import Storage.Inventory;
import Storage.InventoryItem;


public class Checkout {

    private final Inventory inventory;
    private final ShippingService shippingService;
    private final MailService mailService;

    public Checkout(Inventory inventory, ShippingService shippingService, MailService mailService) {
        this.inventory = inventory;
        this.shippingService = shippingService;
        this.mailService = mailService;
    }

    public void buyBook(String isbn, int quantity, String email, String address) {
        InventoryItem item = inventory.getItem(isbn);

        if (item == null) {
            throw new IllegalArgumentException("Book not found.");
        }

        if (item.getQuantity() < quantity) {
            throw new IllegalStateException("Not enough stock.");
        }

        Book book = item.getBook();

        inventory.reduceStock(isbn, quantity);

        if (book.isDigital()) {
            mailService.sendMail((EBook) book, email);

        } else {
            shippingService.shipBook((PaperBook) book, address, quantity);
        }

        System.out.println("Paid amount: " + book.getPrice() * quantity);
    }
}
