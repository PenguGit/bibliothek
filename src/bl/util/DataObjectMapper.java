package bl.util;

import bl.BLAdresse;
import bl.BLGender;
import bl.BLPerson;
import data.pengugit.entities.Adresse;
import data.pengugit.entities.Gender;
import data.pengugit.entities.Person;

public class DataObjectMapper {
	public static BLPerson convertPersonToDTO(Person dao) {
		return new BLPerson(dao.getId(), dao.getName(), dao.getVorname(), dao.getGebdat(),
				convertGenderToDTO(dao.getGender()), convertAddressToDTO(dao.getAdresse()));
	}

	public static Person convertPersonToDAO(BLPerson dto) {
		return new Person(dto.getId(), dto.getName(), dto.getVorname(), dto.getGebdat(),
				convertGenderToDAO(dto.getGender()), convertAddressToDAO(dto.getAdresse()));
	}

	public static BLGender convertGenderToDTO(Gender dao) {
		return new BLGender(dao.getId(), dao.getKuerzel(), dao.getInfo());
	}

	public static Gender convertGenderToDAO(BLGender dto) {
		return new Gender(dto.getId(), dto.getKuerzel(), dto.getInfo());
	}

	public static BLAdresse convertAddressToDTO(Adresse dao) {
		return new BLAdresse(dao.getId(), dao.getPlz(), dao.getStadt(), dao.getStrasse(), dao.getHaus());
	}

	public static Adresse convertAddressToDAO(BLAdresse dto) {
		return new Adresse(dto.getId(), dto.getPlz(), dto.getStadt(), dto.getStrasse(), dto.getHaus());
	}

//	public static GenreDTO convertGenreToDTO(GenreDAO dao) {
//		return new GenreDTO(dao.getId(), dao.getName(), dao.getType());
//	}
//
//	public static GenreDAO convertGenreToDAO(GenreDTO dto) {
//		return new GenreDAO(dto.getId(), dto.getName(), dto.getType());
//	}
//
//	public static BookDTO convertBookToDTO(BookDAO dao) {
//		return new BookDTO(dao.getId(), dao.getIsbn(), dao.getTitle(), dao.getAuthor(), dao.getPublisher(),
//				convertGenreToDTO(dao.getGenre()));
//	}
//
//	public static BookDAO convertBookToDAO(BookDTO dto) {
//		return new BookDAO(dto.getId(), dto.getIsbn(), dto.getTitle(), dto.getAuthor(), dto.getPublisher(),
//				convertGenreToDAO(dto.getGenre()));
//	}
}
