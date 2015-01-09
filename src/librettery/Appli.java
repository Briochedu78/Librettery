package librettery;

public class Appli {
	
	private static int facteur_jour = 1000;
	
	public static int getMilliNbJours(int nbjours){
		return nbjours * facteur_jour;
	}
}
