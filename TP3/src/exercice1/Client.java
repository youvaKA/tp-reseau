import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {

        try {

            // Connection au serveur
            Socket s = new Socket("192.168.88.88", 2022);

            // donnés qui entre
            InputStream iS = s.getInputStream();
            OutputStream oS = s.getOutputStream();

            // lecture des donnés
            int v = iS.read();
            BufferedReader bf = new BufferedReader(new InputStreamReader(iS));
            String str = bf.readLine();

            // Ecriture des données
            String msg = "Bonjour";
            oS.write(msg.getBytes());

            // Affiche les donnés
            System.out.println(str);

            // ferme la connexion
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}