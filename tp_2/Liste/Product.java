// Nom du fichier : Product.java

public class Product {
    // 1. Attributs demandés
    private long id;
    private String name;
    private double price;

    // Constructeur pour initialiser l'objet facilement
    public Product(long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters et Setters (pour accéder et modifier les données)
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    // Méthode toString pour un affichage propre dans la console
    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
    }
}