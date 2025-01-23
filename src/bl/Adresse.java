package bl;

/**
 * Die Klasse repräsentiert die Entität Adresse (DB-Tabelle).
 * Die Felder der Klasse entsprechen den Attributen der Entität (Spalten).
 * Einer Instanz der Klasse entspricht ein Datensatz in der DB-Tabelle.
 */
public class Adresse extends DataTransferObject{
 
	private int plz;
	private String stadt;
	private String strasse;
	private String hausnr;
	
	/**
	 * Konstruiert eine Instanz der Klasse. 
	 * Initiallisiert alle Felder außer id.
	 * @param plz
	 * @param stadt
	 * @param strasse
	 * @param haus
	 */
	public Adresse(int plz, String stadt, String strasse, String haus) {
		super();
		this.plz = plz;
		this.stadt = stadt;
		this.strasse = strasse;
		this.hausnr = haus;
	}
	
	public Adresse(int id, int plz, String stadt, String strasse, String haus) {
		super();
		this.id = id;
		this.plz = plz;
		this.stadt = stadt;
		this.strasse = strasse;
		this.hausnr = haus;
	}

	public int getPlz() {
		return plz;
	}

	public void setPlz(int plz) {
		this.plz = plz;
	}

	public String getStadt() {
		return stadt;
	}

	public void setStadt(String stadt) {
		this.stadt = stadt;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getHaus() {
		return hausnr;
	}

	public void setHaus(String haus) {
		this.hausnr = haus;
	}
}
