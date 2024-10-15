
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Node1 {
    public static void main(String[] args) throws IOException {
        // Scanner pentru citire de la tastatură
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceți mesajul de trimis: ");
        String message = scanner.nextLine();

        // Trimite mesajul Nodului 2
        Socket socketToNode2 = new Socket("localhost", 5001);
        PrintWriter out = new PrintWriter(socketToNode2.getOutputStream(), true);
        out.println(message);
        System.out.println("Mesaj trimis la Nodul 2: " + message);

        // Ascultă pentru a primi mesajul de la Nodul 3
        ServerSocket serverSocket = new ServerSocket(5000);
        Socket socketFromNode3 = serverSocket.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(socketFromNode3.getInputStream()));
        String receivedMessage = in.readLine();
        System.out.println("Mesaj primit de la Nodul 3: " + receivedMessage);

        // Închide socketurile
        socketToNode2.close();
        socketFromNode3.close();
        serverSocket.close();
    }
}
