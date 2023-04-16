//package TP3.src.exercice2;

import java.io.File;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class ServerTcpMultiCo {

    public static void main(String[] args) {

        try {
            int port = 2022;
            // Création d'une socket Server avec le port
            ServerSocket myServ = new ServerSocket(port);

            // affiche que le serveur est bien démarré 
            System.out.println("Le serveur est actuellement en écoute sur le port: " + port);

            //créer un fichier pour concerver une trace de la connexion d'un client sur le serveur
            File file = new File("log.txt");


            //liste qui contiendra la connexions des clients 
            List<String> clients = new ArrayList<String>();

            while (true) {

                // Permet d'afficher la date actuelle 
                LocalDateTime myDate = LocalDateTime.now();
                DateTimeFormatter myFormatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
                String date = myDate.format(myFormatDate);

                // Création d'une socket pour accepter les connexions
                Socket socket = myServ.accept();
                
                // creation d'un flux binaire sortant
                OutputStream out = socket.getOutputStream();
                PrintStream str = new PrintStream(out);

                str.println(" Bienvenue sur le serveur de Youva Kaoui");

                System.out.println(
                                    date + 
                                    " le client : " + 
                                    socket.getRemoteSocketAddress() + 
                                    " vient de se connecter sur le serveur"
                                    );

                
                //
                if (socket.getRemoteSocketAddress() != null) {
                    
                    clients.add(date + " Connection du client "+ socket.getRemoteSocketAddress() + "\n");
                    PrintWriter writer = new PrintWriter(file);
                    writer.println(clients);

                    writer.close();
                }

            }

            // myServ.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
