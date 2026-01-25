import java.io.*;
import java.net.*;
import java.util.Scanner;

public class GameClient {
    public static void main(String[] args) {
        String hostname = "localhost"; // Use IP address for Level 2
        int port = 1234;

        try (Socket socket = new Socket(hostname, port)) {
            System.out.println("Connected to the Magic Number Server!");

            // Setup streams
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner console = new Scanner(System.in);

            String response;
            int attempts = 0;

            do {
                // 2. Prompt user
                System.out.print("Enter your guess (0-100): ");
                String guess = console.nextLine();
                attempts++;

                // 3. Send guess
                output.println(guess);

                // 4. Display response
                response = input.readLine();
                System.out.println("Server says: " + response);

            } while (!response.equals("CORRECT")); // Loop until won

            // 5. Show total attempts
            System.out.println("Congratulations! You found the number in " + attempts + " attempts.");

        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O Error: " + ex.getMessage());
        }
    }
}