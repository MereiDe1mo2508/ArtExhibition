public class Artist {
    //--Attributes--
    private String name;
    private int age;
    private boolean isAlive;
    //--Constructors--
    private Artist(ArtistBuilder builder) {
        name = builder.name;
        age = builder.age;
        isAlive = builder.isAlive;
    }
    public static class ArtistBuilder {
        private String name;
        private int age;
        private boolean isAlive;
        public ArtistBuilder(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public ArtistBuilder wantStatus(boolean isAlive) {
            this.isAlive = isAlive;
            return this;
        }
        public Artist build() {
            return new Artist(this);
        }
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
            return this.getClass().equals(anotherArtist.getClass());
        }
        if(obj instanceof Artwork artwork) {
            return this.getClass().equals(artwork.getArtist());
        }
        return false;
    }
    //--Hashcode(small code that is returning only artist's name address)
    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }
}