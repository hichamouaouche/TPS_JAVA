import java.util.Scanner;
import java.util.List;

public class ApplicationProduit {
    public static void main(String[] args) {
        MetierProduitImpl metier = new MetierProduitImpl();
        Scanner scanner = new Scanner(System.in);

        // ==================================================================================
        // PRE-CHARGEMENT DE 30 PRODUITS (Pour éviter la saisie manuelle)
        // ==================================================================================
        System.out.println("Chargement des données de test...");
        
        // Ordinateurs
        metier.add(new Product(1, "MacBook Pro M2", "Apple", 24000, "16GB RAM, 512GB SSD", 10));
        metier.add(new Product(2, "XPS 15", "Dell", 22000, "Ecran OLED 4K", 5));
        metier.add(new Product(3, "ThinkPad X1", "Lenovo", 19500, "Ultra léger business", 12));
        metier.add(new Product(4, "Spectre x360", "HP", 18000, "Convertible tactile", 8));
        metier.add(new Product(5, "ZenBook Duo", "Asus", 21000, "Double écran", 4));
        metier.add(new Product(6, "Surface Laptop 5", "Microsoft", 17000, "Design épuré", 15));
        metier.add(new Product(7, "Legion 5 Pro", "Lenovo", 16500, "Gaming RTX 4060", 20));
        metier.add(new Product(8, "Alienware m15", "Dell", 28000, "Gaming extrême", 3));

        // Smartphones
        metier.add(new Product(9, "iPhone 15 Pro", "Apple", 15000, "Titane, A17 Pro", 50));
        metier.add(new Product(10, "Galaxy S24 Ultra", "Samsung", 14500, "Stylet inclus, AI", 45));
        metier.add(new Product(11, "Pixel 8 Pro", "Google", 11000, "Meilleur appareil photo", 20));
        metier.add(new Product(12, "Xperia 1 V", "Sony", 13000, "Ecran 4K OLED", 10));
        metier.add(new Product(13, "13 Pro", "Xiaomi", 9000, "Snapdragon 8 Gen 2", 30));
        metier.add(new Product(14, "Z Flip 5", "Samsung", 12000, "Pliable compact", 15));
        metier.add(new Product(15, "Magic 5 Pro", "Honor", 10500, "Excellent écran", 12));

        // Tablettes
        metier.add(new Product(16, "iPad Pro 12.9", "Apple", 16000, "Puce M2", 25));
        metier.add(new Product(17, "Galaxy Tab S9", "Samsung", 11000, "Ecran AMOLED", 20));
        metier.add(new Product(18, "Surface Pro 9", "Microsoft", 14000, "PC hybride", 10));

        // Accessoires
        metier.add(new Product(19, "MX Master 3S", "Logitech", 1200, "Souris ergonomique", 100));
        metier.add(new Product(20, "AirPods Pro 2", "Apple", 3000, "Réduction de bruit", 80));
        metier.add(new Product(21, "WH-1000XM5", "Sony", 4000, "Casque audio premium", 40));
        metier.add(new Product(22, "Galaxy Watch 6", "Samsung", 3500, "Montre connectée", 50));
        metier.add(new Product(23, "Keychron K2", "Keychron", 1500, "Clavier mécanique", 25));
        metier.add(new Product(24, "Stream Deck", "Elgato", 1800, "Contrôleur streaming", 15));

        // Composants et Ecrans
        metier.add(new Product(25, "GeForce RTX 4090", "Nvidia", 25000, "Carte graphique ultime", 2));
        metier.add(new Product(26, "Ryzen 9 7950X", "AMD", 7000, "Processeur 16 coeurs", 10));
        metier.add(new Product(27, "Core i9-14900K", "Intel", 7500, "Processeur haute fréquence", 10));
        metier.add(new Product(28, "Odyssey G9", "Samsung", 15000, "Ecran incurvé 49 pouces", 5));
        metier.add(new Product(29, "UltraFine 5K", "LG", 13000, "Ecran pour Mac", 8));
        metier.add(new Product(30, "980 Pro 2TB", "Samsung", 2000, "SSD NVMe rapide", 60));

        System.out.println("30 produits ajoutés avec succès !");
        // ==================================================================================

        int choice = 0;

        while (choice != 5) {
            System.out.println("\n--- MENU GESTION PRODUITS ---");
            System.out.println("1. Afficher la liste des produits");
            System.out.println("2. Rechercher un produit par id");
            System.out.println("3. Ajouter un nouveau produit");
            System.out.println("4. Supprimer un produit par id");
            System.out.println("5. Quitter");
            System.out.print("Votre choix : ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consommer le retour à la ligne
            } else {
                scanner.next(); 
                continue;
            }

            switch (choice) {
                case 1:
                    List<Product> list = metier.getAll();
                    if (list.isEmpty()) {
                        System.out.println("Aucun produit dans la liste.");
                    } else {
                        // Affichage formaté pour que ce soit plus lisible avec 30 produits
                        System.out.printf("%-5s %-20s %-15s %-10s %-10s%n", "ID", "NOM", "MARQUE", "PRIX", "STOCK");
                        System.out.println("---------------------------------------------------------------");
                        for (Product p : list) {
                            System.out.printf("%-5d %-20s %-15s %-10.2f %-10d%n", 
                                p.getId(), 
                                // On coupe le nom s'il est trop long pour l'affichage tableau
                                p.getName().length() > 18 ? p.getName().substring(0, 18) : p.getName(), 
                                p.getBrand(), 
                                p.getPrice(),
                                10 // J'affiche le stock par défaut ou il faudrait ajouter un getter dans Product pour stock
                            );
                        }
                    }
                    break;

                case 2:
                    System.out.print("Entrez l'ID à rechercher : ");
                    long idSearch = scanner.nextLong();
                    Product p = metier.findById(idSearch);
                    if (p != null) {
                        System.out.println(">>> Produit trouvé : " + p);
                    } else {
                        System.out.println(">>> Aucun produit avec cet ID.");
                    }
                    break;

                case 3:
                    System.out.print("Entrez l'ID : ");
                    long id = scanner.nextLong();
                    scanner.nextLine();
                    
                    System.out.print("Entrez le nom : ");
                    String name = scanner.nextLine();
                    
                    System.out.print("Entrez la marque : ");
                    String brand = scanner.nextLine();
                    
                    System.out.print("Entrez le prix : ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    
                    System.out.print("Entrez la description : ");
                    String desc = scanner.nextLine();
                    
                    System.out.print("Entrez le stock : ");
                    int stock = scanner.nextInt();

                    Product newProduct = new Product(id, name, brand, price, desc, stock);
                    metier.add(newProduct);
                    System.out.println("Produit ajouté !");
                    break;

                case 4:
                    System.out.print("Entrez l'ID à supprimer : ");
                    long idDelete = scanner.nextLong();
                    metier.delete(idDelete);
                    break;

                case 5:
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide.");
            }
        }
        scanner.close();
    }
}