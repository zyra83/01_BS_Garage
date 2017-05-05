package garage.model.facade;

public final class FacadeFactory {

	private FacadeFactory() {
	}

	public static IFacadeMetier fabriquerFacadeMetier() {
		return new FacadeMetier();
	}
}
