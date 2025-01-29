package bl;

import java.time.LocalDate;

/**
 * Repräsentiert die Entität Person
 */
public class BLPersonFormular extends DataTransferObject {

	private String name;
	private String vorname;
	private LocalDate gebdat;
	private int gender_id;
	private int plz;
	private String stadt;
	private String strasse;
	private String hausnr;
	
	public BLPersonFormular() {
		super();
	}
	
	public BLPersonFormular(String name, String vorname, LocalDate gebdat, int gender_id, int plz, String stadt,
			String strasse, String hausnr) {
		super();
		this.name = name;
		this.vorname = vorname;
		this.gebdat = gebdat;
		this.gender_id = gender_id;
		this.plz = plz;
		this.stadt = stadt;
		this.strasse = strasse;
		this.hausnr = hausnr;
	}

	public int getGender_id() {
		return gender_id;
	}

	public void setGender_id(int gender_id) {
		this.gender_id = gender_id;
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

	public String getHausnr() {
		return hausnr;
	}

	public void setHausnr(String hausnr) {
		this.hausnr = hausnr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public LocalDate getGebdat() {
		return gebdat;
	}

	public void setGebdat(LocalDate gebdat) {
		this.gebdat = gebdat;
	}

}











