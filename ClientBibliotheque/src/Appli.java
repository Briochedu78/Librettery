import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Appli {
	public static void main(String args[]) {
		Socket s = null;
		Scanner sc = new Scanner(System.in);
		int port;
		String line = sc.nextLine(), type;
		boolean continuer = true;
		while(true){
			System.out.print("Saisissez emprunt pour un emprunt et retour pour un retour : ");
			if(line.equals("emprunt")){
				type = line;
				port = 2600;
				break;
			}
			else if(line.equals("retour")){
				type = line;
				port = 2700;
				break;
			}
		}

		System.out.print("Entrez l'ip du serveur : ");
		String host = sc.nextLine();
		
		try {
			s = new Socket(host, port);
			
			BufferedReader sin = new BufferedReader (new InputStreamReader(s.getInputStream ( )));
			PrintWriter sout = new PrintWriter (s.getOutputStream ( ), true);
			
			BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));		

			System.out.println("Connecté au serveur " + s.getInetAddress() + ":"+ s.getPort());
			
			Integer numAbo, numDoc;
			
			while(continuer) {
				
				System.out.print("> ");
				System.out.flush();
				line = clavier.readLine();
				if(line == null)
					break;
				
				System.out.println("Veuillez entrer votre numero d'abonne");
				System.out.print("> ");
				System.out.flush();
				
				line = clavier.readLine();
				if(line == null)
					break;
				numAbo = Integer.parseInt(line);
				
				System.out.flush();
				System.out.println("Veuillez entrer le numero de document");
				System.out.print("> ");
				line = clavier.readLine();
				if (line == null)
					break;
				
				numDoc = Integer.parseInt(line);
				
				
				sout.println(type + " " + numDoc.toString() + " " + numAbo.toString());
				
				line = sin.readLine();
				
				if (line == null) { 
					System.out.println("Connection fermee par le serveur."); 
					break;
				}
				
				System.out.println(line);
				break;
			}
		}
		catch (IOException e) { System.err.println(e); }
		
		try { if (s != null) s.close(); } 
		catch (IOException e2) { ; }		
	}
}
