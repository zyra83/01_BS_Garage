package test;

import java.time.LocalDate;
import java.util.UUID;

import org.junit.Test;

import garage.model.dao.DaoFactory;
import garage.model.dao.exceptions.DaoException;
import garage.model.entities.Voiture;
import garage.model.entities.VoitureFactory;

public class TestGarage {

	@Test
	public void testUUID() {
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid.toString());

	}


	@Test
	public void testPostIncrement() {
		int i= 1;
		System.out.println(i++);
		System.out.println(i++);
		System.out.println(i++);
		System.out.println(i++);
	}

	@Test
	public void testPreIncrement() {
		int i= 0;
		System.out.println(++i);
		System.out.println(++i);
		System.out.println(++i);
		System.out.println(++i);
	}

	
	@Test
	public void testInsertionBDD() {
		Voiture v = VoitureFactory.fabriquerVoiture("Siroco", "AA-666-BB", 150, LocalDate.now());
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
