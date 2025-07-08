package Service;

import Books.PaperBook;

public class DummyShippingService implements ShippingService {
    @Override
    public void shipBook(PaperBook book, String address, int quantity) {
        System.out.println("Shipped " + quantity + " copies of '" + book.getTitle() + "' to " + address);
    }
}
