package garage.presenter;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class StatsPresenter {

	@FXML
	private HBox racine;

	@FXML
	public void listerVoitures() {
		// Demander le chargement du FXML de la vue Lister
		try {
			AnchorPane vueLister = (AnchorPane) FXMLLoader
					.load(getClass().getResource("/garage/view/fx/ListerVoitures.fxml"));

			// Recuperer une reference de la scene et changer le graphe de scene
			Scene scene = racine.getScene();
			scene.setRoot(vueLister);

		} catch (IOException e) {
			System.out.println(e);
			Alert a = new Alert(AlertType.ERROR);
			a.showAndWait();
		}

	}

	@FXML
	public void ajouterVoiture() {
		// Demander le chargement du FXML de la vue Ajouter
		try {
			GridPane vueAjouter = (GridPane) FXMLLoader
					.load(getClass().getResource("/garage/view/fx/AjouterVoiture.fxml"));
			// Recuperer une reference de la scene et changer le graphe de scene
			Scene scene = racine.getScene();
			scene.setRoot(vueAjouter);

		} catch (IOException e) {
			Alert a = new Alert(AlertType.ERROR);
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