package Service;
import Books.EBook;

public interface MailService {
    void sendMail(EBook ebook, String email);
}
