package librettery;

public class Appli {
	
	private static int facteur_jour = 1000;
	
	public static int getMilliNbJours(int nbjours){
		return nbjours * facteur_jour;
	}
	
	public static void main(String[] args) {
		String type = "li";
		for(int i = 0; i < 10; ++i){
			Librettery.ajouter(FDocument.buildDoc(type + (i + 1)));
			Librettery.ajouter(new Abonne("toto" + (i + 1), (int) (Math.random() * 80)));
		}
	}
}
