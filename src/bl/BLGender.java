package bl;

/**
 * Beschreibt die Tabelle Gender
 */
public class BLGender extends DataTransferObject {

	private String kuerzel;
	private String info;

	/**
	 * Konstruiert eine Instanz Initialisiert die Felder kuerzel und info
	 * 
	 * @param kuerzel
	 * @param info
	 */
	public BLGender(String kuerzel, String info) {
		super();
		this.kuerzel = kuerzel;
		this.info = info;
	}

	/**
	 * Konstruiert eine Instanz (Beim einlesen) Initialisiert die Felder kuerzel und
	 * info und ID
	 * 
	 * @param kuerzel
	 * @param info
	 */
	public BLGender(int id, String kuerzel, String info) {
		super();
		this.id = id;
		this.kuerzel = kuerzel;
		this.info = info;
	}


	public String getKuerzel() {
		return kuerzel;
	}

	public void setKuerzel(String kuerzel) {
		this.kuerzel = kuerzel;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
