package librettery;

public class Abonne {
	private int numero;
	private String nom;
	private int age;
	
	public Abonne(String nom, int age){
		this.numero = Abonne.generateNumero();
		this.nom = nom;
		this.age = age;
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
	
	public int getAge(){
		return age;
	}
}
