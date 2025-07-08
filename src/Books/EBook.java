package Books;

import Service.MailService;
import people.Customer;


public class EBook extends Book {

    private Customer customer;
    private String filetype;

    public EBook(String filetype, String title, String ISBN, int year, int price) {
        super(title, ISBN, year, price);
        this.filetype = filetype;
    }


    public String getFiletype() {
        return filetype;
    }
    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public void sendByMail(MailService mailService, Customer customer) {
        mailService.sendMail(this, customer.getAddress());
    }



    @Override
    public boolean isDigital()
    {
        return true;
    }

}
