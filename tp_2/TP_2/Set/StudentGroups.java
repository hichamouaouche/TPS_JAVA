import java.util.HashSet;
import java.util.Set;

public class StudentGroups {
    public static void main(String[] args) {

        // --- 1. Créer les HashSet et ajouter des noms ---
        // Création du groupe A
        Set<String> groupA = new HashSet<>();
        groupA.add("Ahmed");
        groupA.add("Sarah");
        groupA.add("Karim"); // Karim est dans les deux groupes
        groupA.add("Lea");

        // Création du groupe B
        Set<String> groupB = new HashSet<>();
        groupB.add("John");
        groupB.add("Karim"); // Karim est dans les deux groupes
        groupB.add("Sarah"); // Sarah est dans les deux groupes
        groupB.add("Paul");

        System.out.println("Groupe A : " + groupA);
        System.out.println("Groupe B : " + groupB);
        System.out.println("-----------------------------");

        // --- 2. Afficher l'intersection (éléments communs) ---
        // Nous créons une copie de groupA pour ne pas modifier l'original
        Set<String> intersection = new HashSet<>(groupA);
        
        // La méthode retainAll ne garde que les éléments présents dans groupB
        intersection.retainAll(groupB);

        System.out.println("Intersection (Étudiants présents dans les DEUX groupes) : " + intersection);

        // --- 3. Afficher l'union (tous les éléments sans doublons) ---
        // Nous créons une nouvelle copie de groupA
        Set<String> union = new HashSet<>(groupA);
        
        // La méthode addAll ajoute tous les éléments de groupB
        // (Les doublons comme Karim et Sarah sont automatiquement ignorés par le HashSet)
        union.addAll(groupB);

        System.out.println("Union (Tous les étudiants des groupes A et B) : " + union);
    }
}