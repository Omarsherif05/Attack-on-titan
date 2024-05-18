package game.gui.menucontroller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class gameplaycontroller {
	private Stage stage;
	private Scene scene;
	private Parent root;
public void addweapoen(ActionEvent e) throws IOException{
	root = FXMLLoader.load(getClass().getResource("weapons.fxml"));
	stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.setFullScreen(true);
	stage.setFullScreenExitHint("");
	String css = this.getClass().getResource("/game/gui/menucontroller/weapons.css").toExternalForm();
	scene.getStylesheets().add(css);
	stage.show();
}
}
