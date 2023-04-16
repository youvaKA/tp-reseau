package exercice3V2;

/* author : KAOUI Youva L3 Informatique - MIAGE */


import java.util.Scanner;


public class ChatApp {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir votre message:");
        
        String str = sc.nextLine();

        ClientServerChat listener = new ClientServerChat(Role.LISTENER);
        ClientServerChat sender = new ClientServerChat(Role.SENDER);



        listener.start();
        listener.action.invoke(null);
        sender.start();
        sender.action.invoke(str);

    }

}
