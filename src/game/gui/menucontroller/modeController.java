package game.gui.menucontroller;

import java.io.IOException;

import game.engine.Battle;
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
	public Battle battle;

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
		battle = new Battle(1, 0, 0, 3, 250);
		Text score = new Text("SCORE: " + battle.getScore());
		Text turn = new Text("currentturn: " + battle.getNumberOfTurns());
		Text phase = new Text("currentphase: " + battle.getBattlePhase());
		Text resources = new Text("resources: " + battle.getResourcesGathered());
		WeaponFactory x = new WeaponFactory();
		x.getWeaponShop();
		// +avaliable lanes
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
		 battle = new Battle(1, 0, 0, 5, 125);

		Text score = new Text("SCORE: " + battle.getScore());
		Text turn = new Text("currentturn: " + battle.getNumberOfTurns());
		Text phase = new Text("currentphase: " + battle.getBattlePhase());
		Text resources = new Text("resources: " + battle.getResourcesGathered());
		// weaponshop+avaliable lanes

	}
	public void walltrap(ActionEvent e) throws IOException {
		///
		battle.setResourcesGathered(battle.getResourcesGathered()-100);
		if(battle.getLanes().size()<=3) {
		root = FXMLLoader.load(getClass().getResource("lanechooseeasy.fxml"));
		}
		if(battle.getLanes().size()<=5) {
			root = FXMLLoader.load(getClass().getResource("lanechoosehard.fxml"));
		}
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setFullScreen(true);
		}
		
	
	
}
