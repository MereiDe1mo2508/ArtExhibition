import java.lang.Override;
//--Inheritance of the gallery--
public class ArtCollection extends Gallery {
    //--Attributes--
    private String category;
    //--Constructors--
    public ArtCollection(String name, String location, String category) {
        super(name, location);
        this.category = category;
    }
    //--getters
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    //--Polymorphism method using toString and override
    public String toString() {
        return "Gallery's name: " + getName() + "\nGallery's location: " + getLocation();
    }
    @Override
    public void showCategories() {
        System.out.println("Types of arts in gallery: " + getCategory());
    }
}
