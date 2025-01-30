package bl;

import java.util.ArrayList;

import data.DataManager;
import data.pengugit.entities.Adresse;
import data.pengugit.entities.Gender;
import data.pengugit.entities.Person;

public class DTOManager {

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
	public BLPerson loadByIDPerson(int id) {
		Person p = DataManager.getInstance().loadById(id, Person.class);
		if (p != null) {
			Adresse adr = p.getAdresse();
			Gender g = p.getGender();
			BLGender blg = new BLGender(g.getId(),g.getKuerzel(),g.getInfo());
			BLAdresse bladr = new BLAdresse(adr.getId(), adr.getPlz(), adr.getStadt(), adr.getStrasse(), adr.getHaus());
			BLPerson blp = new BLPerson(p.getId(), p.getName(), p.getVorname(), p.getGebdat(),blg,bladr);
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
	public String savePerson(BLPerson dto) {
		BLAdresse adr = dto.getAdresse();
		BLGender g = dto.getGender();
		Gender dg = new Gender(g.getId(),g.getKuerzel(),g.getInfo());
		Adresse dadr = new Adresse(adr.getId(), adr.getPlz(), adr.getStadt(), adr.getStrasse(), adr.getHaus());
		Person dp = new Person(dto.getId(), dto.getName(), dto.getVorname(), dto.getGebdat(),dg,dadr);
		String err = DataManager.getInstance().savePerson(dp);
		if (err != null) {
			return err;
		}
		return null;
	}
}
