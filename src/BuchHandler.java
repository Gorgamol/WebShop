import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import com.google.gson.Gson;

@ManagedBean
@SessionScoped
public class BuchHandler implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Gson gson;
	private DataModel<Buch> buchliste;
	private String[] tmpBuchliste;
	private String currentBook;
	
	public String getCurrentBook() {
		return currentBook;
	}

	public void setCurrentBook(String currentBook) {
		this.currentBook = currentBook;
	}

	public BuchHandler() {
			Datenbank datenbank = new Datenbank();
			gson = new Gson();
			tmpBuchliste = datenbank.getDatenbankInhalt().substring(11).split("-");
	}
	
	public DataModel<Buch> getBuchliste(String kategorie) {
		ArrayList<Buch> buchByKategorie = new ArrayList<Buch>();
		for(String s : tmpBuchliste) {
			if(s.contains("\"kategorie\":\"" + kategorie)) {
				buchByKategorie.add(gson.fromJson(s, Buch.class));
			}
		}
		buchliste = new ListDataModel<Buch>();
		buchliste.setWrappedData(buchByKategorie);
		
		return buchliste;
	}
	
	public Buch getBuchByISBN(String isbn13) {
		Buch tmpBuch = new Buch();
		for(String s : tmpBuchliste) {
			if(s.contains("\"isbn13\":\"" + isbn13)) {
				tmpBuch = gson.fromJson(s, Buch.class);
			}
		}
		return tmpBuch;
	}
}
