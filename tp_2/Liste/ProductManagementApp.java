// Nom du fichier : ProductManagementApp.java

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManagementApp {
    public static void main(String[] args) {
        
        // 3. Création de l'ArrayList
        List<Product> products = new ArrayList<>();

        // --- A. Add products (Ajouter des produits) ---
        products.add(new Product(1L, "Laptop Dell", 1200.50));
        products.add(new Product(2L, "Souris Logitech", 25.00));
        products.add(new Product(3L, "Clavier Mécanique", 75.00));
        products.add(new Product(4L, "Ecran Samsung", 300.00));

        System.out.println("--- Liste initiale ---");
        displayProducts(products);

        // --- B. Delete a product by index (Supprimer par index) ---
        // Suppression du 2ème élément (index 1 car l'index commence à 0)
        if (products.size() > 1) {
            System.out.println("\n>> Suppression du produit à l'index 1...");
            products.remove(1); 
        }

        // --- C. Display the list (Afficher la liste) ---
        System.out.println("--- Liste après suppression ---");
        displayProducts(products);

        // --- D. Modify a product by index (Modifier par index) ---
        // Modification du premier produit (index 0)
        if (!products.isEmpty()) {
            System.out.println("\n>> Modification du prix du produit à l'index 0...");
            Product productToUpdate = products.get(0);
            productToUpdate.setPrice(999.99); // On change le prix
            // Alternative : products.set(0, new Product(1L, "Laptop Dell Pro", 1500.00));
        }
        
        displayProducts(products); // Vérification visuelle

        // --- E. Search for a product by name (Recherche par nom saisi utilisateur) ---
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEntrez le nom du produit à chercher : ");
        String searchName = scanner.nextLine();

        boolean found = false;
        for (Product p : products) {
            // Utilisation de equalsIgnoreCase pour ignorer les majuscules/minuscules
            if (p.getName().equalsIgnoreCase(searchName)) {
                System.out.println("Produit trouvé : " + p);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Aucun produit trouvé avec ce nom.");
        }

        scanner.close();
    }

    // Méthode utilitaire pour afficher la liste (évite de répéter la boucle)
    public static void displayProducts(List<Product> list) {
        for (Product p : list) {
            System.out.println(p);
        }
    }
}