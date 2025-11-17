package pk1;
import java.io.*;
//input et output
import java.net.*;
//pour connexion
import java.util.Scanner;
//saisie au clavier
public class serveurv {

	public static void main(String[] args) {
		int port=3333;
		int nb=5;
		try {
			ServerSocket ss=new ServerSocket(port,nb);
            System.out.println("Serveur en écoute sur le port " + port);
            while(true) {
            	Socket s=ss.accept();
                System.out.println("Client connecté !");
                ObjectInputStream in= new ObjectInputStream (s.getInputStream());
                voiture v=(voiture) in.readObject();
                v.setPrixvente((float) (v.getPrixachat()- (v.getKm()*0.15)));
                ObjectOutputStream os=new ObjectOutputStream(s.getOutputStream());
                os.writeObject(v);
                os.flush();
                s.close();
            	
            }
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
