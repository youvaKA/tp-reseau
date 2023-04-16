package exercice3;

/* author : KAOUI Youva L3 Informatique - MIAGE */

import java.net.DatagramPacket;
import java.net.MulticastSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Sender extends Thread {

  // String message = "Ici sender";

  /*
   * public Sender(String message) {
   * super();
   * this.message = message;
   * }
   */

  // System.out.println("ICI2");

  public void run() {

    try {
      // String contenant le message
      String str = "";
      
      // Scanner permetant de récuperer l'entrée utilisateur
      Scanner sc = new Scanner(System.in);
      System.out.println("Veuillez saisir votre message:");

      // Adresse IP du destinataire
      InetAddress IP = InetAddress.getByName("224.0.0.1");

      // Port du destinataire
      int port = 7654;

      // Créer un socket multicast
      MulticastSocket ms = new MulticastSocket(port);
      ms.joinGroup(IP);

      // Créer un message et l'envoyer sous forme de paquet

      while (!str.equals("exit")) {

        str = sc.nextLine();
        byte buff[] = str.getBytes();
        DatagramPacket dp = new DatagramPacket(buff, buff.length, IP, port);
        ms.send(dp);

      }
      // si le message conrespond a 'exit' alors on ferme la comunication 
      ms.disconnect();
    } catch (Exception e) {
      System.out.println(e);
    }

  }
}
