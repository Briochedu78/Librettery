import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import librettery.Librettery;
import librettery.PasLibreException;

public class ServiceEmprunt implements Runnable {
	private Socket socket;

	public ServiceEmprunt(Socket accept) {
		socket = accept;
		System.out.println("Connexion effectuee");
	}

	public void run() {
		BufferedReader sin = null;
		PrintWriter sout = null;
		
		try {
			sin = new BufferedReader (new InputStreamReader(socket.getInputStream ( )));
			sout = new PrintWriter (socket.getOutputStream ( ), true);
			String[] in = parse(sin.readLine());
			
			do{
				if(!(in.length == 3)){
					sout.println("Envoie de donnee invalide");
					break;
				}
				if(!in[0].equals("emprunt")){
					sout.println("Ceci n'est pas un emprunt");
					break;
				}
				else{
					int idAbo = Integer.parseInt(in[1]),
						idDoc = Integer.parseInt(in[2]);
					
					Librettery.emprunter(idAbo, idDoc);
				}
			}while(false);
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (IllegalArgumentException e) {
			sout.println(e);
		} catch (PasLibreException e) {
			sout.println(e);
		}
		
		try {
			socket.close();
		} catch (IOException e) {
			;
		}
	}

	private String[] parse(String line) {
		return line.split(" ");
	}

	

	public void lancer() {
		(new Thread(this)).start();
	}

}
