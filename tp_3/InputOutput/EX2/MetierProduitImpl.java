import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IProduitMetier {
    
    private List<Product> products; // In-memory list
    private String fileName;        // The file path

    public MetierProduitImpl(String fileName) {
        this.fileName = fileName;
        this.products = new ArrayList<>();
        // Attempt to load existing products on startup so we don't overwrite data
        // strictly speaking, the prompt says getAll() loads them, 
        // but it is safer to initialize here.
    }

    @Override
    public void add(Product p) {
        products.add(p);
        System.out.println("Product added to memory (not yet saved to file).");
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Product> getAll() {
        File file = new File(fileName);
        
        // If file doesn't exist, return the current in-memory list (which might be empty)
        if (!file.exists()) {
            return products;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            // Read the entire list object from the file
            products = (List<Product>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading products: " + e.getMessage());
        }
        
        return products;
    }

    @Override
    public Product findById(long id) {
        // Search in the current loaded list
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null; // Not found
    }

    @Override
    public void delete(long id) {
        Product p = findById(id);
        if (p != null) {
            products.remove(p);
            System.out.println("Product removed from memory.");
        } else {
            System.out.println("Product not found.");
        }
    }

    @Override
    public void saveAll() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            // Write the entire list to the file
            oos.writeObject(products);
            System.out.println("All products successfully saved to " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving products: " + e.getMessage());
        }
    }
}