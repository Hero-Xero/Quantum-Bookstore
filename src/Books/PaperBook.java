package Books;


public class PaperBook extends Book {


    public PaperBook(String title, String ISBN, int year, int price) {
        super(title, ISBN, year, price);
    }


    @Override
    public boolean isDigital()
    {
        return false;
    }

}
