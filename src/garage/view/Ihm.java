package garage.view;

import java.util.List;

import garage.model.entities.Voiture;
/**
 * Interface qu'implementeront les classes d'affichage
 * @author nicolas.magniez
 *
 */
public interface Ihm {
	
	final static String[] MENU_PRINCIPAL ={
			"######################\n ## Le garage ##\n #####################\n"
					+"1- Ajouter une voiture",
					"2- Supprimer une voiture",
					"3- Lister les voitures",
					"4- Lister les voitures par puissance",
					"5- Mettre a jour une voiture",
					"6- Rechercher une voiture (par saisie du modèle)" ,
	"0- Quitter"};

	/**
	 * Affiche le menu ci-dessus et fais saisir un nombre compris entre 0 et le nombre de fonctionnalités proposées.
	 * @return int : l'entier choisi.
	 */
	int afficherMenu();

	/**
	 * Affiche un message passé en paramètre.
	 * @param message
	 */	
	void afficher(String message);

	/**
	 * Fais saisir l'ensemble des caracteristiques d'une voiture:immat, modele,puissance,mec
	 *  et demande son instanciation ala factory de voitures
	 * @return Voiture
	 */
	Voiture saisirNouvelleVoiture();

	/**
	 * Affiche toutes les voitures de la persistence ss la forme:
	 * 944 GT immatriculée CE-698-LK de 225 ch mise en circu. le 10/12/1984 
	 * A3 immatriculée AS-987-KL de 154 ch mise en circu. le 10/10/2008 
	 * C4 immatriculée BT-654-JK de 110 ch mise en circu. le 12/05/2010 
	 * @param plstVoitures
	 */
	void afficherVoitures(List<Voiture> plstVoitures);

	/**
	 * Affiche UNE voiture sous la forme:
	 * 944 GT immatriculée CE-698-LK de 225 ch mise en circu. le 10/12/1984 
	 * @param v : la viture a afficher
	 */
	void afficherUneVoiture(Voiture v);	

	/**
	 * Fais choisir une voiture parmi les voitures de la persistence : 
	 * 1- 944 GT immatriculée CE-698-LK de 225 ch mise en circu. le 10/12/1984 
	 * 2- A3 immatriculée AS-987-KL de 154 ch mise en circu. le 10/10/2008 
	 * 3- C4 immatriculée BT-654-JK de 110 ch mise en circu. le 12/05/2010 
	 * Choisir entre 1 et 3
	 * @param plstVoitures
	 * @return la voiture correspondant a l'entier choisi
	 */
	Voiture choisirVoiture(List<Voiture> plstVoitures);

	/**
	 * Fais saisir le modele recherché exemple:
	 * Quel modèle recherchez-vous?
	 * @return String; le modele recherché (recherche lache: %modele%)
	 */
	String rechercherVoitureModele();	

	/**
	 * Faire choisir une voiture parmi les voitures et demander les nouvelles valeurs des attributs modele, puissance et mec:	
	 * Saisir le nouveau modele:
	 * A3 Sportback
	 * Saisir la nouvelle puissance:
	 * 195
	 * Saisir nouvelle date de mise en circulation(dd/MM/yyyy):
	 * 10/10/2009
	 * @param vmodif
	 * @return la voiture modifiee
	 */
	Voiture modifierVoiture(Voiture vmodif);

}
