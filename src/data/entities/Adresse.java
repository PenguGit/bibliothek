package data.entities;

/**
 * Die Klasse repräsentiert die Entität Adresse (DB-Tabelle).
 * Die Felder der Klasse entsprechen den Attributen der Entität (Spalten).
 * Einer Instanz der Klasse entspricht ein Datensatz in der DB-Tabelle.
 */
public class Adresse extends DataAccesObject{
 
	private final String SQL_INSERT = "INSERT INTO ADRESSE (plz, stadt, strasse, hausnr) VALUES(%d, '%s', '%s', '%s')";
	private final String SQL_UPDATE = "UPDATE adresse set plz = %d, stadt = '%s', strasse = '%s', hausnr = '%s' WHERE id = %d;";
	
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

	@Override
	public String getSqlString() {
		if (id > 0) {
			return SQL_UPDATE.formatted(plz, stadt, strasse, hausnr, id);
		} else {
			return SQL_INSERT.formatted(plz, stadt, strasse, hausnr);
		}
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

	@Override
	public String getQueryString(String col) {
		return null;
	}
}
