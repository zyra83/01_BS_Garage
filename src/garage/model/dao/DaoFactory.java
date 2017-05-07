package garage.model.dao;

import garage.model.dao.jpa.DaoMarqueJPA;
import garage.model.dao.jpa.DaoVoitureJPA;

public final class DaoFactory {
	private DaoFactory() {
		// TODO Auto-generated constructor stub
	}

	public static DaoVoiture fabriquerDaoVoiture() {
		return new DaoVoitureJPA();
	}

	public static DaoMarque fabriquerDaoMarque() {
		return new DaoMarqueJPA();
	}
}
