import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceiver {
    public static void main(String[] args) {
        DatagramSocket socket = null;

        try {
            // 1. Create UDPReceiver listening on port 1234
            int port = 1234;
            socket = new DatagramSocket(port);
            System.out.println("Receiver is listening on port " + port + "...");
            System.out.println("Press Ctrl+C to stop the receiver manually.");

            byte[] buffer = new byte[1024]; // Buffer to hold incoming data

            // 3. Run continuously
            boolean isRunning = true;
            while (isRunning) {
                // Prepare packet holder
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

                // Receive packet (this blocks until data arrives)
                socket.receive(packet);

                // Extract data
                String receivedMsg = new String(packet.getData(), 0, packet.getLength());
                String senderAddress = packet.getAddress().getHostAddress();
                int senderPort = packet.getPort();

                // 2. Display received message with sender's address
                System.out.println("Received from [" + senderAddress + ":" + senderPort + "]: " + receivedMsg);

                // Optional: Stop if specific command is received (e.g. "exit")
                if (receivedMsg.equalsIgnoreCase("exit")) {
                    System.out.println("Exit command received. Shutting down.");
                    isRunning = false;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}