package bl;

import java.util.ArrayList;

import data.DataManager;
import data.entities.DataAdresse;
import data.entities.DataGender;
import data.entities.DataPerson;

public class DTOManager {

	/**
	 * loads the Genders from the DataManager and transforms it
	 * 
	 * @return List of Data to be used
	 */
	public ArrayList<Gender> loadAllGender() {
		ArrayList<Gender> dataList = new ArrayList<>();
		ArrayList<DataGender> dtoList = DataManager.getInstance().getAllGenders();

		for (DataGender dg : dtoList) {
			Gender g = new Gender(dg.getId(), dg.getKuerzel(), dg.getInfo());
			
			dataList.add(g);
		}
		return dataList;
	}

	/**
	 * Deletes a Gender based on the Object given by the Panel
	 * @param form
	 * @return
	 */
	public String deleteGender(Gender dto) {
		String err = DataManager.getInstance().deleteFormByID(dto.getId(), "gender");
		if (err == null) {
			dto.setId(0);
		}
		return err;
	}

	/**
	 * Saves the Gender based on the given DTO to the Database
	 */
	public String saveGender(Gender dto) {
		DataGender dg = new DataGender();
		dg.setInfo(dto.getInfo());
		dg.setKuerzel(dto.getKuerzel());
		
		return null;
	}
	
	/**
	 * loads the Adresse from the DataManager and transforms it
	 * @return List of Data to be used
	 */
	public ArrayList<ListData> loadAllAdressen() {
		ArrayList<ListData> dataList = new ArrayList<>();
		ArrayList<DataAdresse> dtoList = DataManager.getInstance().getAllAdressen();

		for (DataAdresse dg : dtoList) {
			ListData ld = new ListData();
			ld.id = dg.getId();
			ld.title = dg.getStadt() + " " + dg.getStrasse() + "" + dg.getHaus();
			dataList.add(ld);
		}
		return dataList;
	}
	
	/**
	 * Deletes an adress based on the person given 
	 * @param form
	 * @return
	 */
	public String deleteAdresse(Adresse dto) {
		String err = DataManager.getInstance().deleteFormByID(dto.getId(), "adresse");
		if (err == null) {
			dto.setId(0);
		}
		return err;
	}

	/**
	 * Saves the Person based on the given DTO to the Database
	 */
	public String saveAdresse(Adresse dto) {
		DataAdresse dg = new DataAdresse(dto.getPlz(), dto.getStadt(), dto.getStrasse(), dto.getHaus());
		String err = DataManager.getInstance().save(dg);
		return err;
	}
	
	/**
	 *  loads the Persons from the DataManager and transforms it
	 * 
	 * @return List of Data to be used
	 */
	public ArrayList<ListData> loadAllPerson() {
		ArrayList<ListData> dataList = new ArrayList<>();
		ArrayList<DataPerson> dtoList = DataManager.getInstance().getAllPerson();

		for (DataPerson dg : dtoList) {
			ListData ld = new ListData();
			ld.id = dg.getId();
			ld.title = dg.getVorname() + " " + dg.getName();
			dataList.add(ld);
		}
		return dataList;
	}

	/**
	 * Deletes a person based on the person given 
	 * @param form
	 * @return
	 */
	public String deletePerson(Person dto) {
		String err = DataManager.getInstance().deleteFormByID(dto.getId(), "gender");
		if (err == null) {
			dto.setId(0);
		}
		return err;
	}

	/**
	 * Saves the Person based on the given DTO to the Database
	 */
	public String savePerson(Person dto) {
		DataPerson dp = new DataPerson(dto.getName(), dto.getVorname(), dto.getGebdat());
		String err = DataManager.getInstance().savePerson(dp);
		if (err != null) {
			return err;
		}
		return null;
	}
}
