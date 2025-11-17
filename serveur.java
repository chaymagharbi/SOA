package tp2_thread;

import java.io.*;
//input et output
import java.net.*;
//pour connexion
import java.util.Scanner;
//saisie au clavier

public class serveur {

	public static void main(String[] args) {
		int port=2150;
		int nb=5;
		try{
		ServerSocket ss =new ServerSocket(port,nb);
		System.out.println("le serveur en ecoute");
		while (true) {
		Socket socket = ss.accept();
		ConnexionThread c = new ConnexionThread(socket);
		 c.start();
		}
		} catch (IOException e) 
		{e.printStackTrace();}
		

	}

}
