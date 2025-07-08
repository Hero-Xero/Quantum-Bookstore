import Service.MailService;

import java.time.LocalDate;

public class EBook extends Book {

    private Customer customer;
    private String filetype;

    public EBook(String filetype, String title, String ISBN, LocalDate publishDate, int price) {
        super(title, ISBN, publishDate, price);
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

}
