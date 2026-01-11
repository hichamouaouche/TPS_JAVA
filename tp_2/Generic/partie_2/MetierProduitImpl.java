import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IMetier<Product> {
    // Liste pour stocker les produits
    private List<Product> products = new ArrayList<>();

    @Override
    public void add(Product o) {
        products.add(o);
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product findById(long id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null; // Retourne null si pas trouvé
    }

    @Override
    public void delete(long id) {
        Product p = findById(id);
        if (p != null) {
            products.remove(p);
            System.out.println("Produit supprimé avec succès.");
        } else {
            System.out.println("Produit introuvable, suppression impossible.");
        }
    }
}