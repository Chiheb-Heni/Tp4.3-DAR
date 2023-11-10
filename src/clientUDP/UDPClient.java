package clientUDP;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class UDPClient {

    public static void main(String[] args) {
        try {
            // Création d'une socket UDP
            DatagramSocket clientSocket = new DatagramSocket();

            // Adresse du serveur et port
            InetSocketAddress serverAddress = new InetSocketAddress("localhost", 1234);

            // Boucle pour permettre à l'utilisateur d'envoyer des messages
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Entrez votre message : ");
                String message = scanner.nextLine();

                // Envoi du message au serveur
                byte[] sendData = message.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress);
                clientSocket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
