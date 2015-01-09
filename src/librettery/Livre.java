package librettery;

import java.util.Date;


public class Livre implements Document {
	private int numero;
	private Abonne abo;
	private Date date_emprunt;
	
	private static int tempsLimite = Appli.getMilliNbJours(15);
	
	public Livre(int numero){
		this.numero = numero;
		date_emprunt = new Date();
	}
	
	public int numero() {
		return this.numero;
	}

	public void reserver(Abonne ab) throws PasLibreException {
		synchronized (this) {
			if (this.abo == null || abo.estIndesirable())
				throw new PasLibreException();
			this.abo = ab;
		}
	}

	public void emprunter(Abonne ab) throws PasLibreException {
		synchronized (this) {
			if (this.abo == null || abo.estIndesirable())
				throw new PasLibreException();
			this.abo = ab;
		}
	}

	public void rendreDispo() {
		synchronized (abo){
			if(this.date_emprunt.compareTo(new Date()) > tempsLimite){
				abo.indesirable();
			}
		}
		synchronized (this) {
			this.abo = null;
		}
		
	}

}
