package tp2_thread;
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class client1 {
	public static void main(String[] args) {String host = "localhost";
    int port = 2001;

    try (Socket s = new Socket(host, port);
         PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
         BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
         Scanner sc = new Scanner(System.in)) {

        System.out.println("Client connecté au serveur sur port:"+port);

        while (true) {
            String nom =sc.nextLine();
            String prenom=sc.nextLine();
            String n1=sc.nextLine();
            String n2=sc.nextLine();
            OutputStream os=s.getOutputStream();
            PrintWriter pw1=new PrintWriter(os);
            pw1.println(nom);
            pw1.println(prenom);
            pw1.println(n1);
            pw1.println(n2);
            pw1.flush();
            ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
            etudiant e =(etudiant) ois.readObject();
            System.out.println(e);
            s.close();
        }


    } catch (IOException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}


	}


}
