
public class Kunde {
	String anrede;
	String name;
	String nachname;
	String stra�e;
	String hsnr;
	String plz;
	String ort;
	String land;
	String tel;
	String email;
	String kartenInhaber;
	String kartenNummer; //kreditkarte
	String karteG�ltig;
	String kontoInhaber;
	String iban;
	String bestellung;
	
	public String getAnrede() {
		return anrede;
	}
	public void setAnrede(String anrede) {
		this.anrede = anrede;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public String getStra�e() {
		return stra�e;
	}
	public void setStra�e(String stra�e) {
		this.stra�e = stra�e;
	}
	public String getHsnr() {
		return hsnr;
	}
	public void setHsnr(String hsnr) {
		this.hsnr = hsnr;
	}
	public String getPlz() {
		return plz;
	}
	public void setPlz(String plz) {
		this.plz = plz;
	}
	public String getOrt() {
		return ort;
	}
	public void setOrt(String ort) {
		this.ort = ort;
	}
	public String getLand() {
		return land;
	}
	public void setLand(String land) {
		this.land = land;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getKartenInhaber() {
		return kartenInhaber;
	}
	public void setKartenInhaber(String kartenInhaber) {
		this.kartenInhaber = kartenInhaber;
	}
	public String getKartenNummer() {
		return kartenNummer;
	}
	public void setKartenNummer(String kartenNummer) {
		this.kartenNummer = kartenNummer;
	}
	public String getKarteG�ltig() {
		return karteG�ltig;
	}
	public void setKarteG�ltig(String karteG�ltig) {
		this.karteG�ltig = karteG�ltig;
	}
	public String getKontoInhaber() {
		return kontoInhaber;
	}
	public void setKontoInhaber(String kontoInhaber) {
		this.kontoInhaber = kontoInhaber;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public String getBestellung() {
		return bestellung;
	}
	public void setBestellung(String bestellung) {
		this.bestellung += " - " + bestellung;
	}
}
