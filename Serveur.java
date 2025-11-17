package pk1;
import java.io.*;
//input et output
import java.net.*;
//pour connexion
import java.util.Scanner;
//saisie au clavier

public class Serveur {
    public static void main(String[] args) {
		int port=1234;
	    int nb=5;
		try{
	    ServerSocket ss =new ServerSocket(port,nb);
	    System.out.println("le serveur en ecoute");
	    //flux entrant
	    while(true) {
	    	//accepter clients sequentiellemnt 
	    	Socket socket=ss.accept();
	    	//lecture flux string
	        InputStream in=socket.getInputStream();
	        InputStreamReader reader = new InputStreamReader(in);
	        BufferedReader istream = new BufferedReader(reader);
	        while (true) {
	        	String msg = istream.readLine();
	        	System.out.println("le client a dit "+msg);
	        	if(msg.equals("fin")) {
	        		socket.close();
	        		System.out.println("fin connexion");
	        		break;
	        	}
	        	//bloc envoi
	           Scanner sc=new Scanner(System.in);
	           System.out.println("Tapez votre message");
	 	       String str=sc.nextLine();
	 	       OutputStream out=socket.getOutputStream();
	 	       PrintWriter ostream = new PrintWriter(out);
	 	       ostream.println(str);
	 	       ostream.flush();
	       }
	     
	    }

	}catch(IOException e)
	{}
	
}
}
