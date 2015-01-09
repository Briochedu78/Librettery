package librettery;

import java.util.Map;
import java.util.TreeMap;

public class Librettery {
	private static Map<Integer, Abonne> abonnes = new TreeMap<Integer, Abonne>();
	private static Map<Integer, Document> documents = new TreeMap<Integer, Document>();

	public static void reserver(int idAbo, int idDoc) throws PasLibreException, IllegalArgumentException {
		if (documents.containsKey(idDoc) && abonnes.containsKey(idAbo)) {
			synchronized (documents.get(idDoc)) {
				documents.get(idDoc).reserver(abonnes.get(idAbo));
			}
		} else {
			throw new IllegalArgumentException("L'abonne " + idAbo
					+ " n'existe pas ou le document " + idDoc + " n'existe pas");
		}
	}

	public static void emprunter(int idAbo, int idDoc) throws PasLibreException, IllegalArgumentException {
		if (documents.containsKey(idDoc) && abonnes.containsKey(idAbo)) {
			synchronized (documents.get(idDoc)) {
				documents.get(idDoc).emprunter(abonnes.get(idAbo));
			}
		} else {
			throw new IllegalArgumentException("L'abonne " + idAbo
					+ " n'existe pas ou le document " + idDoc + " n'existe pas");
		}
	}

	public static void retour(int idDoc) throws PasLibreException, IllegalArgumentException {
		if (documents.containsKey(idDoc)) {
			synchronized (documents.get(idDoc)) {
				documents.get(idDoc).rendreDispo();
			}
		} else {
			throw new IllegalArgumentException("Le document " + idDoc + " n'existe pas");
		}
	}
	
	public static void ajouter(Document d){
		documents.put(d.numero(), d);
	}
	
	public static void ajouter(Abonne a){
		abonnes.put(a.getNumero(), a);
	}
	
	public static void rendreIndesirable(int idAbo){
		abonnes.get(idAbo).indesirable();
	}
}
