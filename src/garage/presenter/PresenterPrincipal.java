package garage.presenter;

import garage.model.facade.IFacadeMetier;
import garage.view.Ihm;

public class PresenterPrincipal {

	private IFacadeMetier fm;
	private Ihm ihm;

	public PresenterPrincipal(IFacadeMetier fm, Ihm ihm) {
		this.fm = fm;
		this.ihm = ihm;
	}

	public void executer() {
		int choix = -1;
		while (true && choix != 0) {
			
			choix = ihm.afficherMenu();

			try {

				switch (choix) {

				case 1: // Ajouter une voiture
					fm.creerVoiture(ihm.saisirNouvelleVoiture());
				case 2: // Supprimer une voiture
					fm.supprimerVoiture(ihm.choisirVoiture(fm.listerLesVoitures()));
					break;
				case 3: // Lister les voitures
					ihm.afficherVoitures(fm.listerLesVoitures());
					break;
				case 4: // Lister les voitures par puissance
					ihm.afficherVoitures(fm.listerLesVoituresParPuissance());
					break;
				case 5: // Mettre a jour une voiture
					ihm.afficher("mettre à jour une voiture par son numéro immat partiel :");
					fm.mettreAjourUneVoiture(ihm.modifierVoiture(ihm.choisirVoiture(fm.listerLesVoitures())));
					break;
				case 6: // Rechercher une voiture (par saisie du modèle)
					ihm.afficher("Rechercher une voiture par modèle, saisir le modèle");
					ihm.rechercherVoitureModele();
					break;
				case 0: // quitter
					System.exit(0);
					break;
				default:
					break;
				}

			} catch (Exception e) {
				ihm.afficher(e.getMessage());
			}
		}
	}

}
