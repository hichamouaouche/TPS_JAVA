import java.io.File;
import java.util.Scanner;

public class LsSimulator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Get the directory path from the user
        System.out.print("Enter the full path to the directory: ");
        String path = scanner.nextLine();

        File directory = new File(path);

        // 2. Validate that the path exists and is actually a directory
        if (!directory.exists()) {
            System.out.println("Error: The specified path does not exist.");
        } else if (!directory.isDirectory()) {
            System.out.println("Error: The specified path is not a directory.");
        } else {
            // 3. List files and process them
            File[] filesList = directory.listFiles();

            if (filesList != null) {
                System.out.println("\nListing contents of: " + path);
                System.out.println("--------------------------------------------------");

                for (File file : filesList) {
                    printFileInfo(file);
                }
            } else {
                System.out.println("Error: Could not list contents (Access Denied or I/O Error).");
            }
        }

        scanner.close();
    }

    private static void printFileInfo(File file) {
        // Construct the type string
        String type = file.isDirectory() ? "<DIR>" : "<FILE>";

        // Construct the permissions string
        StringBuilder perms = new StringBuilder();
        
        perms.append(file.canRead() ? "r" : "-");
        perms.append(file.canWrite() ? "w" : "-");
        // The prompt asks for 'h' if it is a cache (hidden) file
        perms.append(file.isHidden() ? "h" : "-");

        // Print formatted output: Full Path | Type | Permissions
        System.out.printf("%-50s %-8s %s%n", file.getAbsolutePath(), type, perms.toString());
    }
}