import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerV1 {
    private ServerSocket serverSocket;
    private List<Socket> connections;
 
    /**
     * Constructs a new Server and starts listening on the specified port.
     *
     * @param port The port number to listen on
     * @throws IOException If an I/O error occurs when opening the socket
     */
    
    public ServerV1(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
        this.connections = new ArrayList<>();
    }
 
    /**
     * Starts the server.
     * This method creates a new thread that runs an infinite loop to accept incoming connections.
     */
    public void start() {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    connections.add(socket);
 
                    // Create a new thread to handle the connection
                    new Thread(() -> {
                        try {
                            while (true) {
                                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                                String message = reader.readLine();
 
                                // Broadcast message to all connected clients
                                broadcastMessage(message);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }).start();
 
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        
        thread.start();
    }
 
    /**
     * Sends a message to all connected clients.
     *
     * @param message The message to send
     * @throws IOException If an I/O error occurs
     */
    private void broadcastMessage(String message) throws IOException {
        for (Socket socket : connections) {
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println(message);
        }
    }
}