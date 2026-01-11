import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.DoubleSummaryStatistics;

public class GestionNotes {

    public static void main(String[] args) {
        // Création de la HashMap (Clé: String pour le nom, Valeur: Double pour la note)
        Map<String, Double> notesEtudiants = new HashMap<>();

        System.out.println("--- 1. Insertion des notes des étudiants ---");
        notesEtudiants.put("Ahmed", 14.5);
        notesEtudiants.put("Sarah", 17.0);
        notesEtudiants.put("Karim", 12.0);
        notesEtudiants.put("Lina", 19.5);
        afficherMap(notesEtudiants);

        System.out.println("\n--- 2. Augmenter la note d'un étudiant (Ahmed + 1.5) ---");
        // On vérifie si l'étudiant existe, puis on met à jour
        if (notesEtudiants.containsKey("Ahmed")) {
            notesEtudiants.put("Ahmed", notesEtudiants.get("Ahmed") + 1.5);
        }
        afficherMap(notesEtudiants);

        System.out.println("\n--- 3. Augmenter la note d'un autre étudiant (Karim + 2) ---");
        notesEtudiants.computeIfPresent("Karim", (k, v) -> v + 2.0);
        afficherMap(notesEtudiants);

        System.out.println("\n--- 4. Supprimer la note d'un étudiant (Sarah) ---");
        notesEtudiants.remove("Sarah");
        afficherMap(notesEtudiants);

        System.out.println("\n--- 5. Afficher la taille de la map ---");
        System.out.println("Taille de la map : " + notesEtudiants.size());
        afficherMap(notesEtudiants);

        System.out.println("\n--- 6. Afficher la moyenne, le max et le min ---");
        // Utilisation des Streams Java 8 pour calculer les statistiques facilement
        if (!notesEtudiants.isEmpty()) {
            DoubleSummaryStatistics stats = notesEtudiants.values().stream()
                .mapToDouble(Double::doubleValue)
                .summaryStatistics();
            
            System.out.println("Note Moyenne : " + stats.getAverage());
            System.out.println("Note Maximum : " + stats.getMax());
            System.out.println("Note Minimum : " + stats.getMin());
        }
        afficherMap(notesEtudiants);

        System.out.println("\n--- 7. Vérifier s'il y a une note égale à 20 ---");
        boolean existeVingt = notesEtudiants.containsValue(20.0);
        if (existeVingt) {
            System.out.println("Il y a un étudiant avec 20/20.");
        } else {
            System.out.println("Aucun étudiant n'a 20/20.");
        }
        afficherMap(notesEtudiants);
    }

    // --- 8. Méthode pour afficher la liste avec forEach et Lambda ---
    // Cette méthode est appelée après chaque opération ci-dessus
    public static void afficherMap(Map<String, Double> map) {
        System.out.println("État actuel de la liste :");
        map.forEach((nom, note) -> System.out.println("  - Étudiant : " + nom + " | Note : " + note));
    }
}