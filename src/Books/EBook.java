package Books;

import Service.MailService;


public class EBook extends Book {

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


    @Override
    public boolean isDigital()
    {
        return true;
    }

}
