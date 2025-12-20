public class Artwork {
    //--Attributes--
    private String title;
    private String artist;
    private int date;
    private boolean copyrighted;
    private int price;
    //--Constructors--
    public Artwork (String title, String artist, int date, boolean copyrighted, int price) {
        this.title = title;
        this.artist = artist;
        this.date = date;
        this.copyrighted = copyrighted;
        this.price = price;
    }
    //--Getters and setters--
    //getting title of art
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    //getting artist of work
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    //getting date
    public int getDate() {
        return date;
    }
    public void setDate(int date) {
        this.date = date;
    }
    //getting if it's copyrighted or not
    public boolean getCopyrighted() {
        return copyrighted;
    }
    public void setCopyrighted(boolean copyrighted) {
        this.copyrighted = copyrighted;
    }
    //getting the price of artwork
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    //--Methods--
    public void printInfo() {
        String status;
        if (copyrighted) {
            status = "Copyrighted";
            System.out.println ("Title: " + title + "\nArtist: " + artist + "\nCreated: " + date + "\nStatus: " + status + "\nPrice: " + price);
        } else {
            status = "Not copyrighted";
            System.out.println ("Title: " + title + "\nArtist: " + artist + "\nCreated: " + date + "\nStatus: " + status + "\nPrice: " + price);
        }
    }
    //Comparing the worthiness and value of artworks
    public int compareWorthiness(Artwork other) {
        return Integer.compare(this.price, other.price);
    }
}

