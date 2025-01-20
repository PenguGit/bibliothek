package data.entities;

import data.DataManager;

/**
 * Mutterklasse aller Entitätsklassen
 */
public abstract class DataAccessObject {	
	private final String SQL_QUERY = "Select * from '%s';";
	protected int id;
	
	public String getQueryString(String table) {
		return SQL_QUERY.formatted(table);
	}

	public abstract String getSqlString();

	public void save() {
		DataManager.getInstance().save(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
