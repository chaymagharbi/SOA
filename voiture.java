package pk1;

import java.io.Serializable;

public class voiture  implements Serializable{
	private String Marque;
	private float prixachat;
	private int km;
	private float prixvente;
	
	
	public voiture(String Marque,float prixachat,int km) {
		this.Marque=Marque;
		this.prixachat=prixachat;
		this.km=km;
		
	}
	public String getMarque() {
		return this.Marque;
	}
	public void setMarque(String Marque) {
		this.Marque=Marque;
	}
	public float getPrixachat() {
		return this.prixachat;
	}
	public void setPrixachat(float prixachat) {
		this.prixachat=prixachat;
	}
	public int getKm() {
		return this.km;
	}
	public void setKm(int km) {
		this.km=km;
	}
	public float getMPrixvente() {
		return this.prixvente;
	}
	public void setPrixvente(float prixvente) {
		this.prixvente=prixvente;
	}

}
