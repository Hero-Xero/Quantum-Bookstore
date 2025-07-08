package Books;


public class ShowcaseBook extends Book {

    public ShowcaseBook(String title, String ISBN, int year, int price) {
        super(title, ISBN, year, price);
    }

    @Override
    public Boolean isforSale()
    {
        return false;
    }


    @Override
    public boolean isDigital()
    {
        return false;
    }
}
