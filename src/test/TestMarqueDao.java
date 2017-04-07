package test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import garage.model.dao.DaoFactory;
import garage.model.dao.exceptions.DaoException;
import garage.model.entities.Marque;

public class TestMarqueDao {
	// MEP logger
	
	
	@Test
	public void testReadAll() throws DaoException {
		List<Marque> readAll = DaoFactory.fabriquerDaoMarque().readAll();
		Assert.assertEquals(3, readAll.size());
	}

	@Test
	public void testReadOneById() throws DaoException {
		Marque m = DaoFactory.fabriquerDaoMarque().read("b1336692-13b2-11e7-93ae-92361f002671");
		Assert.assertEquals("b1336692-13b2-11e7-93ae-92361f002671", m.getId().toString());
		Assert.assertEquals("Renault", m.getNom());
	}

}
