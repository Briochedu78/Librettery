package librettery;

public interface Document {
	int numero();
	void reserver(Abonne ab);
	void emprunter(Abonne ab);
	void rendreDispo();
}
