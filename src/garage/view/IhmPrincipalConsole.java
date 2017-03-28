package garage.view;

import java.time.LocalDate;
import java.util.List;

import garage.model.entities.Voiture;
import view.utils.LectureConsole;

public class IhmPrincipalConsole implements Ihm {

	@Override
	public int afficherMenu() {
		System.out.println("\n\n");
		for (String string : MENU_PRINCIPAL) {
			System.out.println(string);
		}

		return LectureConsole.saisirEntier(0, MENU_PRINCIPAL.length);
	}

	@Override
	public void afficher(String message) {
		System.out.println(message);
	}

	@Override
	public Voiture saisirNouvelleVoiture() {
		Voiture retour = new Voiture();

		LectureConsole.afficherMessageAvecSautLigne("Immatriculation :");
		retour.setImmatriculation(LectureConsole.saisirChaine());

		LectureConsole.afficherMessageAvecSautLigne("Modèle :");
		retour.setModele(LectureConsole.saisirChaine());

		retour.setMiseEnCirculation(LocalDate.now());

		LectureConsole.afficherMessageAvecSautLigne("Puissance :");
		retour.setPuissance(LectureConsole.saisirEntier());
		
		return retour;
	}

	@Override
	public void afficherVoitures(List<Voiture> plstVoitures) {
		for (Voiture voiture : plstVoitures) {
			afficherUneVoiture(voiture);
		}
	}

	@Override
	public void afficherUneVoiture(Voiture v) {
		System.out.println(v.toString());
	}

	@Override
	public Voiture choisirVoiture(List<Voiture> plstVoitures) {
		for (Voiture voiture : plstVoitures) {
			System.out.print(plstVoitures.indexOf(voiture)); 
			afficherUneVoiture(voiture);
		}
		LectureConsole.afficherMessageAvecSautLigne("Choisissez un numéro de voiture :");
		return plstVoitures.get(LectureConsole.saisirEntier());
	}

	@Override
	public String rechercherVoitureModele() {
		LectureConsole.afficherMessageAvecSautLigne("Tapez le modele de la voiture (meme partiel) :");
		return LectureConsole.saisirChaine();
	}

	@Override
	public Voiture modifierVoiture(Voiture vmodif) {
		LectureConsole.afficherMessageAvecSautLigne("Immatriculation :");
		vmodif.setImmatriculation(LectureConsole.saisirChaine());

		LectureConsole.afficherMessageAvecSautLigne("Modèle :");
		vmodif.setModele(LectureConsole.saisirChaine());

		vmodif.setMiseEnCirculation(LocalDate.now());

		LectureConsole.afficherMessageAvecSautLigne("Modèle :");
		vmodif.setPuissance(LectureConsole.saisirEntier());

		return vmodif;
	}

}
