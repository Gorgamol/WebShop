import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import com.google.gson.Gson;

@ManagedBean
@SessionScoped
public class KundenHandler implements Serializable {
	private static final long serialVersionUID = 1L;
	
	Map<String, Integer> warenkorb;
	ArrayList<String> isbnListe;
	Kunde kunde;
	String bezahlmethode;
	
	public void updateIsbnListe() {
		isbnListe.clear();
		for(String s : warenkorb.keySet()) {
			isbnListe.add(s);
		}
	}
	
	public double getGesamtpreis() {
		
		double gesamtpreis = 0;
		Datenbank datenbank = new Datenbank();
		for(String s : warenkorb.keySet()) {
			gesamtpreis += Double.parseDouble(datenbank.getBuchByISBN(s).getPreis()) * warenkorb.get(s);
		}
		
		return gesamtpreis;
	}
	
	public ArrayList<String> getIsbnListe() {
		return isbnListe;
	}

	public void setIsbnListe(ArrayList<String> isbnListe) {
		this.isbnListe = isbnListe;
	}


	
	public String getBezahlmethode() {
		return bezahlmethode;
	}
	
	public void submit() {
		Gson gson = new Gson();
		System.out.println(gson.toJson(kunde));
	}

	public void setBezahlmethode(String bezahlmethode) {
		this.bezahlmethode = bezahlmethode;
	}

	public void changeBezahlmethode(ValueChangeEvent e){
		setBezahlmethode(e.getNewValue().toString());
	}
	
	public Kunde getKunde() {
		return kunde;
	}

	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

	public KundenHandler() {
		kunde = new Kunde();
		warenkorb = new HashMap<String, Integer>();
		isbnListe = new ArrayList<String>();
	}
	
	public void addToBasket(String isbn13, int anzahl) {
		if(!warenkorb.containsKey(isbn13)) {
			warenkorb.put(isbn13, anzahl);
			updateIsbnListe();
		} else {
			warenkorb.put(isbn13, warenkorb.get(isbn13) + 1);
		}
		//System.out.println(warenkorb);
	}
	
	public String addToBasket2(String isbn13, int anzahl, String kat) {
		if(!warenkorb.containsKey(isbn13)) {
			warenkorb.put(isbn13, anzahl);
			updateIsbnListe();
		} else {
			warenkorb.put(isbn13, warenkorb.get(isbn13) + 1);
		}
		System.out.println(warenkorb);
		return "warengruppen?kategorie=" + kat;
	}
	
	public void incrementOrder(String isbn13) {
		warenkorb.put(isbn13, warenkorb.get(isbn13) + 1);
	}
	
	public void decrementOrder(String isbn13) {
		if(warenkorb.get(isbn13) == 1) {
			deleteOrder(isbn13);
			isbnListe.remove(isbn13);
		} else {
			warenkorb.put(isbn13, warenkorb.get(isbn13) - 1);				
		}
	}
	
	public Map<String, Integer> getWarenkorb() {
		return warenkorb;
	}

	public void setWarenkorb(Map<String, Integer> warenkorb) {
		this.warenkorb = warenkorb;
	}

	public void deleteOrder(String isbn13) {
		warenkorb.remove(isbn13);
		isbnListe.remove(isbn13);
	}
	
	public String saveOrder() {
		Datenbank datenbank = new Datenbank();
		for(String s : warenkorb.keySet()) {
			kunde.setBestellung("- [" + s + "   x" + warenkorb.get(s) + "] ");
		}
		datenbank.addKunde(kunde);
		kunde = new Kunde();
		warenkorb = new HashMap<String, Integer>();
		isbnListe = new ArrayList<String>();
		return "Vielen Dank für Ihre Bestellung!";
	}
	
	public void clear() {
		warenkorb.clear();
		isbnListe.clear();
	}
	
}
