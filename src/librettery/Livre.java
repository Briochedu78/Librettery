package librettery;


public class Livre implements Document {
	public int numero;
	public Abonne abo;

	public int numero() {
		return this.numero;
	}

	public void reserver(Abonne ab) throws PasLibreException {
		synchronized (this) {
			if (this.abo == null)
				throw new PasLibreException();
			this.abo = ab;
		}
	}

	public void emprunter(Abonne ab) throws PasLibreException {
		synchronized (this) {
			if (this.abo == null)
				throw new PasLibreException();
			this.abo = ab;
		}
	}

	public void rendreDispo() {
		synchronized (this) {
			this.abo = null;
		}
	}

}
