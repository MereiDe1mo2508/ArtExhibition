//--Making a class abstract to use polymorphism in inhered class
abstract class Gallery {
    //--Attributes
    private String name;
    private String location;
    //--Constructors(encapsulation)
    public Gallery(String name, String location) {
        setName(name);
        setLocation(location);
    }
    //--Getters and setters--
    //getting gallery's name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    //getting the location of the gallery itself
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    //--Polymorphism and Abstraction--
    public String toString() {
        return "Gallery's name: " + name + "\nGallery's location: " + location;
    }
    public void printInfo() {
        System.out.println("Gallery's name: " + name + "\nGallery's location: " + location);
    }
    //--Polymorphism and Abstraction
    public abstract void showCategories();
}
