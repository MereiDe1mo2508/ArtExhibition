public class Artist {
    //--Attributes--
    private String name;
    private int age;
    //--Constructors--
    public Artist(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //--Getters and setters--
    //getting the name of artist of artwork
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    //getting age of artist(doesn't matter if artist is alive or dead)
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    //--Methods--
    public void printInfo() {
        System.out.println("Artist's name: " + name);
        System.out.println("Artist's age: " + age);
    }
}
