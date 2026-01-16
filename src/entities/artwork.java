package entities;

public class artwork {
    private int id;
    private String title;
    private String artist;
    private int date_of_creating;
    private boolean copyrighted;
    public artwork(int id) {

    }
    public artwork(String title, String artist, int date_of_creating, boolean copyrighted) {
        setTitle(title);
        setArtist(artist);
        setDate_of_creating(date_of_creating);
        setCopyrighted(copyrighted);
    }
    public artwork(int id, String title, String artist, int date_of_creating, boolean copyrighted) {
        this(title, artist, date_of_creating, copyrighted);
        setId(id);
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
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
    public int getDate_of_creating() {
        return date_of_creating;
    }
    public void setDate_of_creating(int date_of_creating) {
        this.date_of_creating = date_of_creating;
    }
    public boolean getCopyrighted() {
        return copyrighted;
    }
    public void setCopyrighted(boolean copyrighted) {
        this.copyrighted = copyrighted;
    }
    @Override
    public String toString() {
        return "artwork{" + "id=" + id + ", title=" + title + ", artist=" + artist + ", date_of_creating=" + date_of_creating  + ", copyrighted=" + (copyrighted?"yes":"no") +"}";
    }
}
