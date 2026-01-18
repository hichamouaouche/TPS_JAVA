import java.util.Arrays;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Entrez le nombre d'etudiants : ");
        int n = sc.nextInt();

        double[] grades = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Note de l'etudiant " + (i + 1) + " : ");
            grades[i] = sc.nextDouble();
        }

        // 1. Trier et afficher
        Arrays.sort(grades);
        System.out.println("Notes triees : " + Arrays.toString(grades));

        // 2. Moyenne
        double somme = 0;
        for (double note : grades) {
            somme += note;
        }
        System.out.println("Moyenne : " + (somme / n));

        // 3. Max et Min
        System.out.println("Note minimale : " + grades[0]);
        System.out.println("Note maximale : " + grades[n - 1]);

        // 4. Nombre d'etudiants avec une note donnee
        System.out.print("Entrez une note a rechercher : ");
        double x = sc.nextDouble();
        int compteur = 0;

        for (double note : grades) {
            if (note == x) {
                compteur++;
            }
        }

        System.out.println("Nombre d'etudiants ayant la note " + x + " : " + compteur);
    }
}
