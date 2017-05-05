package garage.presenter;

import garage.model.dao.exceptions.DaoException;
import garage.model.entities.Marque;
import garage.model.entities.Voiture;
import garage.model.facade.FacadeFactory;
import garage.model.facade.IFacadeMetier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
public class CreationPresenter {

	IFacadeMetier fm = FacadeFactory.fabriquerFacadeMetier();

	@FXML
	private VBox racine;

	@FXML
	private TextField tfImmat;

	@FXML
	private ComboBox<Marque> cbMarque;

	@FXML
	private TextField tfModele;

	@FXML
	private Label lPuissance;

	@FXML
	private Slider sPuissance;

	@FXML
	private DatePicker dpMec;

	@FXML
	private Button btnValider;

	@FXML
	private Voiture nouvelleVoiture = new Voiture();

	@FXML
	public void initialize() {
		if (log.isInfoEnabled())
			log.info(String.format("initialize, binding, chargement metier"));

		// Bind la liste de voitures au tableau
		try {
			this.cbMarque.getItems().addAll(fm.listerLesMarques());
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.sPuissance.valueProperty().addListener((obs, oldval, newVal) ->
		this.sPuissance.setValue(Math.round(newVal.doubleValue())));
		// écoute le changement de valeur du slider
		this.sPuissance.valueProperty().addListener((arg0, arg1, arg2) -> {
			this.lPuissance.textProperty().setValue(String.format("Puissance: %s hp", Math.round(arg2.intValue())));
		});
		

		this.btnValider.addEventHandler(ActionEvent.ACTION, (evt) -> {
			if (log.isInfoEnabled())
				log.info(String.format("click sur le bouton"));

		});

	}

}