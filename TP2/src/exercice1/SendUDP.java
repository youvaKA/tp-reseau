//package exercice1;

/* author : KAOUI Youva L3 Informatique - MIAGE */

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendUDP {

    public static void main(String[] args) throws Exception {

        if (args.length < 3 || args.length > 4) {
            System.out.println("Mauvaise utilisation. Verifiez le nombre d'arguments");
            System.out.println("$ java SendUDP <IP> <PORT> <MESSAGE>");
        } else {

            // Adresse IP du destinataire
            InetAddress IP = InetAddress.getByName(args[0]);

            // Port du destinataire
            int port = Integer.parseInt(args[1]);

            
            // Message à envoyer 
            byte msg[] = args[2].getBytes();
            
            // Créer un socket "datagramme"
            DatagramSocket ds = new DatagramSocket();

            //Création du packet contenant le message le port et le destinataire
            DatagramPacket dp = new DatagramPacket(msg, msg.length, IP, port);

            ds.send(dp);

            System.out.println(" !! votre Message a été envoyer avec succès !!");
        }
    }
}