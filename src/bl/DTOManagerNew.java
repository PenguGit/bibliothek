package bl;

import java.util.ArrayList;

import data.DataManager;
import data.entities.Adresse;
import data.entities.Gender;
import data.entities.Person;

public class DTOManagerNew {

	/**
	 * loads the Genders from the DataManager and transforms it
	 * 
	 * @return List of Data to be used
	 */
	public ArrayList<BLGender> loadAllGender() {
		ArrayList<BLGender> dataList = new ArrayList<>();
		ArrayList<Gender> dtoList = DataManager.getInstance().getAllGenders();

		for (Gender dg : dtoList) {
			BLGender g = new BLGender(dg.getId(), dg.getKuerzel(), dg.getInfo());
			
			dataList.add(g);
		}
		return dataList;
	}

	/**
	 * Deletes a Gender based on the Object given by the Panel
	 * @param form
	 * @return
	 */
	public String deleteGender(BLGender dto) {
		String err = DataManager.getInstance().deleteFormByID(dto.getId(), "gender");
		if (err == null) {
			dto.setId(0);
		}
		return err;
	}

	/**
	 * Saves the Gender based on the given DTO to the Database
	 */
	public String saveGender(BLGender dto) {
		Gender dg = new Gender();
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
		ArrayList<Adresse> dtoList = DataManager.getInstance().getAllAdressen();

		for (Adresse dg : dtoList) {
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
	public String deleteAdresse(BLAdresse dto) {
		String err = DataManager.getInstance().deleteFormByID(dto.getId(), "adresse");
		if (err == null) {
			dto.setId(0);
		}
		return err;
	}

	/**
	 * Saves the Person based on the given DTO to the Database
	 */
	public String saveAdresse(BLAdresse dto) {
		Adresse dg = new Adresse(dto.getPlz(), dto.getStadt(), dto.getStrasse(), dto.getHaus());
		String err = DataManager.getInstance().save(dg);
		return err;
	}
	

	/**
	 *  loads the Person from the DataManager and transforms it
	 * 
	 * @return
	 */
	public BLPersonFormular loadByIDPerson(int id) {
		Person p = DataManager.getInstance().loadById(id, Person.class);
		if (p != null) {
			Adresse adr = p.getAdresse();
			Gender g = p.getGender();
			BLPersonFormular blp = new BLPersonFormular(p.getName(), p.getVorname(), p.getGebdat(),g.getId(),adr.getPlz(), adr.getStadt(), adr.getStrasse(), adr.getHaus());
			blp.id = p.getId();
			return blp;
		}
		return null;
	}
	
	/**
	 *  loads the Persons from the DataManager and transforms it
	 * 
	 * @return List of Data to be used
	 */
	public ArrayList<ListData> loadAllPerson() {
		ArrayList<ListData> dataList = new ArrayList<>();
		ArrayList<Person> dtoList = DataManager.getInstance().getAllPerson();

		for (Person dp : dtoList) {
			ListData ld = new ListData();
			ld.id = dp.getId();
			ld.title = dp.getName() + ", " + dp.getVorname();

			dataList.add(ld);
		}
		return dataList;
	}

	/**
	 * Deletes a person based on the person given 
	 * @param form
	 * @return
	 */
	public String deletePerson(BLPerson dto) {
		String err = DataManager.getInstance().deleteFormByID(dto.getId(), "gender");
		
		if (err == null) {
			dto.setId(0);
		}
		return err;
	}

	/**
	 * Saves the Person based on the given DTO to the Database
	 */
	public String savePerson(BLPersonFormular dto) {
		Gender dg = DataManager.getInstance().loadById(dto.getGender_id(), Gender.class);
		Adresse dadr = new Adresse(dto.getPlz(), dto.getStadt(), dto.getStrasse(), dto.getHausnr());
		Person dp = new Person(dto.getName(), dto.getVorname(), dto.getGebdat(),dg,dadr);
		String err = DataManager.getInstance().savePerson(dp);
		if (err != null) {
			return err;
		}
		return null;
	}
}
