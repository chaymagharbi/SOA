package tp2_thread;
import java.io.*;
//input et output
import java.net.*;
//pour connexion
import java.util.Scanner;
//saisie au clavier
public class ConnexionThread  extends Thread{

	Socket s;
	BufferedReader in;
	PrintWriter out;
	public ConnexionThread (Socket s) { this.s = s;
	try{
	in=new BufferedReader( new InputStreamReader(s.getInputStream()));
	out = new PrintWriter(s.getOutputStream());
	} catch (IOException e) {e.printStackTrace();}}
	public void run() { try{
		while (true) {
		
		String msg1 = in.readLine();
		if(msg1.equals("0")) {s.close();
		break;
		}
		
        String msg2 = in.readLine();
        String msg3 = in.readLine();

        
        if (msg1 != null && msg2 != null && msg3!=null) {
            
            int n1 = Integer.parseInt(msg1.trim());
            int n2 = Integer.parseInt(msg2.trim());
            String op=msg3.trim();
            double r=0;
            if(op.equals("+")) {
            	r = n1 + n2;
                out.println("La somme = " + r);
                System.out.println("Somme envoyée au client : " + r);
        		out.flush();

                break;
            }
            else if(op.equals("-")) {
            	r = n1 - n2;
                out.println("La soustraction = " + r);
                System.out.println("soustraction envoyée au client : " + r);
        		out.flush();

                break;
            }
            else if(op.equals("*")) {
            	r = n1 * n2;
                out.println("La multuplication = " + r);
                System.out.println("multuplication envoyée au client : " + r);
        		out.flush();

                break;
            }
            else if(op.equals("/")) {
            	if(n2 !=0) {
	            	r = n1 / n2;
	                out.println("La division = " + r);
	                System.out.println("division envoyée au client : " + r);
	        		out.flush();

            }
            	else{
            		out.println("division par 0 est impossible");
            	}
            	break;
            }
            else {
            	out.println("operature invalide");
            }
            }
         
        else 
        	System.out.println("Erreur : veuillez entrer deux nombres valides !");
		
        }
		
		} catch (IOException e) {e.printStackTrace();}

}
}