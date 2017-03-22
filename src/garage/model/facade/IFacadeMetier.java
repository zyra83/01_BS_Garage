package garage.model.facade;

import java.util.List;

import garage.model.dao.exceptions.DaoException;
import garage.model.entities.Voiture;

public interface IFacadeMetier {

	/**
	 * 1ere fonctionnalité: menu 1 : ajouter une voiture
	 * @param v : Voiture
	 * @throws DaoException 
	 */
	void creerVoiture(Voiture v) throws DaoException;

	/**
	 * 2eme fonctionnalité: menu 2 : supprimer une voiture
	 * @param v
	 * @throws DaoException 
	 */
	void supprimerVoiture(Voiture v) throws DaoException;

	/**
	 * 3 eme fonctionnalité: lister toutes les voitures( select * from voiture)
	 * @return
	 * @throws DaoException 
	 */
	List<Voiture> listerLesVoitures() throws DaoException;

	/**
	 * 4 eme fonctionnalité  : lister les voitures triées par puissance
	 * @return: liste de voitures triées par puissance
	 * @throws DaoException 
	 */
	List<Voiture> listerLesVoituresParPuissance() throws DaoException;
	
	/**
	 * 5 eme fonctionnalité: rechercher( par saisie du modèle) une /des voitures et afficher les détails
	 * @param recherche
	 * @return List<Voiture>
	 * @throws DaoException 
	 */
	List<Voiture> rechercherVoiture(String recherche) throws DaoException;

	/**
	 * 6 eme fonctionnalité :  Mettre à jour les caractéristiques d'une voiture en base de données
	 * @param v : la voiture a modifier
	 * @throws DaoException 
	 */
	void mettreAjourUneVoiture(Voiture v) throws DaoException;

	

}