package game.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
		String css = this.getClass().getResource("app.css").toExternalForm();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(css);
		stage.setTitle("Attack on titan");
		stage.setScene(scene);
		stage.show();

	}
}
