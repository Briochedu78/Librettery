package librettery;

import java.util.TimerTask;

public class IndesirableTimerTask extends TimerTask {
	
	private Abonne abo;
	
	public IndesirableTimerTask(Abonne abo){
		this.abo = abo;
	}
	
	@Override
	public void run() {
		this.abo.desirable();
		System.out.println("abo desirable");
	}

}
