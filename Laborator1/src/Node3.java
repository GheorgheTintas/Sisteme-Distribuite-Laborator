import java.io.*;
import java.net.*;

public class Node3 {
    public static void main(String[] args) throws IOException {
        // Ascultă pentru a primi mesajul de la Nodul 2
        ServerSocket serverSocket = new ServerSocket(5002);
        Socket socketFromNode2 = serverSocket.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(socketFromNode2.getInputStream()));
        String message = in.readLine();
        System.out.println("Mesaj primit de la Nodul 2: " + message);

        // Trimite mesajul Nodului 1
        Socket socketToNode1 = new Socket("localhost", 5000);
        PrintWriter out = new PrintWriter(socketToNode1.getOutputStream(), true);
        out.println(message);
        System.out.println("Mesaj trimis la Nodul 1: " + message);

        // Închide socketurile
        socketFromNode2.close();
        socketToNode1.close();
        serverSocket.close();
    }
}
