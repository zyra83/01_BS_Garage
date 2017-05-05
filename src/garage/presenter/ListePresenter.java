package garage.presenter;

import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import garage.model.dao.exceptions.DaoException;
import garage.model.entities.Voiture;
import garage.model.facade.FacadeFactory;
import garage.model.facade.IFacadeMetier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Pair;
import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
public class ListePresenter {

	IFacadeMetier fm = FacadeFactory.fabriquerFacadeMetier();

	@FXML
	private VBox racine;

	@FXML
	private TableView<Voiture> tvVoitures;

	@FXML
	private TableColumn<Voiture, String> tcImmat;

	@FXML
	private TableColumn<Voiture, String> tcMarque;

	@FXML
	private TableColumn<Voiture, String> tcModele;

	@FXML
	private CheckBox cbOrdered;

	/**
	 * Liste observable : tient la vue au courant de ses ajouts/supression.
	 */
	private ObservableList<Voiture> lstVoitures = FXCollections.observableArrayList();

	public void details() {
		Voiture v = tvVoitures.getSelectionModel().getSelectedItem();
		
		String strDetail = String.format(
				"Immatriculation: %s%n"
				+ "Modèle: %s%n"
				+ "Puissance: %s%n"
				+ "Date de mise en circulation: %s", 
				v.getImmatriculation(),
				v.getModele(),
				v.getPuissance(),
				v.getMiseEnCirculation().format(DateTimeFormatter.ofPattern("dd MM YYYY"))
				);
		
		
		// Create the custom dialog.
		Dialog<Pair<String, String>> dialog = new Dialog<>();
		dialog.setTitle(String.format("Details pour: %s", v.getModele()));
		dialog.setHeaderText(String.format("Details pour: %s", v.getModele()));

		// Set the icon (must be included in the project).
		dialog.setGraphic(new ImageView(
		 		this.getClass().getResource("/garage/view/resources/" + "wall" + ".jpg").toString()));

		// Set the button types.
		dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK);

		// Create the username and password labels and fields.
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));
		grid.add(new Label(strDetail), 0, 0);

		dialog.getDialogPane().setContent(grid);

		dialog.showAndWait();

		if (log.isInfoEnabled())
			log.info(String.format("Détail de la voiture %s.", v.toString()));
	}

	public void supprimer() {
		Voiture v = tvVoitures.getSelectionModel().getSelectedItem();
		Integer index = tvVoitures.getSelectionModel().getSelectedIndex();
		try {
			fm.supprimerVoiture(v);
			this.lstVoitures.remove(v);
		if (log.isInfoEnabled())
			log.info(String.format("Supression de la voiture %s à l'index %s.", v.toString(), index.toString()));
		} catch (DaoException e) {
			log.error(e.getMessage(), e);
		}
	}

	public void modifier() {
		Voiture v = tvVoitures.getSelectionModel().getSelectedItem();
		Integer index = tvVoitures.getSelectionModel().getSelectedIndex();
		// TextInputDialog tid = new TextInputDialog();
		// tid.showAndWait();
		// this.lstVoitures.get(index).setCoef(Integer.parseInt(tid.getResult()));

		if (log.isInfoEnabled())
			log.info(String.format("Edition du coef %s à l'index %s.", v.toString(), index.toString()));
	}

	@FXML
	public void initialize() {
		if (log.isInfoEnabled())
			log.info(String.format("initialize, binding, chargement metier"));

		// chargement des voitures
		r1();

		this.tcImmat.setCellValueFactory(new PropertyValueFactory<>("immatriculation"));
		this.tcMarque.setCellValueFactory(new PropertyValueFactory<>("marque"));
		this.tcModele.setCellValueFactory(new PropertyValueFactory<>("modele"));

		// Bind la liste de voitures au tableau
		this.tvVoitures.setItems(lstVoitures);

		// écoute le changement de valeur de la CB.
		cbOrdered.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
			log.info(String.format("Checkbox: old_val:%b, new_val:%b.", wasSelected, isNowSelected));
			if (isNowSelected) {
				r2();
			} else {
				r1();
			}
		});

	}

	private void r1() {
		try {
			lstVoitures.setAll(fm.listerLesVoitures());
			if (log.isInfoEnabled())
				log.info("Voitures ramenées : " + lstVoitures.size());
		} catch (DaoException e) {
			log.error(e.getMessage(), e);
		}
	}

	private void r2() {
		try {
			lstVoitures.setAll(fm.listerLesVoituresParPuissance());
			if (log.isInfoEnabled())
				log.info("Voitures ramenées par puissance : " + lstVoitures.size());
		} catch (DaoException e) {
			log.error(e.getMessage(), e);
		}
	}

}
