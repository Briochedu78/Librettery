package librettery;

public class Abonne {
	private int numero;
	private String nom;
	
	
	public Abonne(String nom){
		this.numero = Abonne.generateNumero();
		this.nom = nom;
	}


	private static int generateNumero() {
		return (int) (Math.random() * Integer.MAX_VALUE);
	}


	public int getNumero() {
		return numero;
	}


	public String getNom() {
		return nom;
	}
}
