package garage.model.entities;

public final class MarqueFactory {
	private MarqueFactory() {
		// TODO Auto-generated constructor stub
	}

	public static Marque fabriquerMarque(String nom) {
		Marque retour = new Marque(nom);
		return retour;
	}

}
