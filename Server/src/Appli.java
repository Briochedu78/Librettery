import java.io.IOException;
import librettery.AppliLibrettery;;

public class Appli {
	private static int portReservation = 2500,
					   portEmprunt = 2600,
					   portRetour = 2700;
	
	
	
	public static void main(String[] args) {
		try {
			new ServeurReservation(portReservation).lancer();
			System.out.println("Serveur des reservation lance sur le port " + portReservation);
			
			new ServeurEmprunt(portEmprunt).lancer();
			System.out.println("Serveur des emprunts lance sur le port " + portEmprunt);
			
			new ServeurRetour(portRetour).lancer();
			System.out.println("Serveur des retour lance sur le port " + portRetour);
		} catch (IOException e) {
				System.err.println("Erreur lors de la création d'un des serveur : " +  e);			
		}
	}
}
