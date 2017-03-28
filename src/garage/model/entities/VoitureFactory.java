package garage.model.entities;

import java.time.LocalDate;
import java.util.UUID;

public final class VoitureFactory {
	private VoitureFactory() {
		// TODO Auto-generated constructor stub
	}

	public static Voiture fabriquerVoiture(String modele, String immatriculation, int puissance, LocalDate mec, Marque marque) {
		return fabriquerVoiture(UUID.randomUUID(), modele, immatriculation, puissance, mec, marque);
	}

	public static Voiture fabriquerVoiture(UUID uuid, String modele, String immatriculation, int puissance,
			LocalDate mec, Marque marque) {
		Voiture retour = new Voiture(uuid, mec, modele, puissance, immatriculation, marque);
		return retour;
	}

}
