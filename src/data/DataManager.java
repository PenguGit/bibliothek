package data;

import java.lang.reflect.Constructor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import data.entities.DataAdresse;
import data.entities.DataAccessObject;
import data.entities.DataGender;
import data.entities.DataPerson;

/**
 * Class that manages the Data of the DB
 */
public class DataManager implements Constants {
	
	/**
	 * Connection Constants for the DB
	 */
	public static final String URL = "jdbc:mysql://localhost:3306/pers";
	public static final String USER = "root";
	public static final String PASSWORD = "";
	
	/**
	 * Singleton to ensure only one DBManager uses the DB
	 * with one Connection
	 */
	private static DataManager instance;
	private Connection connection;

	/**
	 * private due singleton
	 */
	private DataManager() {
		super();
	}
	
	/**
	 * @return the Instance of the DBManager
	 */
	public static DataManager getInstance() {

		if (instance == null) {
			instance = new DataManager();
			try {
				instance.connection = DriverManager.getConnection(URL, USER, PASSWORD);
				Runtime.getRuntime().addShutdownHook(new Thread(() -> {
					try {
						if (instance.connection != null && !instance.connection.isClosed()) {
							instance.connection.close();
							System.out.println("Connection closed.");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	/** 
	 * Deletes an entry based on ID
	 * @param id
	 * @return
	 */
	public String deleteFormByID(int id, String s) {
		try {
			Statement stmt = connection.createStatement();
			String sql = "delete from %s where id = " + id;
			sql.formatted(s);
			stmt.execute(sql);
		} catch (SQLException e) {
			return e.getMessage();
		}
		return null;
	}

	/**
	 * Saves the data to the Database of any Table
	 * 
	 * @param dao
	 */
	public void save(DataAccessObject dao) {
		try {
			// Open Connection to Database
			// create a statement
			Statement stmt = connection.createStatement();
			// execute statement
			String sql = dao.getSqlString();
			// System.out.println(sql);
			stmt.execute(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet result = stmt.getGeneratedKeys();

			if (result.next()) {
				int pk = result.getInt(1); // pk ist der Wert aus dem ResultSet
				dao.setId(pk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Read out all entries in the table Gender and save them
	 * @return an ArrayList of all items in the Table gender
	 */
	public ArrayList<DataGender> getAllGenders() {
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from gender");
			ArrayList<DataGender> genderList = new ArrayList<>();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("info");
				String name2 = rs.getString("kuerzel");
				genderList.add(new DataGender(id, name2, name));
			}
			return genderList;
		} catch (SQLException e) {
			return null;
		}

	}
	
	/**
	 * Read out all entries in the table Adressen and save them
	 * @return an ArrayList of all items in the Table Adressen
	 */
	public ArrayList<DataAdresse> getAllAdressen() {
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from adresse");
			ArrayList<DataAdresse> adressList = new ArrayList<>();
			while (rs.next()) {
				int id = rs.getInt("id");
				int plz = rs.getInt("plz");
				String str = rs.getString("strasse");
				String hausnr = rs.getString("hausnr");
				String stadt = rs.getString("stadt");
				adressList.add(new DataAdresse(id, plz, stadt, str, hausnr));
			}
			return adressList;
		} catch (SQLException e) {
			return null;
		}
	}
	
	
	/**
	 * Load any single item by the ID and the class given. Generic method
	 * @param <T> T being a class that is generic of the type DataAccessObject
	 * @param id 
	 * @param clazz classname
	 * @return return the Object of the classtype given by clazz
	 */
	public <T extends DataAccessObject> T loadById(int id, Class<T> clazz) {
		// Derive table name from the class name
		String tableName = clazz.getSimpleName().toLowerCase();
		String query = "SELECT * FROM " + tableName + " WHERE id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					// Use reflection to create an instance of the class
					Constructor<T> constructor = clazz.getDeclaredConstructor(ResultSet.class);
					return constructor.newInstance(rs);
				}
			}
		} catch (SQLException e) {
			System.err.println("SQL error: " + e.getMessage());
		} catch (ReflectiveOperationException e) {
			System.err.println("Reflection error: " + e.getMessage());
		}
		return null;
	}
	
	
	/**
	 * Load any single entry in the table Gender based on the param id given
	 * @param id
	 * @return
	 */
	public DataGender loadGenderbyID(int id) {
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from gender where id = " + id);
			DataGender g = null;
			if (rs.next()) {
				String name = rs.getString("kuerzel");
				String name2 = rs.getString("info");
				g = new DataGender(name, name2);
			}
			return g;
		} catch (SQLException e) {
			return null;
		}

	}
	
	/**
	 * Load any single entry in the table Adresse based on the param id given
	 * @param id
	 * @return
	 */
	public DataAdresse loadAdressebyID(int id) {
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from adresse where id = " + id);
			DataAdresse adr = null;
			if (rs.next()) {
				int plz = rs.getInt("plz");
				String str = rs.getString("strasse");
				String hausnr = rs.getString("hausnr");
				String stadt = rs.getString("stadt");
				adr = new DataAdresse(id, plz, stadt, str, hausnr);
			}
			return adr;
		} catch (SQLException e) {
			return null;
		}
	}
	
	/**
	 * Load any single entry in the table Persn based on the param id given
	 * @param id
	 * @return
	 */
	public DataPerson loadPersonbyID(int id) {
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from person where id = " + id);
			DataGender g = null;
			DataAdresse adr = null;
			DataPerson pers = null;
			if (rs.next()) {
				LocalDate gebdat = rs.getDate("geburtsdatum").toLocalDate();
				String name = rs.getString("name");
				String vname = rs.getString("vorname");
				int adresse_id = rs.getInt("adresse_id");
				int gender_id = rs.getInt("gender_id");
				g = loadGenderbyID(gender_id);
				adr = loadAdressebyID(adresse_id);
				pers = new DataPerson(name, vname, gebdat, g, adr);
				pers.setId(id);
			}
			return pers;
		} catch (SQLException e) {
			return null;
		}
	}
	
//	public ArrayList<DataAccesObject> getAllTable(DataAccesObject dao) {
//		try {
//			Statement stmt = connection.createStatement();
//			ResultSet rs = stmt.executeQuery(dao.getQueryString(dao.getClass().getSimpleName()));
//			ArrayList<DataAccesObject> itemList = new ArrayList<>();
//			while (rs.next()) {
//				int id = rs.getInt("id");
//				String name = rs.getString("info");
//				String name2 = rs.getString("kuerzel");
//				itemList.add(new Gender(id, name2, name));
//			}
//			return itemList;
//		} catch (SQLException e) {
//			return null;
//		}
//
//	}
	
	/**
	 * Execute a Query based on the string passed and return the resultset if everything worked
	 * @param sqlQuery
	 * @return
	 */
	public ResultSet executeQuery(String sqlQuery) {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			return null;
		}

		Statement stmt = null;
		try {
			stmt = connection.createStatement();
		} catch (SQLException e) {
			return null;
		}

		try {
			return stmt.executeQuery(sqlQuery);
		} catch (SQLException e) {
			return null;
		}

	}

	/**
	 * Executes a SQL statement
	 * 
	 * @param sqlStatement
	 * @return Error if it happens else return null
	 * @throws SQLException
	 */
	public String executeSQL(String sqlStatement) {
		Statement stmt = null;
		try {
			stmt = connection.createStatement();
		} catch (SQLException e) {
			return ERROR_MYSQL_ALLGEMEIN;
		}

		try {
			stmt.execute(sqlStatement);
		} catch (SQLException e) {
			return ERROR_MYSQL_ALLGEMEIN;
		}

		try {
			stmt.close();
		} catch (SQLException e) {
			return ERROR_MYSQL_ALLGEMEIN;
		}
		return null;
	}

	public ArrayList<DataPerson> getAllPerson() {
		// TODO Auto-generated method stub
		return null;
	}

}
