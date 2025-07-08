package Service;

import Books.PaperBook;

public interface ShippingService {
    void shipBook(PaperBook paperBook, String address, int quantity);

}
