package data.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Beschreibt die Tabelle Gender
 */
public class Gender extends DataAccesObject {

	private final String SQL_INSERT = "INSERT INTO GENDER (KUERZEL, INFO) VALUES('%s', '%s')";
	private final String SQL_UPDATE = "UPDATE gender set kuerzel = '%s', info = '%s' WHERE id = %d;";
	private String kuerzel;
	private String info;

	/**
	 * Konstruktor für generische LoadbyID Funktion
	 * 
	 * @param rs
	 * @throws SQLException
	 */
	public Gender(ResultSet rs) throws SQLException {
		this.kuerzel = rs.getString("kuerzel");
		this.info = rs.getString("info");
	}

	/**
	 * Konstruiert eine Instanz Initialisiert die Felder kuerzel und info
	 * 
	 * @param kuerzel
	 * @param info
	 */
	public Gender(String kuerzel, String info) {
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
	public Gender(int id, String kuerzel, String info) {
		super();
		this.id = id;
		this.kuerzel = kuerzel;
		this.info = info;
	}

	@Override
	public String getSqlString() {
		if (id > 0) {
			return SQL_UPDATE.formatted(kuerzel, info, id);
		} else {
			return SQL_INSERT.formatted(kuerzel, info);
		}
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
