package garage.model.dao;

import garage.model.dao.jdbc.DaoVoitureJdbc;
import garage.model.entities.Voiture;

public final class DaoFactory {
	private DaoFactory() {
		// TODO Auto-generated constructor stub
	}

	public static DaoVoiture<Voiture, String> fabriquerDaoVoiture() {
		return new DaoVoitureJdbc();
	}
}
