

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

class Appli {
	
	public static void main(String args[]) {
		Socket s = null;
		Scanner sc = new Scanner(System.in);
		int port = sc.nextInt();
		String host = sc.next();
		
		try {
			s = new Socket(host, port);
			
			BufferedReader sin = new BufferedReader (new InputStreamReader(s.getInputStream ( )));
			PrintWriter sout = new PrintWriter (s.getOutputStream ( ), true);
			
			BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));		

			System.out.println("Connecté au serveur " + s.getInetAddress() + ":"+ s.getPort());
			
			String line;
			int numAbo, numDoc;
			while(true) {
				System.out.println("Veuillez entrer votre numero d'abonne");
				System.out.print("> ");
				System.out.flush();
				
				line = clavier.readLine();
				if(line == null)
					break;
				numAbo = Integer.parseInt(line);
				
				System.out.flush();
				line = clavier.readLine();
				if (line == null) 
					break;
				
				
				sout.println(line);
				
				// lit la réponse provenant du serveur
				line = sin.readLine();
				
				// Verifie si la connection est fermee.
				// Si oui on sort de la boucle
				if (line == null) { 
					System.out.println("Connection fermee par le serveur."); 
					break;
				}
				
				// Ecrit la ligne envoyee par le serveur
				System.out.println(line);
			}
		}
		catch (IOException e) { System.err.println(e); }
		
		// Refermer dans tous les cas la socket
		try { if (s != null) s.close(); } 
		catch (IOException e2) { ; }		
	}
}
