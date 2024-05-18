package game.gui.menucontroller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;

import game.engine.Battle;
import game.engine.exceptions.InsufficientResourcesException;
import game.engine.exceptions.InvalidLaneException;
import game.engine.lanes.Lane;
import game.engine.weapons.factory.WeaponFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
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
	private int weaponcode ;
	@FXML
	private ImageView weapon2L1;
	@FXML
	private ImageView weapon1L1;

	@FXML
	public void initialize() {
		isEasyMode = true;
		setupBattle(isEasyMode);

	}
	private void setcode(int e) {
		this.weaponcode=e;
	}
	private int getcode() {
		return weaponcode;
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
		this.weaponcode=4;
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		if (battle.getResourcesGathered() > 75) {
			if (battle.getLanes().size() <= 3) {
				root = FXMLLoader.load(getClass().getResource("lanechooseeasy.fxml"));
			} else if (battle.getLanes().size() <= 5) {
				root = FXMLLoader.load(getClass().getResource("lanechoosehard.fxml"));
			}
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setFullScreen(true);
			stage.show();
		}
		else {
			root = FXMLLoader.load(getClass().getResource("insufficientResources.fxml"));
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setFullScreen(true);
			stage.setFullScreenExitHint("");
			stage.show();
		}
	}
	public void volleyspread(ActionEvent e) throws IOException {
		setcode(3);
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		
		if (battle.getResourcesGathered() > 100) {
			if (battle.getLanes().size() <= 3) {
				root = FXMLLoader.load(getClass().getResource("lanechooseeasy.fxml"));
			} else if (battle.getLanes().size() <= 5) {
				root = FXMLLoader.load(getClass().getResource("lanechoosehard.fxml"));
			}
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setFullScreen(true);
			stage.show();
		}
		else {
			root = FXMLLoader.load(getClass().getResource("insufficientResources.fxml"));
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setFullScreen(true);
			stage.setFullScreenExitHint("");
			stage.show();
		}
	}
	public void snipercannon(ActionEvent e) throws IOException {
		setcode(2);

		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		if (battle.getResourcesGathered() > 25) {
			if (battle.getLanes().size() <= 3) {
				root = FXMLLoader.load(getClass().getResource("lanechooseeasy.fxml"));
			} else if (battle.getLanes().size() <= 5) {
				root = FXMLLoader.load(getClass().getResource("lanechoosehard.fxml"));
			}
			scene = new Scene(root);
			
			stage.setScene(scene);
			stage.setFullScreen(true);
			stage.show();
		}
		else {
			root = FXMLLoader.load(getClass().getResource("insufficientResources.fxml"));
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setFullScreen(true);
			stage.setFullScreenExitHint("");
			stage.show();
		}
	}
	public void piercingcannon(ActionEvent e) throws IOException {
		setcode(1);
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		if (battle.getResourcesGathered() > 25) {
			if (battle.getLanes().size() <= 3) {
				root = FXMLLoader.load(getClass().getResource("lanechooseeasy.fxml"));
			} else if (battle.getLanes().size() <= 5) {
				root = FXMLLoader.load(getClass().getResource("lanechoosehard.fxml"));
			}
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setFullScreen(true);
			stage.show();
		}
		else {
			root = FXMLLoader.load(getClass().getResource("insufficientResources.fxml"));
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setFullScreen(true);
			stage.setFullScreenExitHint("");
			stage.show();
		}
	}



	public void Lane1() throws InsufficientResourcesException, InvalidLaneException, IOException {
		ArrayList<Lane> x = new ArrayList<Lane>();
		x = battle.getOriginalLanes();
		switch (getcode()) {
		case 1:
			battle.purchaseWeapon(1, (Lane) x.get(0));
		case 2:
			battle.purchaseWeapon(2, (Lane) x.get(0));
		case 3:
			battle.purchaseWeapon(3, (Lane) x.get(0));
		case 4:{
			battle.purchaseWeapon(4, (Lane) x.get(0));
			weapon1L1=new ImageView("pirecing cannon.png");
			Parent root = FXMLLoader.load(getClass().getResource("/game/gui/menucontroller/easy.fxml"));
			String css = this.getClass().getResource("/game/gui/menucontroller/menu.css").toExternalForm();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(css);
			stage.setTitle("Attack on titan");
			stage.setFullScreen(true);
			stage.setFullScreenExitHint("");
			stage.setScene(scene);
			stage.show();
		}
		default: System.out.println("x");
		}
	}

	public void Lane2() throws InsufficientResourcesException, InvalidLaneException, IOException {
		ArrayList<Lane> x = new ArrayList<Lane>();
		x = battle.getOriginalLanes();
		switch (weaponcode) {
		case 1:
			if(!(boolean) x.get(1).isLaneLost()) {
			battle.purchaseWeapon(1, (Lane) x.get(1));
			}
			else {
				Parent root = FXMLLoader.load(getClass().getResource("laneislost.fxml"));
				Scene scene = new Scene(root);
				stage.setTitle("Attack on titan");
				stage.setFullScreen(true);
				stage.setFullScreenExitHint("");
				stage.setScene(scene);
				stage.show();
			}
		case 2:
			battle.purchaseWeapon(2, (Lane) x.get(1));
		case 3:
			battle.purchaseWeapon(3, (Lane) x.get(1));
		case 4:
			battle.purchaseWeapon(4, (Lane) x.get(1));

		}
	}
	public void Lane3() throws InsufficientResourcesException, InvalidLaneException, IOException {
		ArrayList<Lane> x = new ArrayList<Lane>();
		x = battle.getOriginalLanes();
		switch (weaponcode) {
		case 1:
			battle.purchaseWeapon(1, (Lane) x.get(2));
		case 2:
			battle.purchaseWeapon(2, (Lane) x.get(2));
		case 3:
			battle.purchaseWeapon(3, (Lane) x.get(2));
		case 4:
			battle.purchaseWeapon(4, (Lane) x.get(2));

		}
	}
	public void Lane4() throws InsufficientResourcesException, InvalidLaneException, IOException {
		ArrayList<Lane> x = new ArrayList<Lane>();
		x = battle.getOriginalLanes();
		switch (weaponcode) {
		case 1:
			battle.purchaseWeapon(1, (Lane) x.get(3));
		case 2:
			battle.purchaseWeapon(2, (Lane) x.get(3));
		case 3:
			battle.purchaseWeapon(3, (Lane) x.get(3));
		case 4:
			battle.purchaseWeapon(4, (Lane) x.get(3));

		}
	}
	public void Lane5() throws InsufficientResourcesException, InvalidLaneException, IOException {
		ArrayList<Lane> x = new ArrayList<Lane>();
		x = battle.getOriginalLanes();
		switch (weaponcode) {
		case 1:
			battle.purchaseWeapon(1, (Lane) x.get(4));
		case 2:
			battle.purchaseWeapon(2, (Lane) x.get(4));
		case 3:
			battle.purchaseWeapon(3, (Lane) x.get(4));
		case 4:
			battle.purchaseWeapon(4, (Lane) x.get(4));

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
	public void back(ActionEvent e) throws IOException {
		if(isEasyMode) {
		root = FXMLLoader.load(getClass().getResource("lanechooseeasy.fxml"));
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setFullScreen(true);
		stage.setFullScreenExitHint("");
		stage.show();
		}
		else {
		root = FXMLLoader.load(getClass().getResource("lanechoosehard.fxml"));
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setFullScreen(true);
		stage.setFullScreenExitHint("");
		stage.show();}
	}
	public void backShop(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("weapons.fxml"));
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setFullScreen(true);
		stage.setFullScreenExitHint("");
		stage.show();
	}
	public void passturn(ActionEvent e) throws IOException {
		if(isEasyMode) {
		battle.passTurn();
		root = FXMLLoader.load(getClass().getResource("easy.fxml"));
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setFullScreen(true);
		stage.setFullScreenExitHint("");
		stage.show();
		}
		else {
			battle.passTurn();
			root = FXMLLoader.load(getClass().getResource("hard.fxml"));
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setFullScreen(true);
			stage.setFullScreenExitHint("");
			stage.show();
		}
	}

}
