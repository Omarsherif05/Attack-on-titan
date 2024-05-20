package game.gui.menucontroller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;

import game.engine.Battle;
import game.engine.BattleSingleton;
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
import javafx.scene.image.ImageView;
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
@FXML
private Text wallhealth;

		private Battle battle;

		
		@FXML
		private ImageView weapon2L1;
		@FXML
		private ImageView weapon1L1;

		@FXML
		public void initialize() throws IOException {
			 battle = BattleSingleton.getInstance();
			 
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
		 
/*
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
*/
		 private void reloadEasyScene(ActionEvent e) throws IOException {
		        Parent root = FXMLLoader.load(getClass().getResource("easy.fxml"));
		        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		        Scene scene = new Scene(root);
		        stage.setScene(scene);
		        stage.setFullScreen(true);
		        stage.setFullScreenExitHint("");
		        stage.show();
		    }
		
	////////////walltrap
		public void addwalltraplane1(ActionEvent e)  throws InsufficientResourcesException, InvalidLaneException, IOException {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(4, (Lane) x.get(0));
			reloadEasyScene(e);
			
			
		}
		public void addwalltraplane2(ActionEvent e)  throws InsufficientResourcesException, InvalidLaneException, IOException {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(4, (Lane) x.get(1));
			reloadEasyScene(e);
		}
		public void addwalltraplane3(ActionEvent e) throws InsufficientResourcesException, InvalidLaneException, IOException  {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(4, (Lane) x.get(2));
			reloadEasyScene(e);
		}
		public void addwalltraplane4(ActionEvent e)  throws InsufficientResourcesException, InvalidLaneException, IOException {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(4, (Lane) x.get(3));
			reloadEasyScene(e);
		}
		public void addwalltraplane5(ActionEvent e) throws InsufficientResourcesException, InvalidLaneException, IOException  {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(4, (Lane) x.get(4));
			reloadEasyScene(e);
		}
	///////piercing
		public void addpiercinglane1(ActionEvent e)  throws InsufficientResourcesException, InvalidLaneException, IOException {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(1, (Lane) x.get(0));
			reloadEasyScene(e);
		}
		public void addpiercinglane2(ActionEvent e)  throws InsufficientResourcesException, InvalidLaneException, IOException {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(1, (Lane) x.get(1));
			reloadEasyScene(e);
		}
		public void addpiercinglane3(ActionEvent e)  throws InsufficientResourcesException, InvalidLaneException, IOException {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(1, (Lane) x.get(2));
			reloadEasyScene(e);
		}
		public void addpiercinglane4(ActionEvent e)  throws InsufficientResourcesException, InvalidLaneException, IOException {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(1, (Lane) x.get(3));
			reloadEasyScene(e);
		}
		public void addpiercinglane5(ActionEvent e)  throws InsufficientResourcesException, InvalidLaneException, IOException {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(1, (Lane) x.get(4));
			reloadEasyScene(e);
		}
		/////////////volleyspread
		public void addvolleylane1(ActionEvent e)  throws InsufficientResourcesException, InvalidLaneException, IOException {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(3, (Lane) x.get(0));
			reloadEasyScene(e);
		}
		public void addvolleylane2(ActionEvent e)  throws InsufficientResourcesException, InvalidLaneException, IOException {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(3, (Lane) x.get(1));
			reloadEasyScene(e);
		}
		public void addvolleylane3(ActionEvent e) throws InsufficientResourcesException, InvalidLaneException, IOException  {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(3, (Lane) x.get(2));
			reloadEasyScene(e);
			
		}
		public void addvolleylane4(ActionEvent e)  throws InsufficientResourcesException, InvalidLaneException, IOException {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(3, (Lane) x.get(3));
			reloadEasyScene(e);
		}
		public void addvolleylane5(ActionEvent e) throws InsufficientResourcesException, InvalidLaneException, IOException  {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(3, (Lane) x.get(4));
			reloadEasyScene(e);
		}
		////////////
		public void addsniperlane1(ActionEvent e)  throws InsufficientResourcesException, InvalidLaneException, IOException {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(2, (Lane) x.get(0));
			reloadEasyScene(e);
		}
		public void addsniperlane2(ActionEvent e) throws InsufficientResourcesException, InvalidLaneException, IOException  {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(2, (Lane) x.get(1));
			reloadEasyScene(e);
		}
		public void addsniperlane3(ActionEvent e) throws InsufficientResourcesException, InvalidLaneException, IOException {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(2, (Lane) x.get(2));
			reloadEasyScene(e);
		}
		public void addsniperlane4(ActionEvent e) throws InsufficientResourcesException, InvalidLaneException, IOException {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(2, (Lane) x.get(3));
			reloadEasyScene(e);
		}
		public void addsniperlane5(ActionEvent e) throws InsufficientResourcesException, InvalidLaneException, IOException {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(2, (Lane) x.get(4));
			reloadEasyScene(e);
		}
		
		public void Lane1(ActionEvent e) throws InsufficientResourcesException, InvalidLaneException, IOException {
			root = FXMLLoader.load(getClass().getResource("weaponslane1easy.fxml"));
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setFullScreen(true);
			stage.setFullScreenExitHint("");
			stage.show();
		}
		
		

		public void Lane2(ActionEvent e) throws InsufficientResourcesException, InvalidLaneException, IOException {
			root = FXMLLoader.load(getClass().getResource("weaponlane2easy.fxml"));
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setFullScreen(true);
			stage.setFullScreenExitHint("");
			stage.show();
		}
		public void Lane3(ActionEvent e) throws InsufficientResourcesException, InvalidLaneException, IOException {
			root = FXMLLoader.load(getClass().getResource("weaponslane3easy.fxml"));
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
			reloadEasyScene(e);
			}
		}

	

