package tp2_thread;

import java.io.Serializable;

public class etudiant implements Serializable {
	private String nom;
	private String prenom;
	private int note1;
	private int note2;

	public etudiant(String nom,String prenom,int note1,int note2) {
		this.nom=nom;
		this.prenom=prenom;
		this.note1=note1;
		this.note2=note2;
	}
	
	public String getNom() {return this.nom;}
	public void setNom(String nom) {this.nom=nom;}
	
	public String getPrenom() {return this.prenom;}
	public void setPrenom(String prenom) {this.prenom=prenom;}
	
	public int getNote1() {return this.note1;}
	public void setNote1(int note1) {this.note1=note1;}
	
	public int getNote2() {return this.note2;}
	public void setNote2(int note2) {this.note2=note2;}

	

}
