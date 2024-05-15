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
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MenuController {

	private Stage stage;
	private Scene scene;
	private Parent root;
	//Font cod_font;
	
	public void switchToEasyMode(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource(".fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}

	public void switchToHardMode(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource(".fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void HowToPlay(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/game/gui/HowToplay.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void handleExitButtonAction(ActionEvent event) {
		  // Get the stage from the event (assuming the button click triggers this function)
		  Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		  
		  // Close the stage (exits the game)
		  stage.close();
		}
}
