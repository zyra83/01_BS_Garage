package garage.model.dao.jpa;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import garage.model.dao.DaoMarque;
import garage.model.dao.JPAUtils;
import garage.model.dao.exceptions.DaoException;
import garage.model.entities.Marque;

public class DaoMarqueJPA implements DaoMarque<Marque, String> {
	private static final EntityManager em = JPAUtils.getEm("01BS_Garage");

	@Override
	public Marque read(String k) throws DaoException {
		try {
			return em.find(Marque.class, UUID.fromString(k));
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
	}

	@Override
	public void create(Marque k) throws DaoException {
		em.getTransaction().begin();
		em.persist(k);
		em.getTransaction().commit();
	}

	@Override
	public List<Marque> readAll() throws DaoException {
		try {
			TypedQuery<Marque> m = em.createQuery("SELECT m FROM Marque m", Marque.class);
			return m.getResultList();
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
	}

}
