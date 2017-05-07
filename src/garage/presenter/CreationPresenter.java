package garage.presenter;

import garage.model.entities.Marque;
import garage.model.entities.Voiture;
import garage.model.entities.VoitureFactory;
import garage.model.facade.FacadeFactory;
import garage.model.facade.IFacadeMetier;
import garage.model.facade.exceptions.FacadeMetierException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
	private Voiture ev;

	public CreationPresenter() {
	}

	public CreationPresenter(Voiture v) {
		ev = v;
	}

	@FXML
	public void initialize() {
		// Bind la liste de voitures au tableau
		try {
			this.cbMarque.getItems().addAll(fm.listerLesMarques());
		} catch (FacadeMetierException e) {
			if (log.isErrorEnabled())
				log.error(String.format(e.getMessage()));
		}

		// Met des valeurs arrondies dans le slider
		this.sPuissance.valueProperty()
				.addListener((obs, oldval, newVal) -> this.sPuissance.setValue(Math.round(newVal.doubleValue())));
		// change le libellé de puissance en même temps que le slider bouge
		this.sPuissance.valueProperty().addListener((arg0, arg1, arg2) -> {
			this.lPuissance.textProperty().setValue(String.format("Puissance: %s hp", Math.round(arg2.intValue())));
		});

		// 
		if (ev != null) {
			tfImmat.setText(ev.getImmatriculation());
			cbMarque.setValue(ev.getMarque());
			tfModele.setText(ev.getModele());
			sPuissance.setValue((double) ev.getPuissance());
			dpMec.setValue(ev.getMiseEnCirculation());
			this.btnValider.setText("Modifier");
		} else {
			this.btnValider.setText("Créer");
		}

	}

	public void sauvegarder() {
		try {
			if (ev != null) {
				ev.setImmatriculation(tfImmat.getText());
				ev.setMarque(cbMarque.getValue());
				ev.setModele(tfModele.getText());
				ev.setPuissance(((Double) sPuissance.getValue()).intValue());
				ev.setMiseEnCirculation(dpMec.getValue());
				fm.mettreAjourUneVoiture(ev);
			} else {
				Voiture v = VoitureFactory.fabriquerVoiture(tfModele.getText(), tfImmat.getText(),
						((Double) sPuissance.getValue()).intValue(), dpMec.getValue(), cbMarque.getValue());
				fm.mettreAjourUneVoiture(v);
			}

		} catch (Exception e) {
			log.error(e.getMessage());
			new Alert(AlertType.ERROR, e.getMessage());
		}
	}

}