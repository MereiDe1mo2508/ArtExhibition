public class artworkprice extends Artwork {
    public artworkprice(String title, String artist, int date, boolean copyrighted, int price) {
        super(title, artist, date, copyrighted, price);
    }
    public static void compare(Artwork artwork1, Artwork artwork2) {
        Artwork[] artworks = {artwork1, artwork2};

        int maxprice = 0;
        for(int i = 0; i < artworks.length; i++) {
            int currentprice = artworks[i].getPrice();
            System.out.println("Artwork " + (i + 1) + " price: " + currentprice + "$");

            if(currentprice > maxprice) {
                maxprice = currentprice;
            }
        }
        System.out.println("Most expensive artwork price: " + maxprice + "$");
    }
}
