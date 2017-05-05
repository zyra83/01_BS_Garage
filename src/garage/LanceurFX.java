package garage;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LanceurFX extends Application {
	@Override
	// Le point d'entrée de toutes les applications JavaFX
	public void start(Stage primaryStage) throws IOException {
		primaryStage.setTitle("Mon garage");
		VBox vueAccueil = (VBox) FXMLLoader.load(getClass().getResource("/garage/view/fx/Accueil.fxml"));
		// Ou alors instanciation du controleur de Accueil.fxml

		primaryStage.setScene(new Scene(vueAccueil));
		primaryStage.show();

	}

	// Point d'entrée
	public static void main(String[] args) {
		// Appelle launch quu lui appelle start() ci-dessus
		Application.launch(args);
	}
}
