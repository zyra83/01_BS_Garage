package garage.model.dao.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import garage.model.dao.DaoVoiture;
import garage.model.dao.exceptions.DaoException;
import garage.model.entities.Voiture;
import utilitaires.DButils;

public class DaoVoitureJdbc implements DaoVoiture<Voiture, String> {

	/**
	 * Emplacemnt du fichier properties
	 */
	private static final String CONF_BDD_PROPERTIES = "/conf/bdd.properties";

	@Override
	public void create(Voiture t) throws DaoException {
		try (Connection connection = DButils.obtenirConnection(CONF_BDD_PROPERTIES)) {
			PreparedStatement stmt = connection.prepareStatement(Requetes.INSERT_UNE_VOITURE);

			stmt.setObject(1, t.getId(), Types.VARCHAR);
			stmt.setObject(2, t.getMiseEnCirculation(), Types.DATE);
			stmt.setObject(3, t.getModele(), Types.VARCHAR);
			stmt.setObject(4, t.getPuissance(), Types.INTEGER);
			stmt.setObject(5, t.getImmatriculation(), Types.VARCHAR);

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	@Override
	public Voiture read(String k) throws DaoException {
		try (Connection connection = DButils.obtenirConnection(CONF_BDD_PROPERTIES)) {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM VOITURE WHERE id_voiture = ?;");
			stmt.setObject(1, k, Types.VARCHAR);
			stmt.execute();

			ResultSet resultSet = stmt.getResultSet();
			// je n'utilise que le premier;
			resultSet.next();
			Voiture retour = new Voiture(UUID.fromString(resultSet.getString(1)),
					LocalDate.parse(resultSet.getString(2), DateTimeFormatter.ISO_LOCAL_DATE), resultSet.getString(3),
					resultSet.getInt(4), resultSet.getString(5));
			return retour;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(Voiture t) throws DaoException {
		try (Connection connection = DButils.obtenirConnection(CONF_BDD_PROPERTIES)) {
			PreparedStatement stmt = connection.prepareStatement(Requetes.INSERT_UNE_VOITURE);

			stmt.setObject(1, t.getId(), Types.VARCHAR);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void update(Voiture t) throws DaoException {
		// TODO Auto-generated method stub
		try (Connection connection = DButils.obtenirConnection(CONF_BDD_PROPERTIES)) {
			PreparedStatement stmt = connection.prepareStatement(Requetes.UPDATE_UNE_VOITURE);
			int i = 1;
			stmt.setObject(i++, t.getMiseEnCirculation(), Types.DATE);
			stmt.setObject(i++, t.getModele(), Types.VARCHAR);
			stmt.setObject(i++, t.getPuissance(), Types.INTEGER);
			stmt.setObject(i++, t.getImmatriculation(), Types.VARCHAR);
			stmt.setObject(i++, t.getId(), Types.VARCHAR);

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public List<Voiture> readAll() throws DaoException {
		List<Voiture> retour = new ArrayList<>();
		Voiture v;
		try (Connection connection = DButils.obtenirConnection(CONF_BDD_PROPERTIES)) {
			Statement stmt = connection.createStatement();
			stmt.execute(Requetes.SELECT_ALL_FROM_VOITURE);

			ResultSet resultSet = stmt.getResultSet();
			while (resultSet.next()) {
				v = new Voiture(UUID.fromString(resultSet.getString(1)),
						LocalDate.parse(resultSet.getString(2), DateTimeFormatter.ISO_LOCAL_DATE),
						resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5));
				retour.add(v);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return retour;
	}

	@Override
	public boolean exist(Voiture t) throws DaoException {
		if (read(t.getId().toString()) != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Voiture> readByModele(String modele) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Voiture> readAllSortByPuissance() {
		List<Voiture> retour = new ArrayList<>();
		Voiture v;
		try (Connection connection = DButils.obtenirConnection(CONF_BDD_PROPERTIES)) {
			Statement stmt = connection.createStatement();
			stmt.execute(Requetes.SELECT_ALL_FROM_VOITURE_ORDER_PUISS_ASC);

			ResultSet resultSet = stmt.getResultSet();
			while (resultSet.next()) {
				v = new Voiture(UUID.fromString(resultSet.getString(1)),
						LocalDate.parse(resultSet.getString(2), DateTimeFormatter.ISO_LOCAL_DATE),
						resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5));
				retour.add(v);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return retour;
	}

}
