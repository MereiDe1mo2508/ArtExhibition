import controllers.artworkController;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Application {
    private artworkController controller;
    private Scanner scanner;
    public Application(artworkController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }
    public void start() {
        while(true) {
            System.out.println();
            System.out.println("Welcome to the artwork program!");
            System.out.println("Enter command: ");
            System.out.println("1. Get all artworks: ");
            System.out.println("2. Get artwork by id: ");
            System.out.println("3. Create artwork: ");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter your choice (1-3): ");
                int choice = scanner.nextInt();
                if (choice == 1) {
                    getAllArtworksMenu();
                } else if (choice == 2) {
                    getArtworkByIdMenu();
                } else if (choice == 3) {
                    createArtworkMenu();
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
        System.out.println("Goodbye!");
    }
    public void getAllArtworksMenu() {
        String response = controller.getAllArtworks();
        System.out.println(response);
    }
    public void getArtworkByIdMenu() {
        System.out.println("Get artwork by id:");
        int id = scanner.nextInt();
        String response = controller.getArtwork(id);
    }
    public void createArtworkMenu() {
        System.out.println("Input title:");
        String title = scanner.next();
        System.out.println("Input artist:");
        String artist = scanner.next();
        System.out.println("Input date:");
        int date_of_creating = Integer.parseInt(scanner.next());
        System.out.println("Is copyrighted?:");
        Boolean copyrighted = Boolean.valueOf(scanner.next());
        String response = controller.createArtwork(title, artist, date_of_creating, String.valueOf(copyrighted));
        System.out.println(response);
    }
}
//--I feel like i can't do these whole DBMS stuff, even easiest one