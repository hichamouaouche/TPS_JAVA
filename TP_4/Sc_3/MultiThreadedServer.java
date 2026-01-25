import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class MultiThreadedServer {
    // Thread-safe list to store scores (Leaderboard)
    private static final List<String> leaderboard = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        int port = 1234;
        System.out.println("Multi-threaded Server Started...");

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                // Accept connection and immediately hand it off to a new thread
                Socket socket = serverSocket.accept();
                System.out.println("New player connected: " + socket.getInetAddress());
                new PlayerHandler(socket).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Inner class to handle individual players
    static class PlayerHandler extends Thread {
        private Socket socket;

        public PlayerHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

                // Ask for name for leaderboard
                output.println("WELCOME! Enter your name:");
                String playerName = input.readLine();
                
                int magicNumber = (int) (Math.random() * 101);
                int attempts = 0;
                String text;

                while (true) {
                    text = input.readLine();
                    if (text == null) break;

                    int guess;
                    try {
                        guess = Integer.parseInt(text);
                    } catch (NumberFormatException e) {
                        output.println("INVALID_INPUT");
                        continue;
                    }

                    attempts++;

                    if (guess < magicNumber) {
                        output.println("TOO_LOW");
                    } else if (guess > magicNumber) {
                        output.println("TOO_HIGH");
                    } else {
                        output.println("CORRECT");
                        
                        // Add to leaderboard
                        String scoreEntry = attempts + " attempts - " + playerName;
                        leaderboard.add(scoreEntry);
                        
                        // Sort leaderboard (Lowest attempts first)
                        leaderboard.sort((a, b) -> {
                            int scoreA = Integer.parseInt(a.split(" ")[0]);
                            int scoreB = Integer.parseInt(b.split(" ")[0]);
                            return scoreA - scoreB;
                        });

                        // Send Leaderboard to client
                        output.println("--- LEADERBOARD ---");
                        for (int i = 0; i < Math.min(leaderboard.size(), 5); i++) {
                            output.println((i + 1) + ". " + leaderboard.get(i));
                        }
                        output.println("END_LB"); // Signal end of leaderboard
                        break;
                    }
                }
                socket.close();
            } catch (IOException ex) {
                System.out.println("Player disconnected.");
            }
        }
    }
}