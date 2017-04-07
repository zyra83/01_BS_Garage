package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import garage.model.dao.DaoFactory;
import garage.model.dao.exceptions.DaoException;
import garage.model.entities.Marque;

public class TestMarqueDaoJPA {

	public static final Log LOG = LogFactory.getLog(TestMarqueDaoJPA.class.getSimpleName());
	List<Marque> readAll;
	
	@Before
	public void init() throws DaoException {
		DaoFactory.fabriquerDaoMarque().create(new Marque("test1"));
		DaoFactory.fabriquerDaoMarque().create(new Marque("test2"));
		
		EntityManager em = Persistence.createEntityManagerFactory("01BS_Garage").createEntityManager();
		em.getTransaction().begin();
		em.createNativeQuery("INSERT INTO MARQUE VALUES ('b1336692-13b2-11e7-93ae-92361f002671', 'YOLO');").executeUpdate();
		em.getTransaction().commit();
	}

	@After
	public void post() throws Exception {
		EntityManager em = Persistence.createEntityManagerFactory("01BS_Garage").createEntityManager();
		em.getTransaction().begin();
		em.createNativeQuery("DELETE FROM MARQUE WHERE id != '';").executeUpdate();
		em.getTransaction().commit();
	}

	@Test
	public void testReadAll() throws DaoException {
		readAll = DaoFactory.fabriquerDaoMarque().readAll();
		for (Marque marque : readAll) {
			LOG.info(marque.getId());
		}
		Assert.assertEquals(3, readAll.size());
	}

	@Test
	public void testReadOneById() throws DaoException {
		Marque m = DaoFactory.fabriquerDaoMarque().read("b1336692-13b2-11e7-93ae-92361f002671");
		Assert.assertEquals("YOLO", m.getNom());
	}

}
