package pk1;

import java.io.*;
import java.net.*;

public class serveur2 {

    public static void main(String[] args) {
        int port = 8555;
        int nc = 5;
        try {
            ServerSocket ss = new ServerSocket(port, nc);
            System.out.println("Serveur en écoute sur le port " + port);

            while (true) {
                Socket s1 = ss.accept();
                System.out.println("Client connecté !");
                while(true) {
                BufferedReader br = new BufferedReader(new InputStreamReader(s1.getInputStream()));
                PrintWriter pw = new PrintWriter(s1.getOutputStream(), true);

                String msg1 = br.readLine();
                String msg2 = br.readLine();

                if (msg1 != null && msg2 != null) {
                    
                        int n1 = Integer.parseInt(msg1.trim());
                        int n2 = Integer.parseInt(msg2.trim());
                        int somme = n1 + n2;

                        pw.println("La somme = " + somme);
                        System.out.println("Somme envoyée au client : " + somme);
                     
                    
                    }
                else 
                	System.out.println("Erreur : veuillez entrer deux nombres valides !");
                }}

            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

