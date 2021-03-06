import com.google.gson.Gson;

import de.imut.ec.keyvaluestore.KeyValueStore;

public class Datenbank {
	KeyValueStore kvs;
	String key;
	String keyKunde;
	Gson gson;
	
	public Datenbank() {
		kvs = new KeyValueStore();
		key = "DavidPatrickChristopher123456";
		keyKunde = "DavidPatrick_Kunden";
		if(kvs.get(key) == null) {
			kvs.put(key, "Buchliste:");
		}
		if(kvs.get(keyKunde) == null) {
			kvs.put(keyKunde, "Kundenliste:");
		}
	}
	
	public String add(Buch buch) {
		gson = new Gson();
		String jsonString = gson.toJson(buch);
		kvs.put(key, kvs.get(key) + "-" + jsonString);
		return jsonString;
	}

	public boolean contains(Buch buch) {
		if(kvs.get(key).contains("isbn13\":\"" + buch.getIsbn13())) {
			return true;
		}
		return false;
	}
	
	public boolean contains(Kunde kunde) {
		if(kvs.get(keyKunde).contains("tel\":\"" + kunde.getTel())) {
			return true;
		}
		return false;
	}
	
	public void addKunde(Kunde kunde) {
		gson = new Gson();
		String jsonString = gson.toJson(kunde);
		kvs.put(keyKunde, kvs.get(keyKunde) + "-" + jsonString);
	}
	
	public String getDatenbankInhalt() {
		return kvs.get(key);
	}
	
	public Buch getBuchByISBN(String isbn13) {
		gson = new Gson();
		String[] tmpBuchliste;
		tmpBuchliste = getDatenbankInhalt().substring(11).split("-");
		Buch tmpBuch = new Buch();
		for(String s : tmpBuchliste) {
			if(s.contains("\"isbn13\":\"" + isbn13)) {
				tmpBuch = gson.fromJson(s, Buch.class);
			}
		}
		return tmpBuch;
	}
	
}
