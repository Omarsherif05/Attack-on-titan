package game.gui.menucontroller;

import java.io.IOException;
import java.util.PriorityQueue;

import game.engine.Battle;
import game.engine.lanes.Lane;
import game.engine.weapons.factory.WeaponFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import game.gui.*;

public class modeController {
	@FXML
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
	private Text score;
	@FXML
	private Text phase;
	@FXML
	private Text turn;
	@FXML
	private Text xyz;

	private Battle battle;

	private boolean isEasyMode;
	private int weaponcode;
	@FXML
	public void initialize() {
		isEasyMode = true;
		setupBattle(isEasyMode);

	}

	public void setupBattle(boolean isEasy) {
		try {
			if (isEasy) {
				battle = new Battle(1, 0, 0, 3, 250);
			} else {
				battle = new Battle(1, 0, 0, 5, 125);
			}
			updateResources();
			updatePhase();
			updateTurn();
			updateScore();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void updateTurn() {
		if (turn != null && battle != null) {
			turn.setText("Turn: " + battle.getNumberOfTurns());
		}
	}

	private void updatePhase() {
		if (phase != null && battle != null) {
			phase.setText("Phase: " + battle.getBattlePhase());
		}
	}

	private void updateScore() {
		if (score != null && battle != null) {
			score.setText("SCORE: " + battle.getScore());
		}
	}

	private void updateResources() {
		if (xyz != null && battle != null) {
			xyz.setText("Resources: " + battle.getResourcesGathered());
		}
	}

	public void easy(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("easy.fxml"));
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		battle = new Battle(1, 0, 0, 3, 250);
		scene = new Scene(root);
		stage.setScene(scene);
		String css = this.getClass().getResource("/game/gui/menucontroller/easy.css").toExternalForm();
		scene.getStylesheets().add(css);
		stage.setFullScreen(true);
		stage.setFullScreenExitHint("");
		stage.show();
		isEasyMode = true;
		setupBattle(isEasyMode);
		WeaponFactory x = new WeaponFactory();
		x.getWeaponShop();
		battle.initializeLanes(3);
	}

	public void hard(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("hard.fxml"));
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setFullScreen(true);
		stage.setFullScreenExitHint("");
		String css = this.getClass().getResource("/game/gui/menucontroller/hard.css").toExternalForm();
		scene.getStylesheets().add(css);
		stage.show();
		isEasyMode = false;
		setupBattle(isEasyMode);
		WeaponFactory x = new WeaponFactory();
		x.getWeaponShop();
		battle.initializeLanes(5);
	}

	public void walltrap(ActionEvent e) throws IOException {
		
		if(battle.getResourcesGathered()>75) { 	
		//resources-easy/hard
		if (battle.getLanes().size() <= 3) {
			root = FXMLLoader.load(getClass().getResource("lanechooseeasy.fxml"));	
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setFullScreen(true);
		}
		if (battle.getLanes().size() <= 5) {
			root = FXMLLoader.load(getClass().getResource("lanechoosehard.fxml"));
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setFullScreen(true);
		}
		}
	}
	public void Lane1() {
		switch(weaponcode) {
		case 1:
			PriorityQueue<Lane> x= battle.getLanes();
		battle.purchaseWeapon(1,x);
		
		}
	}
	

	public void addweapoen(ActionEvent e) throws IOException {
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
