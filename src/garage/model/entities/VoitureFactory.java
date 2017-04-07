package garage.model.entities;

import java.time.LocalDate;

public final class VoitureFactory {
	private VoitureFactory() {
		// TODO Auto-generated constructor stub
	}

	public static Voiture fabriquerVoiture(String modele, String immatriculation, int puissance, LocalDate mec,
			Marque marque) {
		return fabriquerVoiture(modele, immatriculation, puissance, mec, marque);
	}

}
