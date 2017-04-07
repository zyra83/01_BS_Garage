package garage.model.dao.jdbc;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import garage.model.dao.DaoVoiture;
import garage.model.dao.exceptions.DaoException;
import garage.model.entities.Voiture;

public class DaoVoitureJPA implements DaoVoiture<Voiture, String> {
	private static final EntityManager em = Persistence.createEntityManagerFactory("01BS_Garage").createEntityManager();
	public static final Log LOG = LogFactory.getLog(DaoVoitureJPA.class.getSimpleName());

	@Override
	public void create(Voiture t) throws DaoException {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
	}

	@Override
	public Voiture read(String k) throws DaoException {
		try {
			return em.find(Voiture.class, UUID.fromString(k));
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
	}

	@Override
	public void delete(Voiture t) throws DaoException {
		try {
			em.getTransaction().begin();
			// TODO ça ça va surement merder vu qu'on est hors contexte de
			// persistance
			em.remove(t);
			em.getTransaction().commit();
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
	}

	@Override
	public void update(Voiture t) throws DaoException {
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
	}

	@Override
	public List<Voiture> readAll() throws DaoException {
		try {
			TypedQuery<Voiture> v = em.createQuery("SELECT v FROM Voiture v", Voiture.class);
			return v.getResultList();
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
	}

	@Override
	public boolean exist(Voiture t) throws DaoException {
		TypedQuery<Boolean> v = em.createQuery("SELECT count(v) > 0 FROM Voiture v WHERE v = ?;", Boolean.class);
		return v.getSingleResult();
	}

	@Override
	public List<Voiture> readByModele(String modele) throws DaoException {
		try {
			TypedQuery<Voiture> v = em.createQuery("SELECT v FROM Voiture v WHERE v.id LIKE ?;", Voiture.class);
			v.setParameter(1, modele);
			return v.getResultList();
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
	}

	@Override
	public List<Voiture> readAllSortByPuissance() throws DaoException {
		try {
			TypedQuery<Voiture> v = em.createQuery("SELECT v FROM Voiture v ORDER BY ", Voiture.class);
			return v.getResultList();
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
	}

}
