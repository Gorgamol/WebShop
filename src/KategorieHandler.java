import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.google.gson.Gson;

@ManagedBean (name = "kategorieHandler")
@SessionScoped
public class KategorieHandler implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<String> kategorieListe;
	
	public KategorieHandler() {
		kategorieListe = new ArrayList<String>();
		setKategorieListe();
	}

	public ArrayList<String> getKategorieListe() {
		return kategorieListe;
	}

	public void setKategorieListe() {
		Gson gson = new Gson();
		Datenbank datenbank = new Datenbank();
		String[] tmp = datenbank.getDatenbankInhalt().substring(11).split("-");
		ArrayList<Buch> buecher = new ArrayList<Buch>();
		for(String s : tmp) {
			buecher.add(gson.fromJson(s, Buch.class));
		}
		for(Buch b : buecher) {
			if(!kategorieListe.contains(b.getKategorie())) {
				kategorieListe.add(b.getKategorie());				
			}
		}
	}

}
