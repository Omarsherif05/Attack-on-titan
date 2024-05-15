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

	/*
	 * 
	 * public void start(Stage stage) throws Exception { Parent root =
	 * FXMLLoader.load(getClass().getResource(
	 * "file:/Attack-on-titan/src/game/gui/menuview/menu.fxml")); String css =
	 * this.getClass().getResource("file:/Attack-on-titan/src/game/gui/app.css").
	 * toExternalForm(); Scene scene = new Scene(root);
	 * scene.getStylesheets().add(css); stage.setTitle("Attack on titan");
	 * stage.setScene(scene); stage.show();
	 * //Font.loadFont(getClass().getResourceAsStream("/cod_font.ttf"), 14);
	 * 
	 * 
	 * } }
	 */
	public void start(Stage stage) throws Exception {
		try {
			/*
			 * URL url = new File(
			 * "C:\\Users\\mourad\\Desktop\\project\\Attack-on-titan\\src\\game\\gui\\menu.fxml"
			 * ).toURI().toURL(); Parent root = FXMLLoader.load(url);
			 */
			Parent root = FXMLLoader.load(getClass().getResource("/game/gui/menucontroller/menu.fxml"));
			String css = this.getClass().getResource("/game/gui/menucontroller/menu.css").toExternalForm();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(css);
			stage.setTitle("Attack on titan");
			stage.setScene(scene);
			stage.show();
		

		} catch (Exception e) {
			// generic exception handling
			e.printStackTrace();
		}
	}
}
