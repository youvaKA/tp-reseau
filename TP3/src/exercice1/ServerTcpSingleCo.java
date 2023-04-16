//package TP3.src.exercice2;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.*;


public class ServerTcpSingleCo {

    public static void main(String[] args) {
            
            try {
                //Création d'une socket Server avec le port
                ServerSocket myServ = new ServerSocket(2022);

                //Création d'une socket pour accepter les connexions
                Socket socket = myServ.accept();

                // creation d'un flux binaire sortant 
                OutputStream out = socket.getOutputStream();

                PrintStream str = new PrintStream(out);
                str.println("Bienvenue sur mon serveur et au revoir");

                myServ.close();
                
    
            } catch (Exception e) {
                System.out.println(e);
            }
        }

}
