public class Application {
    public static void main(String[] args) {
        // Test avec le type Integer
        System.out.println("--- Test Integer ---");
        GenericStorage<Integer> intStorage = new GenericStorage<>();
        intStorage.addElement(10);
        intStorage.addElement(20);
        intStorage.addElement(30);
        
        System.out.println("Taille: " + intStorage.getSize()); // 3
        System.out.println("Element index 1: " + intStorage.getElement(1)); // 20
        intStorage.removeElement(0); // Supprime 10
        System.out.println("Taille après suppression: " + intStorage.getSize()); // 2

        // Test avec le type String
        System.out.println("\n--- Test String ---");
        GenericStorage<String> strStorage = new GenericStorage<>();
        strStorage.addElement("Java");
        strStorage.addElement("PHP");
        strStorage.addElement("Python");

        System.out.println("Element index 2: " + strStorage.getElement(2)); // Python
    }
}