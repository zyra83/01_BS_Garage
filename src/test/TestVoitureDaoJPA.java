package test;

import java.time.LocalDate;

import org.junit.Test;

import garage.model.dao.DaoFactory;
import garage.model.dao.exceptions.DaoException;
import garage.model.entities.Marque;
import garage.model.entities.Voiture;
import garage.model.entities.VoitureFactory;

public class TestVoitureDaoJPA {

	@Test
	public void testInsertionBDD() {

		Marque m = null;

		try {
			m = DaoFactory.fabriquerDaoMarque().readAll().get(0);
		} catch (DaoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Voiture v = VoitureFactory.fabriquerVoiture("Siroco 222", "AA-666-BB", 150, LocalDate.now(), m);
		System.out.println(v);
		try {
			DaoFactory.fabriquerDaoVoiture().create(v);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testReadOneById() {

		try {
			Voiture v = DaoFactory.fabriquerDaoVoiture().read("5241f863-8e5b-4707-b48e-f21afb85182f");
			System.out.println(String.valueOf(v));
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testExists() {
		try {
			Voiture v = DaoFactory.fabriquerDaoVoiture().read("5241f863-8e5b-4707-b48e-f21afb85182f");

			boolean exists = DaoFactory.fabriquerDaoVoiture().exist(v);
			System.out.println(String.valueOf(exists));
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
