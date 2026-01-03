import java.util.Scanner;

public class Exercice2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Entrez un verbe du premier groupe : ");
        String verbe = sc.nextLine();

        if (!verbe.endsWith("er")) {
            System.out.println("Ce n'est pas un verbe du premier groupe !");
            return;
        }

        String radical = verbe.substring(0, verbe.length() - 2);

        System.out.println("je " + radical + "e");
        System.out.println("tu " + radical + "es");
        System.out.println("il/elle " + radical + "e");
        System.out.println("nous " + radical + "ons");
        System.out.println("vous " + radical + "ez");
        System.out.println("ils/elles " + radical + "ent");
    }
}
