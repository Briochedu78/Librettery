package librettery;

import java.util.Timer;
import java.util.TimerTask;

public class FinReservation extends TimerTask {

	private Livre livre;
	private Timer timer;

	public FinReservation(Livre l, Timer tim) {
		this.livre = l;
		this.timer = tim;
	}

	@Override
	public void run() {
		this.livre.rendreDispo();
		this.timer.cancel();
	}

}
