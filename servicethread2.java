package tp2_thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class servicethread2 extends Thread {
	public ServerSocket s2;
	Socket s;
	BufferedReader in;
	PrintWriter out;

	public servicethread2(ServerSocket s2) {this.s2=s2;
	try{
		BufferedReader in=new BufferedReader( new InputStreamReader(s.getInputStream()));
		} catch (IOException e) {e.printStackTrace();}}

	public void run() {try{
		while(true) {
			s=s2.accept();
			ObjectInputStream out =new ObjectInputStream(s.getInputStream());
			etudiant e=(etudiant)out.readObject();
			float moyenne=(e.getNote1()+e.getNote2())/2;
			PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
			pw.println(moyenne);
			s.close();
		}
		
	} catch (IOException e) {e.printStackTrace();}
	catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	}}
