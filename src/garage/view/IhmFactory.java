package garage.view;

/**
 * Fabrique de vues
 * @author nicolas.magniez
 *
 */
public final class IhmFactory {
	
	private IhmFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static Ihm fabriquerIhmConsole(){
		return new IhmPrincipalConsole();
	}
	
	public static Ihm fabriquerIhmGraphique(){
		return new IhmPrincipalGraphique();
	}
}
