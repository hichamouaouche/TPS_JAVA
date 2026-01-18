import java.io.Serializable;

public class Product implements Serializable {
    // It is good practice to add a serialVersionUID to ensure version compatibility
    private static final long serialVersionUID = 1L;

    private long id;
    private String name;
    private String brand;
    private double price;
    private String description;
    private int stockCount;

    // Constructor
    public Product(long id, String name, String brand, double price, String description, int stockCount) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.description = description;
        this.stockCount = stockCount;
    }

    // Getters and Setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getStockCount() { return stockCount; }
    public void setStockCount(int stockCount) { this.stockCount = stockCount; }

    @Override
    public String toString() {
        return "Product [ID=" + id + ", Name=" + name + ", Brand=" + brand + 
               ", Price=" + price + ", Stock=" + stockCount + "]";
    }
}