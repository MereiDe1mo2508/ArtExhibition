import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws Exception{
    //--Create objects (instances of classes)--
        System.out.println("\n===ART EXHIBITION===");
        Artwork artwork1 = new Artwork ("Mona Lisa", "Leonardo Da Vinci", 1517,false, 800000000) ;
        Artwork artwork2 = new Artwork ("Starry Night", "Vincent Van Gogh", 1889, false, 1000000000);
        Artist artist1 = new Artist ("Leonardo Da Vinci", 67);
        Artist artist2 = new Artist ("Vincent Van Gogh", 37);
        Gallery gallery1 = new Gallery("Louvre museum", "Paris, France") {
            @Override
            public void showCategories() {
                System.out.println("paintings, sculptures and artifacts");
            }
        };
        Gallery gallery2 = new Gallery("Museum of Modern Art", "New York City, USA") {
            @Override
            public void showCategories() {
                System.out.println("painting, sculpture, photography, design, film");
            }
        };
        //--OUTPUT 1: Print all--
        artwork1.printInfo();
        artwork2.printInfo();
        artist1.printInfo();
        artist2.printInfo();
        gallery1.printInfo();
        gallery2.printInfo();
        //--OUTPUT 2: Compare prices (OOP + if/else)--
        System.out.println("\n===ARTWORK WORTHINESS COMPARISON===");
        int comparison = artwork1.compareWorthiness(artwork2);
        if (comparison > 0) {
            System.out.println("Artwork1 is worthy than Artwork2");
        } else if (comparison < 0) {
            System.out.println("Artwork2 is worthy than Artwork1");
        } else {
            System.out.println("Both artworks are in the same prices");
        }
        //--OUTPUT 3: Java Basics - Counting copyrights--
        System.out.println("\n===COUNT ON COPYRIGHTS===");
        int copyrights = 0;
        if(artwork1.getCopyrighted()) {
            copyrights++;
        }
        if(artwork2.getCopyrighted()) {
            copyrights++;
        }
        System.out.println("Numbers of copyrighted artworks: " + copyrights);
        //--OUTPUT 4: Java Basics - array + for loop--
        System.out.println("\n===LOOP THROUGH ARTWORK PRICES===");
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
        //--OUTPUT 5: Equals and hashcode method
        System.out.println(artist1.equals(artwork1));
        System.out.println(artist2.equals(artwork2));
        System.out.println(artist1.equals(artist2));
        System.out.println(artist1.hashCode());
        System.out.println(artist2.hashCode());
        //--OUTPUT 6: Creating database and connect SQL with JDBC (easy)
        String connectionURL = "jdbc:postgresql://localhost:5432/simpledb";
        Connection conn = null;
        ResultSet rs = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(connectionURL, "postgres", "y1pp33");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from artist;");
            while (rs.next())
                System.out.println(rs.getInt("artist_id") + " " + rs.getString("artist_name") + " " + rs.getString("artist_age") + " " + rs.getInt("artwork_id"));
        }
        catch (Exception e) {
            System.out.println("Exception occurred!");
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception occurred!");
            }
        }
        System.out.println("Finished!");
    }
}