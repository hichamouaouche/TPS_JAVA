import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPSender {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        Scanner scanner = new Scanner(System.in);

        try {
            // 1. Create UDPSender
            socket = new DatagramSocket(); // Sends from any available port

            // Configuration
            System.out.print("Enter target IP address (e.g., 127.0.0.1): ");
            String ipInput = scanner.nextLine();
            InetAddress address = InetAddress.getByName(ipInput);
            int port = 1234; // Must match Receiver's port

            System.out.println("Chat started. Type 'bye' to quit.");

            // 2. Read user input and send as UDP packets
            while (true) {
                System.out.print("You: ");
                String message = scanner.nextLine();

                byte[] buffer = message.getBytes();
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, port);

                socket.send(packet);

                // 3. Send "bye" to terminate
                if (message.equalsIgnoreCase("bye")) {
                    System.out.println("Terminating chat...");
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
            scanner.close();
        }
    }
}