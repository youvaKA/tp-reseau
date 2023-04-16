
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class Client extends Thread {

    private Socket s;
    private BufferedReader input;

    public Client(Socket s) throws IOException {
        this.s = s;
        this.input = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }

    public void run() {
        try {
            while (true) {
                String rps = input.readLine();
                System.out.println(rps);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public static void main(String[] args) {
        
        try {
            
            //Connection au serveur
            Socket s = new Socket("192.168.88.88",2022);

            // donnés entrante du serveur 
            InputStream iS = s.getInputStream();

            //lecture des données 
            int v = iS.read();
            BufferedReader bf = new BufferedReader(new InputStreamReader(iS));
            String str = bf.readLine();

            // Affiche les données 
            System.out.println(str);

            OutputStream oS = s.getOutputStream();

            // envoie de données au serveur
            PrintWriter out = new PrintWriter(oS, true);

            Client yenCli = new Client(s);
            yenCli.start();

            Scanner sc = new Scanner(System.in);
            //System.out.println("Veuillez saisir votre message:");
            System.out.println("Veuillez saisir votre message:");

            while (true) {
                str = sc.nextLine();
                
                if (str.equals("exit")) {
                    s.close();
                    break;
                }else{
                    out.println(str);
                }
            }


            //ferme la session
            //s.close();
        } 
        catch (Exception e) {
           System.out.println(e);
        }
    }

}
