package librettery;

import java.util.Timer;

public class Reservation {
	private int idReservation;
	private int idAbo;
	private int idDocument;
	private FinReservation tempRestant;
	
	/**
	 * 1h = 1000ms
	 */
	private static int tempsReservation = 5000;
	
	public Reservation(Abonne abo, Document document){
		this.idAbo = abo.getNumero();
		this.idDocument = document.numero();
		this.idReservation = Reservation.generateNumero();
	}

	private static Timer createTimer() {
		// TODO Auto-generated method stub
		return null;
	}

	private static int generateNumero() {
		return (int) (Math.random() * Integer.MAX_VALUE);
	}
}
