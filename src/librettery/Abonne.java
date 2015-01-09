package librettery;

import java.util.Timer;

public class Abonne {
	private int numero;
	private String nom;
	private int age;
	private boolean indesirable;
	private static int num = 0;
	
	public Abonne(String nom, int age){
		this.numero = Abonne.generateNumero();
		this.nom = nom;
		this.age = age;
	}


	private static int generateNumero() {
		return ++num;
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
