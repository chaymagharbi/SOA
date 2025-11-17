
public class etudiant {

	private int id ;
	private String nom ;
	private double moyenne ;
	public etudiant(int id, String nom, double moyenne){
		this.id=id;
		this.nom=nom;
		this.moyenne= moyenne;
	}
	public  int getEtudiantId() {
		return this.id;
	}

	public void setEtudiantId(int id) {
		this.id = id;
	}
	public String getEtudiantNom() {
		return this.nom;
	}

	public void setEtudiantNom(String nom) {
		this.nom = nom;
	}
	public double getEtudiantMoyenne() {
		return this.moyenne;
	}

	public void setEtudiantMoyenne(double d) {
		this.moyenne = d;
	}
	public etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}



}
