
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;

public class serverV2 extends Thread {

  private Socket socket;
  private ArrayList<ClientThread> clients;
  private String username;

  public ClientThread(Socket socket, ArrayList<ClientThread> clients) {
    this.socket = socket;
    this.clients = clients;
  }

  @Override
  public void run() {
    try {
      InputStream is = socket.getInputStream();
      InputStreamReader isr = new InputStreamReader(is);
      BufferedReader br = new BufferedReader(isr);

      OutputStream os = socket.getOutputStream();
      PrintStream ps = new PrintStream(os);

      username = br.readLine();
      broadcast(username + " vient de se connecter.");

      String message = "";

      while (message != null && !message.equalsIgnoreCase("quit")) {
        message = br.readLine();
        broadcast(username + " : " + message);
      }

      broadcast(username + " s'est déconnecté.");
      clients.remove(this);
      socket.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  private void broadcast(String message) {
    for (ClientThread client : clients) {
      client.sendMessage(message);
    }
  }

  private void sendMessage(String message) {
    try {
      PrintStream ps = new PrintStream(socket.getOutputStream());
      ps.println(message);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

}