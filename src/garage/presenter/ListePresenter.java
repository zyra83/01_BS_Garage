package garage.presenter;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

import garage.model.entities.Voiture;
import garage.model.facade.FacadeFactory;
import garage.model.facade.IFacadeMetier;
import garage.model.facade.exceptions.FacadeMetierException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
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
				"Immatriculation: %s%nModèle: %s%nPuissance: %s%nDate de mise en circulation: %s",
				v.getImmatriculation(), v.getModele(), v.getPuissance(),
				v.getMiseEnCirculation().format(DateTimeFormatter.ofPattern("dd MM YYYY")));

		// Create the custom dialog.
		Dialog<Pair<String, String>> dialog = new Dialog<>();
		dialog.setTitle(String.format("Details pour: %s", v.getModele()));
		dialog.setHeaderText(String.format("Details pour: %s", v.getModele()));

		// Set the icon (must be included in the project).
		dialog.setGraphic(
				new ImageView(this.getClass().getResource("/garage/view/resources/" + "wall" + ".jpg").toString()));

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

	}

	public void supprimer() {
		Voiture v = tvVoitures.getSelectionModel().getSelectedItem();
		try {
			fm.supprimerVoiture(v);
			this.lstVoitures.remove(v);

		} catch (FacadeMetierException e) {
			if (log.isErrorEnabled())
				log.error(e);
		}
	}

	public void modifier() {
		Voiture v = tvVoitures.getSelectionModel().getSelectedItem();
		
		// Demander le chargement du FXML de la vue Ajouter
		try {

			FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/garage/view/fx/AjouterVoiture.fxml"));
			// TODO Passer une voiture en parametre pour modif
			loader.setController(new CreationPresenter(v));
			VBox vueAjouter = (VBox) loader.load();

			// Recuperer une reference de la scene et changer le graphe de scene
			Scene scene = racine.getScene();
			scene.setRoot(vueAjouter);
		} catch (IOException e) {
			Alert a = new Alert(AlertType.ERROR);
			a.setContentText(e.getMessage());
			a.showAndWait();
		}
	}

	@FXML
	public void initialize() {
		if (log.isInfoEnabled())
			log.info(String.format("initialize, binding, chargement metier"));

		// chargement des voitures
		chargerListeVoitures();

		this.tcImmat.setCellValueFactory(new PropertyValueFactory<>("immatriculation"));
		this.tcMarque.setCellValueFactory(new PropertyValueFactory<>("marque"));
		this.tcModele.setCellValueFactory(new PropertyValueFactory<>("modele"));

		// Bind la liste de voitures au tableau
		this.tvVoitures.setItems(lstVoitures);

		// écoute le changement de valeur de la CB.
		cbOrdered.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
			log.info(String.format("Checkbox: old_val:%b, new_val:%b.", wasSelected, isNowSelected));
			if (isNowSelected) {
				chargerListeVoituresParPuissance();
			} else {
				chargerListeVoitures();
			}
		});
		
		
		
		tvVoitures.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		    log.info(newSelection);
		});
		
		
		
	}

	private void chargerListeVoitures() {
		try {
			lstVoitures.setAll(fm.listerLesVoitures());
		} catch (FacadeMetierException e) {
			if (log.isErrorEnabled())
				log.error(e);
			new Alert(AlertType.ERROR, e.getMessage()).showAndWait();
		}
	}

	private void chargerListeVoituresParPuissance() {
		try {
			lstVoitures.setAll(fm.listerLesVoituresParPuissance());
		} catch (FacadeMetierException e) {
			if (log.isErrorEnabled())
				log.error(e);
			new Alert(AlertType.ERROR, e.getMessage()).showAndWait();
		}
	}

}
