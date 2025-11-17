package tp2_thread;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class servicethread1 extends Thread{
	public ServerSocket s1;
	Socket s;
	BufferedReader in;
	PrintWriter out;
	public servicethread1 (ServerSocket s1) { this.s1 = s1;
	try{
	BufferedReader in=new BufferedReader( new InputStreamReader(s.getInputStream()));
	PrintWriter out = new PrintWriter(s.getOutputStream());
	} catch (IOException e) {e.printStackTrace();}}
	public void run() { try{
		while(true) {
			s=s1.accept();
			ObjectOutputStream out =new ObjectOutputStream(s.getOutputStream());
			String nom=in.readLine();
			String prenom=in.readLine();
			int note1=Integer.parseInt(in.readLine());
			int note2=Integer.parseInt(in.readLine());
			etudiant e=new etudiant(nom,prenom,note1,note2);
			out.writeObject(e);
			out.flush();
			System.out.println("etudiant cree");
		}
		
	} catch (IOException e) {e.printStackTrace();}
	
	}}
