import java.util.List;

public interface IProduitMetier {
    public void add(Product p);
    public List<Product> getAll();
    public Product findById(long id);
    public void delete(long id);
    public void saveAll();
}