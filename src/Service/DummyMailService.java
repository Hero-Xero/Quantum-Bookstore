package Service;

import Books.EBook;

public class DummyMailService implements MailService {
    @Override
    public void sendMail(EBook ebook, String email) {
        System.out.println("Sent '" + ebook.getTitle() + "' to " + email);
    }
}
