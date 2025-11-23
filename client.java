package tp2_thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

public class client {
	public static void main(String[] args) {String host = "localhost";
    int port = 2150;

    try (Socket s = new Socket(host, port);
         PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
         BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
         Scanner sc = new Scanner(System.in)) {

        System.out.println("Client connecté au serveur.");

        while (true) {
            System.out.print("Entrez nombre 1 : ");
            String msg1 = sc.nextLine();
            pw.println(msg1);
            
            if(msg1.equals("0")) {
            	s.close();
            	break;
            }
            System.out.print("Entrez nombre 2 : ");
            String msg2 = sc.nextLine();
            System.out.print("Entrez operateur : ");
            String msg3 = sc.nextLine();

            pw.println(msg2);
            pw.println(msg3);
            pw.flush();
            String response = br.readLine();
            System.out.println("Réponse du serveur : " + response);
        }


    } catch (IOException e) {
        e.printStackTrace();
    }


	}

}
