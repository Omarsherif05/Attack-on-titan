package game.gui.menucontroller;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class HowToPlayController {

	private Stage stage;
	private Scene scene;
	private Parent root;
	public void back(ActionEvent e) throws IOException {
	
		root = FXMLLoader.load(getClass().getResource("menu.fxml"));
//		root.getChildren().add(imageview);
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		String css = this.getClass().getResource("/game/gui/menucontroller/menu.css").toExternalForm();
		scene.getStylesheets().add(css);
		stage.setFullScreen(true);
		stage.setFullScreenExitHint("");
		stage.show();
	}

}/*
Image image = new Image("howtoplay.png");
ImageView imageview = new ImageView(image);
imageview.fitWidthProperty().bind(stage.widthProperty());
imageview.fitHeightProperty().bind(stage.heightProperty());
*/
