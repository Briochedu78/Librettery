package librettery;

import java.util.TimerTask;

public class InderiableTimerTask extends TimerTask {
	
	private Abonne abo;
	
	public InderiableTimerTask(Abonne abo){
		this.abo = abo;
	}
	
	@Override
	public void run() {
		this.abo.desirable();
	}

}
