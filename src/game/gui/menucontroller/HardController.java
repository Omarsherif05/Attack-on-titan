package game.gui.menucontroller;

import java.io.IOException;
import java.util.ArrayList;

import game.engine.Battle;
import game.engine.BattleEasy;
import game.engine.BattleHard;
import game.engine.base.Wall;
import game.engine.exceptions.InsufficientResourcesException;
import game.engine.exceptions.InvalidLaneException;
import game.engine.lanes.Lane;
import game.engine.weapons.WallTrap;
import game.engine.weapons.factory.WeaponFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HardController {
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
	@FXML
	private Text wallhealth;
	@FXML
	private GridPane gridlane1weapons;
	@FXML
	private GridPane gridlane2weapons;
	@FXML
	private GridPane gridlane3weapons;
	@FXML
	private GridPane gridlane4weapons;
	@FXML
	private GridPane gridlane5weapons;

	@FXML
	private ImageView weapon2L1;
	@FXML
	private ImageView weapon1L1;

	@FXML
	public void initialize() throws IOException {
		battle = BattleHard.getInstance();
		setupBattle();
	}

	public void setupBattle() {

		updateResources();
		updatePhase();
		updateTurn();
		updateScore();
		updatewall();
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

	private void updatewall() {
		if (wallhealth != null && battle != null) {
			ArrayList<Lane> lanes = battle.getOriginalLanes();
			StringBuilder wallHealthText = new StringBuilder("Walls: ");
			for (int i = 0; i < lanes.size(); i++) {
				Wall wall = lanes.get(i).getLaneWall();
				wallHealthText.append("Lane ").append(i + 1).append(": ").append(wall.getCurrentHealth()).append(" ");
			}
			wallhealth.setText(wallHealthText.toString());
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

	private void reloadHardScene(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("hard.fxml"));
		Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setFullScreen(true);
		stage.setFullScreenExitHint("");
		stage.show();
	}

	private void showGameOverAlert() throws IOException {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Game Over");
		alert.setHeaderText(null);
		alert.setContentText("The game is over. All lanes are lost.");
		alert.showAndWait();
	}

	public void Lane1(ActionEvent e) throws InsufficientResourcesException, InvalidLaneException, IOException {
		root = FXMLLoader.load(getClass().getResource("weaponslane1.fxml"));
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setFullScreen(true);
		stage.setFullScreenExitHint("");
		stage.show();
	}

	public void Lane2(ActionEvent e) throws InsufficientResourcesException, InvalidLaneException, IOException {
		root = FXMLLoader.load(getClass().getResource("weaponslane2.fxml"));
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setFullScreen(true);
		stage.setFullScreenExitHint("");
		stage.show();
	}

	public void Lane3(ActionEvent e) throws InsufficientResourcesException, InvalidLaneException, IOException {
		root = FXMLLoader.load(getClass().getResource("weaponslane3.fxml"));
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setFullScreen(true);
		stage.setFullScreenExitHint("");
		stage.show();
	}

	public void Lane4(ActionEvent e) throws InsufficientResourcesException, InvalidLaneException, IOException {
		root = FXMLLoader.load(getClass().getResource("weaponslane4.fxml"));
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setFullScreen(true);
		stage.setFullScreenExitHint("");
		stage.show();
	}

	public void Lane5(ActionEvent e) throws InsufficientResourcesException, InvalidLaneException, IOException {
		root = FXMLLoader.load(getClass().getResource("weaponslane5.fxml"));
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setFullScreen(true);
		stage.setFullScreenExitHint("");
		stage.show();
	}

	public void showErrorPopup(String message) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}

////////////walltrap
	public void addwalltraplane1(ActionEvent e)
			throws InsufficientResourcesException, InvalidLaneException, IOException {
		try {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(4, (Lane) x.get(0));
		} catch (InsufficientResourcesException e1) {
			showErrorPopup("Not enough resources to buy Proximity Trap.");
		}
		reloadHardScene(e);
	}

	public void addwalltraplane2(ActionEvent e)
			throws InsufficientResourcesException, InvalidLaneException, IOException {
		try {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(4, (Lane) x.get(1));
		} catch (InsufficientResourcesException e1) {
			showErrorPopup("Not enough resources to buy Proximity Trap.");
		}
		reloadHardScene(e);
	}

	public void addwalltraplane3(ActionEvent e)
			throws InsufficientResourcesException, InvalidLaneException, IOException {
		try {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(4, (Lane) x.get(2));
		} catch (InsufficientResourcesException e1) {
			showErrorPopup("Not enough resources to buy Proximity Trap.");
		}
		reloadHardScene(e);
	}

	public void addwalltraplane4(ActionEvent e)
			throws InsufficientResourcesException, InvalidLaneException, IOException {
		try {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(4, (Lane) x.get(3));
		} catch (InsufficientResourcesException e1) {
			showErrorPopup("Not enough resources to buy Proximity Trap.");
		}
		reloadHardScene(e);
	}

	public void addwalltraplane5(ActionEvent e)
			throws InsufficientResourcesException, InvalidLaneException, IOException {
		try {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(4, (Lane) x.get(4));
		} catch (InsufficientResourcesException e1) {
			showErrorPopup("Not enough resources to buy Proximity Trap.");
		}
		reloadHardScene(e);
	}

///////piercing
	public void addpiercinglane1(ActionEvent e)
			throws InsufficientResourcesException, InvalidLaneException, IOException {
		try {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(1, (Lane) x.get(0));
		} catch (InsufficientResourcesException e1) {
			showErrorPopup("Not enough resources to buy Anti-Titan Shell.");
		}
		reloadHardScene(e);
	}

	public void addpiercinglane2(ActionEvent e)
			throws InsufficientResourcesException, InvalidLaneException, IOException {
		try {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(1, (Lane) x.get(1));
		} catch (InsufficientResourcesException e1) {
			showErrorPopup("Not enough resources to buy Anti-Titan Shell.");
		}
		reloadHardScene(e);
	}

	public void addpiercinglane3(ActionEvent e)
			throws InsufficientResourcesException, InvalidLaneException, IOException {
		try {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(1, (Lane) x.get(2));
		} catch (InsufficientResourcesException e1) {
			showErrorPopup("Not enough resources to buy Anti-Titan Shell.");
		}
		reloadHardScene(e);
	}

	public void addpiercinglane4(ActionEvent e)
			throws InsufficientResourcesException, InvalidLaneException, IOException {
		try {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(1, (Lane) x.get(3));
		} catch (InsufficientResourcesException e1) {
			showErrorPopup("Not enough resources to buy Anti-Titan Shell.");
		}
		reloadHardScene(e);
	}

	public void addpiercinglane5(ActionEvent e)
			throws InsufficientResourcesException, InvalidLaneException, IOException {
		try {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(1, (Lane) x.get(4));
		} catch (InsufficientResourcesException e1) {
			showErrorPopup("Not enough resources to buy Anti-Titan Shell.");
		}
		reloadHardScene(e);
	}

/////////////volleyspread
	public void addvolleylane1(ActionEvent e) throws InsufficientResourcesException, InvalidLaneException, IOException {
		try {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(3, (Lane) x.get(0));
		} catch (InsufficientResourcesException e1) {
			showErrorPopup("Not enough resources to buy Wall Spread Cannon.");
		}
		reloadHardScene(e);
	}

	public void addvolleylane2(ActionEvent e) throws InsufficientResourcesException, InvalidLaneException, IOException {
		try {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(3, (Lane) x.get(1));
		} catch (InsufficientResourcesException e1) {
			showErrorPopup("Not enough resources to buy Wall Spread Cannon.");
		}
		reloadHardScene(e);
	}

	public void addvolleylane3(ActionEvent e) throws InsufficientResourcesException, InvalidLaneException, IOException {
		try {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(3, (Lane) x.get(2));
		} catch (InsufficientResourcesException e1) {
			showErrorPopup("Not enough resources to buy Wall Spread Cannon.");
		}
		reloadHardScene(e);
	}

	public void addvolleylane4(ActionEvent e) throws InsufficientResourcesException, InvalidLaneException, IOException {
		try {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(3, (Lane) x.get(3));
		} catch (InsufficientResourcesException e1) {
			showErrorPopup("Not enough resources to buy Wall Spread Cannon.");
		}
		reloadHardScene(e);
	}

	public void addvolleylane5(ActionEvent e) throws InsufficientResourcesException, InvalidLaneException, IOException {
		try {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(3, (Lane) x.get(4));
		} catch (InsufficientResourcesException e1) {
			showErrorPopup("Not enough resources to buy Wall Spread Cannon.");
		}
		reloadHardScene(e);
	}

////////////
	public void addsniperlane1(ActionEvent e) throws InsufficientResourcesException, InvalidLaneException, IOException {
		try {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(2, (Lane) x.get(0));
		} catch (InsufficientResourcesException e1) {
			showErrorPopup("Not enough resources to buy Sniper Cannon.");
		}
		reloadHardScene(e);
	}

	public void addsniperlane2(ActionEvent e) throws InsufficientResourcesException, InvalidLaneException, IOException {
		try {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(2, (Lane) x.get(1));
		} catch (InsufficientResourcesException e1) {
			showErrorPopup("Not enough resources to buy Long Range Spear.");
		}
		reloadHardScene(e);
	}

	public void addsniperlane3(ActionEvent e) throws InsufficientResourcesException, InvalidLaneException, IOException {
		try {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(2, (Lane) x.get(2));
		} catch (InsufficientResourcesException e1) {
			showErrorPopup("Not enough resources to buy Long Range Spear.");
		}
		reloadHardScene(e);
	}

	public void addsniperlane4(ActionEvent e) throws InsufficientResourcesException, InvalidLaneException, IOException {
		try {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(2, (Lane) x.get(3));
		} catch (InsufficientResourcesException e1) {
			showErrorPopup("Not enough resources to buy Long Range Spear.");
		}
		reloadHardScene(e);
	}

	public void addsniperlane5(ActionEvent e) throws InsufficientResourcesException, InvalidLaneException, IOException {
		try {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(2, (Lane) x.get(4));
		} catch (InsufficientResourcesException e1) {
			showErrorPopup("Not enough resources to buy Long Range Spear.");
		}
		reloadHardScene(e);
	}

	public void addweapoen(ActionEvent e) throws IOException {
		if (battle.isGameOver()) {
			showGameOverAlert();
		} else {
			root = FXMLLoader.load(getClass().getResource("lanechoosehard.fxml"));
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

	public void passturn(ActionEvent e) throws IOException {
		if (battle.isGameOver()) {
			showGameOverAlert();
		} else {
			battle.passTurn();
			reloadHardScene(e);
		}
	}

	public void back(ActionEvent e) throws IOException {
		reloadHardScene(e);
	}

	public void backShop(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("lanechoosehard.fxml"));
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		String css = this.getClass().getResource("/game/gui/menucontroller/lanehardmode.css").toExternalForm();
		scene = new Scene(root);
		scene.getStylesheets().add(css);
		stage.setScene(scene);
		stage.setFullScreen(true);
		stage.setFullScreenExitHint("");
		stage.show();
	}

}
