package garage.model.dao.jdbc;

public final class Requetes {

	/**
	 * select * de la mort
	 */
	public static final String SELECT_ALL_FROM_VOITURE = "SELECT * FROM VOITURE ;";
	public static final String SELECT_ALL_FROM_VOITURE_ORDER_PUISS_ASC = "SELECT * FROM VOITURE ORDER BY puissance_voiture ASC;";
	public static final String INSERT_UNE_VOITURE = "INSERT INTO VOITURE VALUES(?,?,?,?,?);";
	public static final String UPDATE_UNE_VOITURE = "UPDATE `VOITURE` SET "
			+ "`mec_voiture` = ?, `modele_voiture` = ?, `puissance_voiture` = ?, `immat_voiture` = ? "
			+ "WHERE `id_voiture` = ?;";

	public static final String EXISTS_UNE_VOITURE = "SELECT COUNT(*) >= 1 FROM VOITURE WHERE id_voiture LIKE ?;";

	public static final String DELETE_UNE_VOITURE = "DELETE FROM `VOITURE` WHERE id_voiture = ?;";

	private Requetes() {
		// TODO Auto-generated constructor stub
	}
}
