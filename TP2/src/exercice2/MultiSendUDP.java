//ackage exercice2;

/* author : KAOUI Youva L3 Informatique - MIAGE */

import java.net.DatagramPacket;
import java.net.MulticastSocket;
import java.net.InetAddress;

public class MultiSendUDP {

    public static void main(String[] args) throws Exception {

        if (args.length < 1 || args.length > 1) {
            System.out.println("Mauvaise utilisation.");
        } else {

            // Adresse IP du destinataire
            InetAddress IP = InetAddress.getByName("224.0.0.1");

            // Port du destinataire
            int port = 7654;

            // Créer un socket multicast
            MulticastSocket ms = new MulticastSocket(port);
            ms.joinGroup(IP);

            // Créer un message et l'envoyer sous forme de paquet
            byte buff[] = args[0].getBytes();
            DatagramPacket dp = new DatagramPacket(buff, buff.length, IP, port);
            ms.send(dp);
            System.out.println("Votre Message à bien été trasmit");

            //fermer le socket
            ms.close();
        }
    }
}