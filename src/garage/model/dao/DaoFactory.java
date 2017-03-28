package garage.model.dao;

import garage.model.dao.jdbc.DaoMarqueJdbc;
import garage.model.dao.jdbc.DaoVoitureJdbc;
import garage.model.entities.Marque;
import garage.model.entities.Voiture;

public final class DaoFactory {
	private DaoFactory() {
		// TODO Auto-generated constructor stub
	}

	public static DaoVoiture<Voiture, String> fabriquerDaoVoiture() {
		return new DaoVoitureJdbc();
	}

	public static DaoMarque<Marque, String> fabriquerDaoMarque() {
		return new DaoMarqueJdbc();
	}
}
