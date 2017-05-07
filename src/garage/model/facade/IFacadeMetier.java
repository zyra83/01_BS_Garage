package garage.model.facade;

import java.util.List;

import garage.model.entities.Marque;
import garage.model.entities.Voiture;
import garage.model.facade.exceptions.FacadeMetierException;

public interface IFacadeMetier {

	/**
	 * 1ere fonctionnalité: menu 1 : ajouter une voiture
	 * @param v : Voiture
	 * @throws FacadeMetierException 
	 */
	void creerVoiture(Voiture v) throws FacadeMetierException;

	/**
	 * 2eme fonctionnalité: menu 2 : supprimer une voiture
	 * @param v
	 * @throws FacadeMetierException 
	 */
	void supprimerVoiture(Voiture v) throws FacadeMetierException;

	/**
	 * 3 eme fonctionnalité: lister toutes les voitures( select * from voiture)
	 * @return
	 * @throws FacadeMetierException 
	 */
	List<Voiture> listerLesVoitures() throws FacadeMetierException;

	/**
	 * 4 eme fonctionnalité  : lister les voitures triées par puissance
	 * @return: liste de voitures triées par puissance
	 * @throws FacadeMetierException 
	 */
	List<Voiture> listerLesVoituresParPuissance() throws FacadeMetierException;
	
	/**
	 * 5 eme fonctionnalité: rechercher( par saisie du modèle) une /des voitures et afficher les détails
	 * @param recherche
	 * @return List<Voiture>
	 * @throws FacadeMetierException 
	 */
	List<Voiture> rechercherVoiture(String recherche) throws FacadeMetierException;

	/**
	 * 6 eme fonctionnalité :  Mettre à jour les caractéristiques d'une voiture en base de données
	 * @param v : la voiture a modifier
	 * @throws FacadeMetierException 
	 */
	void mettreAjourUneVoiture(Voiture v) throws FacadeMetierException;

	List<Marque> listerLesMarques() throws FacadeMetierException;

	long compterVoituresParMarque(Marque marque);

	
}