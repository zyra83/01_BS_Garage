package garage.model.facade;

public final class FacadeFactory {
	public FacadeFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static IFacadeMetier fabriquerFacadeMetier(){
		return new FacadeMetier();
	}
}
