package librettery;

import java.util.Timer;

public class Livre implements Document {
	public int numero;
	public Abonne abo;

	@Override
	public int numero() {
		return this.numero;
	}

	@Override
	public void reserver(Abonne ab) throws PasLibreException {
		if (this.abo == null)
			throw new PasLibreException();
		this.abo = ab;
		Timer timer = new Timer();
	}

	@Override
	public void emprunter(Abonne ab) throws PasLibreException {
		if (this.abo == null)
			throw new PasLibreException();
		this.abo = ab;
	}

	@Override
	public void rendreDispo() {
		this.abo = null;
	}

}
