package garage;

import garage.model.facade.IFacadeMetier;
import garage.model.facade.FacadeFactory;
import garage.presenter.PresenterPrincipal;
import garage.view.Ihm;
import garage.view.IhmFactory;

public class Lanceur {

	public static void main(String[] args) {
		IFacadeMetier fm = FacadeFactory.fabriquerFacadeMetier();
		Ihm ihm = IhmFactory.fabriquerIhmConsole();
		PresenterPrincipal prez = new PresenterPrincipal(fm, ihm);
		prez.executer();
	}

}
