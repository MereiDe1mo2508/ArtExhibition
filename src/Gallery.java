public class Gallery {
    //--Attributes
    private String name;
    private String location;
    //--Constructors
    public Gallery(String name, String location) {
        this.name = name;
        this.location = location;
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
    public void setLocation(String address) {
        this.location = location;
    }
    //--Methods--
    public void printInfo() {
        System.out.println("Gallery's name: " + name);
        System.out.println("Gallery's location: " + location);
    }
}
