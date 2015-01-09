package librettery;

import java.util.Timer;

public class Abonne {
	private int numero;
	private String nom;
	private int age;
	private boolean indesirable;
	
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


	public void indesirable() {
		this.indesirable = true;
		new Timer();
	}


	public void desirable() {
		this.indesirable = false;
	}


	public boolean estIndesirable() {
		return this.indesirable;
	}
}
