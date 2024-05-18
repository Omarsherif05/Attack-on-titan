package game.gui;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	public void start(Stage stage) throws Exception {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/game/gui/menucontroller/menu.fxml"));
			String css = this.getClass().getResource("/game/gui/menucontroller/menu.css").toExternalForm();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(css);
			stage.setTitle("Attack on titan");
			stage.setFullScreen(true);
			stage.setFullScreenExitHint("");
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}
