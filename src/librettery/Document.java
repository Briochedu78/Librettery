package librettery;

public interface Document {
	
	/**
	 * Les documents sont indiquer par un id tel que
	 * les 2 premiers caractères désignent le type de documents
	 * les suivants le numero exemple :
	 * li21466 : Livre de numero 21466
	 * dv1 : DVD de numero 1
	 * 
	 * Rmq : il ne faut donc pas créé d'id de ce genre :
	 * dv00000001
	 */
	int numero();
	void reserver(Abonne ab) throws PasLibreException;
	void emprunter(Abonne ab) throws PasLibreException;
	void rendreDispo();
}
