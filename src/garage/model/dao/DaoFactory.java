package garage.model.dao;

import garage.model.dao.jdbc.DaoMarqueJPA;
import garage.model.dao.jdbc.DaoVoitureJPA;
import garage.model.entities.Marque;
import garage.model.entities.Voiture;

public final class DaoFactory {
	private DaoFactory() {
		// TODO Auto-generated constructor stub
	}

	public static DaoVoiture<Voiture, String> fabriquerDaoVoiture() {
		return new DaoVoitureJPA();
	}

	public static DaoMarque<Marque, String> fabriquerDaoMarque() {
		return new DaoMarqueJPA();
	}
}
