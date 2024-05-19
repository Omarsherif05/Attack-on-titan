package game.gui.menucontroller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;

import game.engine.Battle;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import game.gui.*;

public class easyController {
	

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
		private GridPane gridlane1weapons;
		
		@FXML
		private ImageView weapon2L1;
		@FXML
		private ImageView weapon1L1;
		
		@FXML
		public void initialize() {
			try {
				battle = new Battle(1, 0, 0, 3, 250);
				battle.initializeLanes(3);
				setupBattle();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}
	public void setupBattle() {
				updateResources();
				updatePhase();
				updateTurn();
				updateScore();
			
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
			scene = new Scene(root);
			stage.setScene(scene);
			String css = this.getClass().getResource("/game/gui/menucontroller/easy.css").toExternalForm();
			scene.getStylesheets().add(css);
			stage.setFullScreen(true);
			stage.setFullScreenExitHint("");
			stage.show();
			
			setupBattle();
			WeaponFactory x = new WeaponFactory();
			x.getWeaponShop();
			
		}

		
	////////////walltrap
		public void addwalltraplane1(ActionEvent e)  throws InsufficientResourcesException, InvalidLaneException, IOException {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(4, (Lane) x.get(0));
			weapon1L1 =new ImageView("gui/menucontroller/walltrap.png"); 
			gridlane1weapons =new GridPane();
			gridlane1weapons.add(weapon1L1,0,0);
			root = FXMLLoader.load(getClass().getResource("easy.fxml"));
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			String css = this.getClass().getResource("/game/gui/menucontroller/easy.css").toExternalForm();
			scene.getStylesheets().add(css);
			stage.setFullScreen(true);
			stage.setFullScreenExitHint("");
			setupBattle();
			stage.show();
		}
		public void addwalltraplane2(ActionEvent e)  throws InsufficientResourcesException, InvalidLaneException, IOException {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(4, (Lane) x.get(1));
		}
		public void addwalltraplane3(ActionEvent e) throws InsufficientResourcesException, InvalidLaneException, IOException  {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(4, (Lane) x.get(2));
		}
		public void addwalltraplane4(ActionEvent e)  throws InsufficientResourcesException, InvalidLaneException, IOException {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(4, (Lane) x.get(3));
		}
		public void addwalltraplane5(ActionEvent e) throws InsufficientResourcesException, InvalidLaneException, IOException  {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(4, (Lane) x.get(4));
		}
	///////piercing
		public void addpiercinglane1(ActionEvent e)  throws InsufficientResourcesException, InvalidLaneException, IOException {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(1, (Lane) x.get(0));
		}
		public void addpiercinglane2(ActionEvent e)  throws InsufficientResourcesException, InvalidLaneException, IOException {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(1, (Lane) x.get(1));
		}
		public void addpiercinglane3(ActionEvent e)  throws InsufficientResourcesException, InvalidLaneException, IOException {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(1, (Lane) x.get(2));
		}
		public void addpiercinglane4(ActionEvent e)  throws InsufficientResourcesException, InvalidLaneException, IOException {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(1, (Lane) x.get(3));
		}
		public void addpiercinglane5(ActionEvent e)  throws InsufficientResourcesException, InvalidLaneException, IOException {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(1, (Lane) x.get(4));
		}
		/////////////volleyspread
		public void addvolleylane1(ActionEvent e)  throws InsufficientResourcesException, InvalidLaneException, IOException {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(3, (Lane) x.get(0));
			
		}
		public void addvolleylane2(ActionEvent e)  throws InsufficientResourcesException, InvalidLaneException, IOException {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(3, (Lane) x.get(1));
		}
		public void addvolleylane3(ActionEvent e) throws InsufficientResourcesException, InvalidLaneException, IOException  {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(3, (Lane) x.get(2));
			
		}
		public void addvolleylane4(ActionEvent e)  throws InsufficientResourcesException, InvalidLaneException, IOException {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(3, (Lane) x.get(3));
		}
		public void addvolleylane5(ActionEvent e) throws InsufficientResourcesException, InvalidLaneException, IOException  {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(3, (Lane) x.get(4));
		}
		////////////
		public void addsniperlane1(ActionEvent e)  throws InsufficientResourcesException, InvalidLaneException, IOException {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(2, (Lane) x.get(0));
		}
		public void addsniperlane2(ActionEvent e) throws InsufficientResourcesException, InvalidLaneException, IOException  {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(2, (Lane) x.get(1));
		}
		public void addsniperlane3(ActionEvent e) throws InsufficientResourcesException, InvalidLaneException, IOException {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(2, (Lane) x.get(2));
		}
		public void addsniperlane4(ActionEvent e) throws InsufficientResourcesException, InvalidLaneException, IOException {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(2, (Lane) x.get(3));
		}
		public void addsniperlane5(ActionEvent e) throws InsufficientResourcesException, InvalidLaneException, IOException {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(2, (Lane) x.get(4));
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
		
		
		
		public void addweapoen(ActionEvent e) throws IOException {
			root = FXMLLoader.load(getClass().getResource("lanechooseeasy.fxml"));
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
			
			root = FXMLLoader.load(getClass().getResource("lanechooseeasy.fxml"));
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setFullScreen(true);
			stage.setFullScreenExitHint("");
			stage.show();
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
			battle.passTurn();
			root = FXMLLoader.load(getClass().getResource("easy.fxml"));
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setFullScreen(true);
			stage.setFullScreenExitHint("");
			stage.show();
			}
		}

	

