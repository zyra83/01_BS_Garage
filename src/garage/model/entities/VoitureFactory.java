package garage.model.entities;

import java.time.LocalDate;
import java.util.UUID;

public final class VoitureFactory {
	private VoitureFactory() {
		// TODO Auto-generated constructor stub
	}

	public static Voiture fabriquerVoiture(String modele, String immatriculation, int puissance, LocalDate mec) {
		return fabriquerVoiture(UUID.randomUUID(), modele, immatriculation, puissance, mec);
	}

	public static Voiture fabriquerVoiture(UUID uuid, String modele, String immatriculation, int puissance,
			LocalDate mec) {
		Voiture retour = new Voiture(uuid, mec, modele, puissance, immatriculation);
		return retour;
	}

}
