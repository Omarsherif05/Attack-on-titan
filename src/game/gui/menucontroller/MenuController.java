package game.gui.menucontroller;

import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MenuController {

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	

	
	public void switchToMode(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("mode.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		String css = this.getClass().getResource("/game/gui/menucontroller/menu.css").toExternalForm();
		scene.getStylesheets().add(css);
		stage.setScene(scene);
		stage.show();
		stage.setFullScreen(true);

	}

	public void HowToPlay(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/game/gui/menucontroller/HowToplay.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		/*Image image = new Image("howtoplay.png");
		ImageView imageview = new ImageView(image);
		imageview.fitWidthProperty().bind(stage.widthProperty());
		imageview.fitHeightProperty().bind(stage.heightProperty());
		root.getChildren().add(imageview);*/
		stage.setFullScreen(true);
		stage.setFullScreenExitHint("");
		String css = this.getClass().getResource("/game/gui/menucontroller/howtoplay.css").toExternalForm();
		scene.getStylesheets().add(css);
		stage.show();

	}

	public void exit(ActionEvent event) {
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.close();
	}
}
