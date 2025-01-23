package bl;

import java.util.ArrayList;

import data.DataManager;
import data.entities.DataGender;
import data.entities.DataPerson;

public class DTOManager {

	/**
	 * LoadForm loads the Form from the DataManager and transforms it
	 * 
	 * @return List of Data to be used
	 */
	
	public ArrayList<ListData> loadAllGender() {
		ArrayList<ListData> dataList = new ArrayList<>();
		ArrayList<DataGender> dtoList = DataManager.getInstance().getAllGenders();

		for (DataGender dg : dtoList) {
			ListData ld = new ListData();
			ld.id = dg.getId();
			ld.title = dg.getKuerzel();
			dataList.add(ld);
		}
		return dataList;
	}

	/**
	 * Deletes a form based on the form given by the FormularPanel
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
	 * LoadForm loads the Form from the DataManager and transforms it
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
	 * Deletes a form based on the form given by the FormularPanel
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
	 * Saves the Gender based on the given DTO to the Database
	 */
	public String savePerson(Person dto) {
		DataPerson dg = new DataPerson(dto.getName(), dto.getVorname(), dto.getGebdat());
		
		return null;
	}


}
