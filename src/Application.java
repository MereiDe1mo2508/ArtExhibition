import controllers.artworkController;
import data.PostgresDB;
import data.interfaces.IDB;
import repositories.interfaces.IartworkRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;
//--OUTPUT 7: Creating database and connect SQL with JDBC (advanced)
public class Application {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        IDB db = new PostgresDB();
        IartworkRepository repository;
        Connection connection = db.getConnection();
        while (true) {
            System.out.println("Enter command: ");
            System.out.println("1. Get all artworks: ");
            System.out.println("2. Get artwork by id: ");
            System.out.println("3. Create artwork: ");
            System.out.println("0. Exit");
            try {
                System.out.print("Enter your choice (1-3): ");
                int choice = scanner.nextInt();
                if (choice == 1) {
                    Statement statement = connection.createStatement();
                    String query = "SELECT * FROM artwork order by artwork_id desc;";
                    statement.executeQuery(query);
                    ResultSet result = statement.executeQuery(query);
                    while (result.next()) {
                        System.out.println(result.getInt("artwork_id") + " " + result.getString("title") + " " + result.getString("artist") + result.getInt("date_of_creating") + " " + result.getBoolean("copyrighted"));
                    }
                } else if (choice == 2) {
                    String sql = "UPDATE artwork SET copyrighted = 'yes' WHERE artwork_id = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    System.out.println("Input integer: ");
                    int id = scanner.nextInt();
                    preparedStatement.setInt(1, id);
                    preparedStatement.executeUpdate();
                } else if (choice == 3) {
                    String sql = "INSERT INTO artwork VALUES (?, ?, ?, ?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    System.out.println("Input integer: ");
                    scanner.nextLine();
                    String title = scanner.nextLine();
                    preparedStatement.setString(1, title);
                    preparedStatement.executeUpdate();
                } else if (choice == 0) {
                    System.exit(0);
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input!");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}