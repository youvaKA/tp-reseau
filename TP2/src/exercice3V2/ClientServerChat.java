package exercice3V2;

/* author : KAOUI Youva L3 Informatique - MIAGE */

import java.lang.reflect.Method;
import java.net.DatagramPacket;
import java.net.MulticastSocket;
import java.net.InetAddress;

public class ClientServerChat extends Thread {
    Method action;

    public ClientServerChat(Role role) {
        super();
        this.action = role.todo;
    }

    public void send(String message) throws Exception {
        
        // Adresse IP du destinataire
        InetAddress IP = InetAddress.getByName("224.0.0.1");

        // Port du destinataire
        int port = 7654;

        // Créer un socket multicast
        MulticastSocket ms = new MulticastSocket(port);
        ms.joinGroup(IP);
        // Créer un message et l'envoyer sous forme de paquet
        byte buff[] = message.getBytes();
        DatagramPacket dp = new DatagramPacket(buff, buff.length, IP, port);
        ms.send(dp);
        // fermer le socket
        ms.close();
    }

    public void receive() throws Exception {

        // Create a Multicast socket to listen on the port.
        MulticastSocket msocket = new MulticastSocket(7654);
        msocket.joinGroup(InetAddress.getByName("224.0.0.1"));
        // Create a buffer to read datagrams into. If a
        // packet is larger than this buffer, the
        // excess will simply be discarded!
        byte[] buffer = new byte[2048];

        // Create a packet to receive data into the buffer
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        // Now loop forever, waiting to receive packets and printing them.
        while (true) {
            // Wait to receive a datagram
            msocket.receive(packet);

            // Convert the contents to a string, and display them
            String msg = new String(buffer, 0, packet.getLength());
            System.out.println(packet.getAddress().getHostName() + ": " + msg);

            // Reset the length of the packet before reusing it.
            packet.setLength(buffer.length);
        }

    }


}