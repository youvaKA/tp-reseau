package exercice3;

/* author : KAOUI Youva L3 Informatique - MIAGE */

public class ChatAPP {

    public static void main(String[] args) {

        Sender snd = new Sender();
        Receiver rcv = new Receiver();

        rcv.start();
        snd.start();

    }

}
