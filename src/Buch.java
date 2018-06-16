

public class Buch {
	
	private String buchtitel;
	private String autor;
	private String kategorie;
	private String buchart;
	private String verlag;
	private String sprache;
	private String isbn10;
	private String isbn13;
	private String hoehe;
	private String breite;
	private String tiefe;
	private String preis;
	private String buchdetails;
	
	public String getBuchtitel() {
		return buchtitel;
	}
	
	public void setBuchtitel(String buchtitel) {
		this.buchtitel = buchtitel;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String getKategorie() {
		return kategorie;
	}
	
	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}
	
	public String getBuchart() {
		return buchart;
	}
	
	public void setBuchart(String buchart) {
		this.buchart = buchart;
	}
	
	public String getVerlag() {
		return verlag;
	}
	
	public void setVerlag(String verlag) {
		this.verlag = verlag;
	}
	
	public String getSprache() {
		return sprache;
	}
	
	public void setSprache(String sprache) {
		this.sprache = sprache;
	}
	
	public String getIsbn10() {
		return isbn10;
	}
	
	public void setIsbn10(String isbn10) {
		this.isbn10 = isbn10;
	}
	
	public String getIsbn13() {
		return isbn13;
	}
	
	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}
	
	public String getHoehe() {
		return hoehe;
	}
	
	public void setHoehe(String hoehe) {
		this.hoehe = hoehe + " cm";
	}
	
	public String getBreite() {
		return breite;
	}
	
	public void setBreite(String breite) {
		this.breite = breite + " cm";
	}
	
	public String getTiefe() {
		return tiefe;
	}
	
	public void setTiefe(String tiefe) {
		this.tiefe = tiefe + " cm";
	}
	
	public String getPreis() {
		return preis;
	}
	
	public void setPreis(String preis) {
		this.preis = preis + " EUR";
	}
	
	public String getBuchdetails() {
		return buchdetails;
	}
	
	public void setBuchdetails(String buchdetails) {
		this.buchdetails = buchdetails;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn10 == null) ? 0 : isbn10.hashCode());
		result = prime * result + ((isbn13 == null) ? 0 : isbn13.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Buch other = (Buch) obj;
		if (isbn10 == null) {
			if (other.isbn10 != null) {
				return false;
			}
		} else if (!isbn10.equals(other.isbn10)) {
			return false;
		}
		if (isbn13 == null) {
			if (other.isbn13 != null) {
				return false;
			}
		} else if (!isbn13.equals(other.isbn13)) {
			return false;
		}
		return true;
	}
}
