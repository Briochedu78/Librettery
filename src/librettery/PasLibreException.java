package librettery;

//@SuppressWarnings("serial")
public class PasLibreException extends Exception {
	public PasLibreException(String string) {
		super("Le document n'est pas libre" + string
				+ " ou l'abonne n'est pas autorise a emprunter");
	}

	public PasLibreException() {
		super();
	}
}
