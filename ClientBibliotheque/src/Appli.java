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
		String line;
		while(true){
			System.out.print("Saisissez emprunt pour un emprunt et retour pour un retour : ");
			line = sc.nextLine();
			if(line.equals("emprunt")){
				port = 2600;
				break;
			}
			else if(line.equals("retour")){
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
			
			
			while(true) {
				
				line = sin.readLine();
				if (line == null)
					break;
				
				System.out.println(line);
				System.out.print("> ");
				System.out.flush();
				
				line = clavier.readLine();
				if(line == null)
					break;
				
				sout.println(line);
			}
		}
		catch (IOException e) { System.err.println(e); }
		
		try { if (s != null) s.close(); } 
		catch (IOException e2) { ; }		
	}
}
