  //package exercice2;

/* author : KAOUI Youva L3 Informatique - MIAGE */

import java.net.DatagramPacket;
import java.net.MulticastSocket;
import java.net.InetAddress;

public class MultiReceiveUDP {

    public static void main(String args[]) {

        try {
            //String port = args[0];
      
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
              System.out.println(packet.getAddress().getHostName() + ": "+ msg);
      
              // Reset the length of the packet before reusing it.
              packet.setLength(buffer.length);
            }
          } catch (Exception e) {
            System.err.println(e);
          }
        }

}
