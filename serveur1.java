package tp2_thread;
import java.io.*;
//input et output
import java.net.*;
//pour connexion
import java.util.Scanner;
//saisie au clavier
public class serveur1 {

	public static void main(String[] args) {
			try{
			ServerSocket ss1 =new ServerSocket(2001);
			servicethread1 th1=new servicethread1(ss1);
			th1.start();
			ServerSocket ss2 =new ServerSocket(2002);
			servicethread2 th2=new servicethread2(ss2);
			th2.start();
			} catch (IOException e) 
			{e.printStackTrace();}

	}

}
