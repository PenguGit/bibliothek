package bl;

/**
 * Mutterklasse aller Entitätsklassen
 */
public abstract class DataTransferObject {	
	protected int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
