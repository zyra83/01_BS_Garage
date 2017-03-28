package garage.model.entities;

import java.util.UUID;

public final class MarqueFactory {
	private MarqueFactory() {
		// TODO Auto-generated constructor stub
	}

	public static Marque fabriquerMarque(String nom) {
		return fabriquerMarque(UUID.randomUUID(), nom);
	}

	public static Marque fabriquerMarque(UUID uuid, String nom) {
		Marque retour = new Marque(uuid, nom);
		return retour;
	}

}
