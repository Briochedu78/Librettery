import java.io.IOException;
import java.net.ServerSocket;


public class ServeurReservation implements Runnable {
private ServerSocket listen_socket;
	
	public ServeurReservation(int port) throws IOException{
		listen_socket = new ServerSocket(port);
	}

	public void run() {
		try {
			while(true)
				new ServiceReservation(listen_socket.accept()).lancer();
		}
		catch (IOException e) { 
			try {this.listen_socket.close();} catch (IOException e1) {}
			System.err.println("Pb sur le port d'écoute :"+e);
		}
	}

	public void lancer() {
		(new Thread(this)).start();
	}

}
