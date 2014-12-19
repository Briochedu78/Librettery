

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
			Integer numAbo, numDoc;
			while(true) {
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
				
				
				sout.println(numDoc.toString() + " " + numAbo.toString());
				
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
