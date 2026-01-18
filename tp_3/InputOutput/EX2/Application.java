import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // Initialize logic with the specific filename
        IProduitMetier metier = new MetierProduitImpl("products.dat");
        Scanner scanner = new Scanner(System.in);
        
        // Load existing data at start (optional, but good for user experience)
        metier.getAll();

        while (true) {
            System.out.println("\n--- PRODUCT MANAGEMENT MENU ---");
            System.out.println("1. Display list of products");
            System.out.println("2. Search product by ID");
            System.out.println("3. Add new product");
            System.out.println("4. Delete product by ID");
            System.out.println("5. Save products to file");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1: // Display
                    List<Product> list = metier.getAll();
                    if (list.isEmpty()) {
                        System.out.println("No products found.");
                    } else {
                        for (Product p : list) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 2: // Search
                    System.out.print("Enter Product ID to search: ");
                    long searchId = Long.parseLong(scanner.nextLine());
                    Product found = metier.findById(searchId);
                    if (found != null) {
                        System.out.println("Found: " + found);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 3: // Add
                    try {
                        System.out.print("Enter ID: ");
                        long id = Long.parseLong(scanner.nextLine());
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Brand: ");
                        String brand = scanner.nextLine();
                        System.out.print("Enter Price: ");
                        double price = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter Description: ");
                        String desc = scanner.nextLine();
                        System.out.print("Enter Stock: ");
                        int stock = Integer.parseInt(scanner.nextLine());

                        Product newProduct = new Product(id, name, brand, price, desc, stock);
                        metier.add(newProduct);
                    } catch (Exception e) {
                        System.out.println("Error entering data. Please try again.");
                    }
                    break;

                case 4: // Delete
                    System.out.print("Enter Product ID to delete: ");
                    long delId = Long.parseLong(scanner.nextLine());
                    metier.delete(delId);
                    break;

                case 5: // Save
                    metier.saveAll();
                    break;

                case 6: // Exit
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}