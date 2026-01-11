import java.util.ArrayList;
import java.util.List;

public class GenericStorage<T> {
    // Attribut pour stocker les éléments
    private List<T> elements;

    // Constructeur pour initialiser la liste
    public GenericStorage() {
        this.elements = new ArrayList<>();
    }

    // Méthode pour ajouter un élément
    public void addElement(T o) {
        elements.add(o);
    }

    // Méthode pour supprimer un élément par index
    public void removeElement(int index) {
        if (index >= 0 && index < elements.size()) {
            elements.remove(index);
        } else {
            System.out.println("Index invalide !");
        }
    }

    // Méthode pour récupérer un élément par index
    public T getElement(int index) {
        if (index >= 0 && index < elements.size()) {
            return elements.get(index);
        }
        return null;
    }

    // Méthode pour obtenir la taille de la liste
    public int getSize() {
        return elements.size();
    }
}