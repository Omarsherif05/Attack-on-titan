package game.gui.menucontroller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;

import game.engine.Battle;
import game.engine.BattleSingleton;
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
		private GridPane easygridpane;
		
		@FXML
		private GridPane gridlane1weapons;
		@FXML
		private GridPane gridlane2weapons;
		@FXML
		private GridPane gridlane3weapons;
		
		
		
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
<<<<<<< HEAD

=======
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
>>>>>>> d74616bcd7f01ef7244125154a242cdcb97a908b
		
	////////////walltrap
		public void addwalltraplane1(ActionEvent e)  throws InsufficientResourcesException, InvalidLaneException, IOException {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(4, (Lane) x.get(0));
<<<<<<< HEAD
			weapon1L1 =new ImageView("gui/menucontroller/walltrap.png"); 
			gridlane1weapons =new GridPane();
			gridlane1weapons.add(weapon1L1,0,0);
	
=======
			reloadEasyScene(e);
			
			
>>>>>>> d74616bcd7f01ef7244125154a242cdcb97a908b
		}
		public void addwalltraplane2(ActionEvent e)  throws InsufficientResourcesException, InvalidLaneException, IOException {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(4, (Lane) x.get(1));
<<<<<<< HEAD
			weapon1L1 =new ImageView("gui/menucontroller/walltrap.png"); 
			gridlane2weapons =new GridPane();
			gridlane2weapons.add(weapon1L1,1,0);
=======
			reloadEasyScene(e);
>>>>>>> d74616bcd7f01ef7244125154a242cdcb97a908b
		}
		public void addwalltraplane3(ActionEvent e) throws InsufficientResourcesException, InvalidLaneException, IOException  {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(4, (Lane) x.get(2));
<<<<<<< HEAD
			weapon1L1 =new ImageView("gui/menucontroller/walltrap.png"); 
			gridlane3weapons =new GridPane();
			gridlane3weapons.add(weapon1L1,2,0);
		}
		
=======
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
>>>>>>> d74616bcd7f01ef7244125154a242cdcb97a908b
	///////piercing
		public void addpiercinglane1(ActionEvent e)  throws InsufficientResourcesException, InvalidLaneException, IOException {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(1, (Lane) x.get(0));
<<<<<<< HEAD
			weapon1L1 =new ImageView("gui/menucontroller/pirecing cannon.png"); 
			gridlane1weapons =new GridPane();
			gridlane1weapons.add(weapon1L1,0,0);
=======
			reloadEasyScene(e);
>>>>>>> d74616bcd7f01ef7244125154a242cdcb97a908b
		}
		public void addpiercinglane2(ActionEvent e)  throws InsufficientResourcesException, InvalidLaneException, IOException {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(1, (Lane) x.get(1));
<<<<<<< HEAD
			weapon1L1 =new ImageView("gui/menucontroller/pirecing cannon.png"); 
			gridlane2weapons =new GridPane();
			gridlane2weapons.add(weapon1L1,0,0);
=======
			reloadEasyScene(e);
>>>>>>> d74616bcd7f01ef7244125154a242cdcb97a908b
		}
		public void addpiercinglane3(ActionEvent e)  throws InsufficientResourcesException, InvalidLaneException, IOException {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(1, (Lane) x.get(2));
<<<<<<< HEAD
			weapon1L1 =new ImageView("gui/menucontroller/pirecing cannon.png"); 
			gridlane3weapons =new GridPane();
			gridlane3weapons.add(weapon1L1,0,0);
		}
		
=======
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
>>>>>>> d74616bcd7f01ef7244125154a242cdcb97a908b
		/////////////volleyspread
		public void addvolleylane1(ActionEvent e)  throws InsufficientResourcesException, InvalidLaneException, IOException {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(3, (Lane) x.get(0));
<<<<<<< HEAD
			weapon1L1 =new ImageView("gui/menucontroller/volleyspread.png"); 
			gridlane1weapons =new GridPane();
			gridlane1weapons.add(weapon1L1,0,0);
			
=======
			reloadEasyScene(e);
>>>>>>> d74616bcd7f01ef7244125154a242cdcb97a908b
		}
		public void addvolleylane2(ActionEvent e)  throws InsufficientResourcesException, InvalidLaneException, IOException {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(3, (Lane) x.get(1));
<<<<<<< HEAD
			weapon1L1 =new ImageView("gui/menucontroller/volleyspread.png"); 
			gridlane2weapons =new GridPane();
			gridlane2weapons.add(weapon1L1,0,0);
=======
			reloadEasyScene(e);
>>>>>>> d74616bcd7f01ef7244125154a242cdcb97a908b
		}
		public void addvolleylane3(ActionEvent e) throws InsufficientResourcesException, InvalidLaneException, IOException  {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(3, (Lane) x.get(2));
<<<<<<< HEAD
			weapon1L1 =new ImageView("gui/menucontroller/volleyspread.png"); 
			gridlane3weapons =new GridPane();
			gridlane3weapons.add(weapon1L1,0,0);
			
		}
	
=======
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
>>>>>>> d74616bcd7f01ef7244125154a242cdcb97a908b
		////////////
		public void addsniperlane1(ActionEvent e)  throws InsufficientResourcesException, InvalidLaneException, IOException {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(2, (Lane) x.get(0));
<<<<<<< HEAD
			weapon1L1 =new ImageView("gui/menucontroller/sniper_cannon-.png"); 
			gridlane1weapons =new GridPane();
			gridlane1weapons.add(weapon1L1,0,0);
=======
			reloadEasyScene(e);
>>>>>>> d74616bcd7f01ef7244125154a242cdcb97a908b
		}
		public void addsniperlane2(ActionEvent e) throws InsufficientResourcesException, InvalidLaneException, IOException  {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(2, (Lane) x.get(1));
<<<<<<< HEAD
			weapon1L1 =new ImageView("gui/menucontroller/sniper_cannon-.png"); 
			gridlane1weapons =new GridPane();
			gridlane1weapons.add(weapon1L1,0,0);
=======
			reloadEasyScene(e);
>>>>>>> d74616bcd7f01ef7244125154a242cdcb97a908b
		}
		public void addsniperlane3(ActionEvent e) throws InsufficientResourcesException, InvalidLaneException, IOException {
			ArrayList<Lane> x = new ArrayList<Lane>();
			x = battle.getOriginalLanes();
			battle.purchaseWeapon(2, (Lane) x.get(2));
<<<<<<< HEAD
			weapon1L1 =new ImageView("gui/menucontroller/sniper_cannon-.png"); 
			gridlane1weapons =new GridPane();
			gridlane1weapons.add(weapon1L1,0,0);
		}
	
=======
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
>>>>>>> d74616bcd7f01ef7244125154a242cdcb97a908b
		
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
		public void spawntitans() {
			battle.refillApproachingTitans();
			battle.getOriginalLanes().get(0).a;
		}
		}

	

