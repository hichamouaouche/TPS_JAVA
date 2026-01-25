import java.io.*;
import java.net.*;

public class SimpleServer {
    public static void main(String[] args) {
        int port = 1234;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            // 2. Accept client connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // 1. Generate random number (0-100)
            // Math.random returns 0.0 to <1.0. Multiply by 101 to get 0-100 inclusive.
            int magicNumber = (int) (Math.random() * 101);
            int attempts = 0;
            
            // Input/Output streams
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            String text;
            boolean won = false;

            while (!won) {
                // Read guess from client
                text = input.readLine();
                if (text == null) break;

                int guess;
                try {
                    guess = Integer.parseInt(text);
                } catch (NumberFormatException e) {
                    output.println("INVALID_INPUT");
                    continue;
                }

                // 4. Count attempts
                attempts++;

                // 3. Respond with hints
                if (guess < magicNumber) {
                    output.println("TOO_LOW");
                } else if (guess > magicNumber) {
                    output.println("TOO_HIGH");
                } else {
                    // 5. Number found
                    output.println("CORRECT");
                    System.out.println("Client won in " + attempts + " attempts.");
                    won = true;
                }
            }

            // Close connection automatically via try-with-resources
            socket.close();
            
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}