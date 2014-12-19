import java.io.IOException;
import java.net.ServerSocket;


public class ServeurEmprunt implements Runnable {
	private ServerSocket listen_socket;
	
	public ServeurEmprunt(int port) throws IOException{
		listen_socket = new ServerSocket(port);
	}

	@Override
	public void run() {
		try {
			while(true)
				new ServiceEmprunt(listen_socket.accept()).lancer();
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
