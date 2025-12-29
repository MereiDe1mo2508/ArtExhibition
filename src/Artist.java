import java.util.Objects;
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
    //--Equals (will divide by two comparisons)
    //1)Checking if artist in artwork class has the same address in the name in artist class(it must output true)
    //2)Checking if artists in two different artworks are same(dependent which artwork you're inputting)
    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if(obj instanceof Artist anotherArtist) {
            return this.name.equals(anotherArtist.name);
        }
        if(obj instanceof Artwork artwork) {
            return this.name.equals(artwork.getArtist());
        }
        return false;
    }
    //--Hashcode(small code that is returning only artist's name address)
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
