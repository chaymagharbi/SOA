package pk1;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class client2 {

    public static void main(String[] args) {
        String host = "localhost";
        int port = 8555;

        try (Socket s = new Socket(host, port);
             PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
             BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
             Scanner sc = new Scanner(System.in)) {

            System.out.println("Client connecté au serveur.");

            while (true) {
                System.out.print("Entrez nombre 1 : ");
                String msg1 = sc.nextLine();

                System.out.print("Entrez nombre 2 : ");
                String msg2 = sc.nextLine();

                pw.println(msg1);
                pw.println(msg2);

                String response = br.readLine();
                System.out.println("Réponse du serveur : " + response);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
