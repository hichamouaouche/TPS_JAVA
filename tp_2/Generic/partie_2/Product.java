public class Product {
    private long id;
    private String name;
    private String brand;
    private double price;
    private String description;
    private int stock;

    // Constructeur sans paramètres
    public Product() {}

    // Constructeur avec paramètres
    public Product(long id, String name, String brand, double price, String description, int stock) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }

    // Getters et Setters (nécessaires pour accéder aux données)
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    
    // toString pour l'affichage facile
    @Override
    public String toString() {
        return "Product [id=" + id + ", nom=" + name + ", marque=" + brand + ", prix=" + price + "]";
    }
}