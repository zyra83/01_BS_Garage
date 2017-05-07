package garage.presenter;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
public class BarreMenuPresenter {

	@FXML
	private HBox racine;

	@FXML
	public void listerVoitures() {
		// Demander le chargement du FXML de la vue Lister
		try {
			VBox vueLister = (VBox) FXMLLoader.load(getClass().getResource("/garage/view/fx/ListeVoitures.fxml"));

			// Recuperer une reference de la scene et changer le graphe de scene
			Scene scene = racine.getScene();
			scene.setRoot(vueLister);

		} catch (IOException e) {
			log.error(e.getMessage(), e);
			Alert a = new Alert(AlertType.ERROR);
			a.showAndWait();
		}

	}

	@FXML
	public void ajouterVoiture() {
		// Demander le chargement du FXML de la vue Ajouter
		try {

			FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/garage/view/fx/AjouterVoiture.fxml"));
			// TODO Passer une voiture en parametre pour modif
			loader.setController(new CreationPresenter());
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
	public void afficherStats() {
		VBox vueStats;
		try {
			vueStats = (VBox) FXMLLoader.load(getClass().getResource("/garage/view/fx/Statistiques.fxml"));

			// Recuperer une reference de la scene et changer le graphe de scene
			Scene scene = racine.getScene();
			scene.setRoot(vueStats);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	public void infDialAPropos() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText("Copyright");
		alert.setContentText("Made by Jason");
		alert.showAndWait();
	}

	@FXML
	public void quitter() {
		Platform.exit();
	}
}