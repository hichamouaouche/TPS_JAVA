import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nb_occurrences = new int[26];

        System.out.print("Entrez une ligne de texte : ");
        String ch = sc.nextLine().toUpperCase();

        for (int i = 0; i < ch.length(); i++) {
            char c = ch.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                nb_occurrences[c - 'A']++;
            }
        }

        System.out.println("Occurrences des lettres :");
        for (int i = 0; i < 26; i++) {
            if (nb_occurrences[i] > 0) {
                System.out.println(nb_occurrences[i] + " occurrence(s) de la lettre '"
                        + (char)(i + 'A') + "'");
            }
        }
    }
}
