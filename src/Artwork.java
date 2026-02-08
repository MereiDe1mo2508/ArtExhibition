public class Artwork {
    //--Attributes--
    private String title;
    private String artist;
    private int date;
    private boolean copyrighted;
    private int price;
    //--Constructors
    public Artwork(String title, String artist, int date, boolean copyrighted, int price) {
        this.title = title;
        this.artist = artist;
        this.date = date;
        this.copyrighted = copyrighted;
        this.price = price;
    }

    public Artwork() {
    }

    //--Getters and Setters
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public int getDate() {
        return date;
    }
    public void setDate(int date) {
        this.date = date;
    }
    public boolean getCopyrighted() {
        return copyrighted;
    }
    public void setCopyrighted(boolean copyrighted) {
        this.copyrighted = copyrighted;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice() {
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

