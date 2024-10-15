import java.io.*;
import java.net.*;

public class Node2 {
    public static void main(String[] args) throws IOException {
        // Ascultă pentru a primi mesajul de la Nodul 1
        ServerSocket serverSocket = new ServerSocket(5001);
        Socket socketFromNode1 = serverSocket.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(socketFromNode1.getInputStream()));
        String message = in.readLine();
        System.out.println("Mesaj primit de la Nodul 1: " + message);

        // Trimite mesajul Nodului 3
        Socket socketToNode3 = new Socket("localhost", 5002);
        PrintWriter out = new PrintWriter(socketToNode3.getOutputStream(), true);
        out.println(message);
        System.out.println("Mesaj trimis la Nodul 3: " + message);

        // Închide socketurile
        socketFromNode1.close();
        socketToNode3.close();
        serverSocket.close();
    }
}
