import Service.ShippingService;

import java.time.LocalDate;

public class PaperBook extends Book {

    private int stock;

    public PaperBook(String title, String ISBN, LocalDate publishDate, int price, int stock) {
        super(title, ISBN, publishDate, price);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void deliverToCustomer(ShippingService shippingService, Customer customer) {
        shippingService.ship(this, customer.getAddress());
    }





}
