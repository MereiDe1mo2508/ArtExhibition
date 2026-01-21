import java.sql.*;
//--OUTPUT 7: Creating database and connect SQL with JDBC (advanced)
void main() throws Exception {
    Scanner scanner = new Scanner(System.in);
    Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/simpledb", "postgres", "y1pp33");
    while (true) {
        IO.println("Enter command: ");
        IO.println("1. Get all artworks: ");
        IO.println("2. Get artwork by id: ");
        IO.println("3. Create artwork: ");
        IO.println("4. Delete artwork: ");
        IO.println("0. Exit");
        try {
            IO.print("Enter your choice (1-3): ");
            int choice = scanner.nextInt();
            if (choice == 1) {
                Statement statement = connection.createStatement();
                String query = "SELECT * FROM artwork order by artwork_id desc;";
                statement.executeQuery(query);
                ResultSet result = statement.executeQuery(query);
                while (result.next()) {
                    IO.println(result.getInt("artwork_id") + " " + result.getString("title") + " " + result.getString("artist") + result.getInt("date_of_creating") + " " + result.getBoolean("copyrighted"));
                }
            } else if (choice == 2) {
                String sql = "UPDATE artwork SET copyrighted = 'yes' WHERE artwork_id = ?;";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                IO.println("Input integer: ");
                int id = scanner.nextInt();
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            } else if (choice == 3) {
                String sql = "INSERT INTO artwork(artwork_id, title, artist, date_of_creating, copyrighted) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                scanner.nextLine();
                IO.println("Input integer: ");
                preparedStatement.setInt(1, Integer.parseInt(scanner.nextLine()));
                IO.println("Input title: ");
                preparedStatement.setString(2, scanner.nextLine());
                IO.println("Input artist: ");
                preparedStatement.setString(3, scanner.nextLine());
                IO.println("Input date_of_creating: ");
                preparedStatement.setInt(4, Integer.parseInt(scanner.nextLine()));
                IO.println("Input copyrighted: ");
                preparedStatement.setBoolean(5, scanner.nextBoolean());
                preparedStatement.executeUpdate();
            } else if (choice == 4) {
                String sql = "DELETE FROM artwork WHERE artwork_id = ?;";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                IO.println("Input integer: ");
                scanner.nextLine();
                int id = Integer.parseInt(scanner.nextLine());
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            } else if (choice == 0) {
                System.exit(0);
            } else {
                break;
            }
        } catch (InputMismatchException e) {
            IO.println("Invalid input!");
            scanner.nextLine();
        } catch (Exception e) {
            IO.println(e.getMessage());
        }
    }
}