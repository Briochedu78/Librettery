package librettery;

public class FDocument {
	public static Document buildDoc(String id){
		String type = id.substring(0, 2);
		int numero = Integer.parseInt(id.substring(2));
		if(type.equals("li")){
			return new Livre(numero);
		}
		return null;
	}
}
