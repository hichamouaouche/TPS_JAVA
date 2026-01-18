import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ch = "";
        int choix;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Saisir une chaine");
            System.out.println("2. Afficher la chaine");
            System.out.println("3. Inverser la chaine");
            System.out.println("4. Nombre de mots");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {
                case 1:
                    System.out.print("Entrez une chaine : ");
                    ch = sc.nextLine();
                    break;

                case 2:
                    System.out.println("Chaine : " + ch);
                    break;

                case 3:
                    String inverse = new StringBuilder(ch).reverse().toString();
                    System.out.println("Chaine inversee : " + inverse);
                    break;

                case 4:
                    String[] mots = ch.trim().split("\\s+");
                    System.out.println("Nombre de mots : " + mots.length);
                    break;
            }

            if (choix != 0) {
                System.out.println("Appuyez sur Entrée pour revenir au menu...");
                sc.nextLine();
            }

        } while (choix != 0);
    }
}
