import com.google.gson.Gson;

import de.imut.ec.keyvaluestore.KeyValueStore;

public class Datenbank {
	KeyValueStore kvs;
	String key;
	Gson gson;
	
	public Datenbank() {
		kvs = new KeyValueStore();
		key = "DavidPatrickChristopher123456";
		if(kvs.get(key) == null) {
			System.out.println("DATENBANK LEER STRING REINGEHAUEN"); 
			kvs.put(key, "Buchliste:");
		}
	}
	
	public String add(Buch buch) {
		gson = new Gson();
		String jsonString = gson.toJson(buch);
		kvs.put(key, kvs.get(key) + "-" + jsonString);
		System.out.println(jsonString);
		return jsonString;
	}

	public boolean contains(Buch buch) {
		if(kvs.get(key).contains("isbn13\":\"" + buch.getIsbn13())) {
			return true;
		}
		return false;
	}
	
	public String getDatenbankInhalt() {
		return kvs.get(key);
	}
	
	
}
