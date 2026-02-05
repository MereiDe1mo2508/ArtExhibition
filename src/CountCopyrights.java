public class CountCopyrights extends Artwork{
    public CountCopyrights(String title, String artist, int date, boolean copyrighted, int price) {
        super(title, artist, date, copyrighted, price);
    }
    public static void find(Artwork artwork1, Artwork artwork2) {
        Artwork[] artwork = {artwork1, artwork2};
        int copyrights = 0;
        if(artwork1.getCopyrighted()) {
            copyrights++;
        }
        if(artwork2.getCopyrighted()) {
            copyrights++;
        }
    }
}
