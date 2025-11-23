package pk1;
import java.io.*;
//input et output
import java.net.*;
//pour connexion
import java.util.Scanner;
//saisie au clavier
public class clientv {

	public static void main(String[] args) {
    int port=3333;
    String host="localhost";
    try {
    Socket s=new Socket(host,port);
    System.out.println("Client connecté");
    while(true) {
    	Scanner sc=new Scanner(System.in);
    	try {
    	ObjectOutputStream out=new ObjectOutputStream(s.getOutputStream());
	    System.out.println("entrez marque:");
	    String marq=sc.nextLine();
	    System.out.println("entrez prix achat:");
	    float prixachat=sc.nextFloat();
	    System.out.println("entrez kilométrage:");
        int km=sc.nextInt();
        voiture v=new voiture(marq,prixachat,km);
        out.writeObject(v);
        out.flush();
        
        ObjectInputStream in=new ObjectInputStream(s.getInputStream());
        voiture v1=(voiture) in.readObject();
	    System.out.println("le prix de vente= "+v1.getMPrixvente());
        s.close();

    }catch(Exception e) {
    	
    }
    }}catch(Exception e) {
    	e.printStackTrace();
    }
	}

}
