import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class KundenHandler implements Serializable {
	private static final long serialVersionUID = 1L;
	
	Map<String, Integer> warenkorb;
	Kunde kunde;
	
	public KundenHandler() {
		kunde = new Kunde();
		warenkorb = new HashMap<String, Integer>();
	}
	
	public void addToBasket(String isbn13, int anzahl) {
		warenkorb.put(isbn13, anzahl);
		System.out.println(warenkorb);
	}
	
	public void incrementOrder(String isbn13) {
		warenkorb.put(isbn13, warenkorb.get(isbn13) + 1);
	}
	
	public void decrementOrder(String isbn13) {
		if(warenkorb.get(isbn13) == 1) {
			deleteOrder(isbn13);
		} else {
			warenkorb.put(isbn13, warenkorb.get(isbn13) - 1);				
		}
	}
	
	public void deleteOrder(String isbn13) {
		warenkorb.remove(isbn13);
	}
}
