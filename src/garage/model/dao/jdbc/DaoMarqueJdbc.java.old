package garage.model.dao.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import garage.model.dao.DaoMarque;
import garage.model.dao.exceptions.DaoException;
import garage.model.entities.Marque;
import utilitaires.DButils;

public class DaoMarqueJdbc implements DaoMarque<Marque, String> {

	/**
	 * Emplacemnt du fichier properties
	 */
	private static final String CONF_BDD_PROPERTIES = "/conf/bdd.properties";

	@Override
	public Marque read(String k) throws DaoException {
		try (Connection connection = DButils.obtenirConnection(CONF_BDD_PROPERTIES)) {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM MARQUE WHERE id_marque = ?;");
			stmt.setObject(1, k, Types.VARCHAR);
			stmt.execute();

			ResultSet resultSet = stmt.getResultSet();
			// je n'utilise que le premier;
			resultSet.next();
			Marque retour = new Marque(UUID.fromString(resultSet.getString(1)), resultSet.getString(2));
			return retour;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Marque> readAll() throws DaoException {
		List<Marque> retour = new ArrayList<>();
		Marque m;
		try (Connection connection = DButils.obtenirConnection(CONF_BDD_PROPERTIES)) {
			Statement stmt = connection.createStatement();
			stmt.execute(Requetes.SELECT_ALL_FROM_MARQUE);

			ResultSet resultSet = stmt.getResultSet();
			while (resultSet.next()) {
				m = new Marque(UUID.fromString(resultSet.getString(1)), resultSet.getString(2));
				retour.add(m);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return retour;
	}

}
