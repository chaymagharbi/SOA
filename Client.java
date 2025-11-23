package pk1;
import java.io.*;
//input et output
import java.net.*;
//pour connexion
import java.util.Scanner;
//saisie au clavier

public class Client {

	public static void main(String[] args) {
		String host="localhost";
	    int port=1234;
		try{
	    Socket s =new Socket(host,port);
	    System.out.println("Client connecté");
	    while(true) {
        Scanner sc=new Scanner(System.in);
	    OutputStream out=s.getOutputStream();
	    PrintWriter pw = new PrintWriter(out);
	    System.out.println("entrez message:");
	    String msg=sc.nextLine();
	    pw.println(msg);
	    pw.flush();
	    
	    
        InputStream in1=s.getInputStream();
        InputStreamReader r = new InputStreamReader(in1);
        BufferedReader bf = new BufferedReader(r);
        if(msg.equals("fin")) {
		    System.out.println("connexion terminée");
            s.close();
	    }
	    String rep=bf.readLine();
	    System.out.println("reponse serveur "+rep);
	    
	   
	    }}catch(IOException e)
		{}
		
	}

}
