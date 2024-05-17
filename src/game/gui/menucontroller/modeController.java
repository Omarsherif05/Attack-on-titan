package game.gui.menucontroller;

import java.io.IOException;

import game.engine.Battle;
import game.engine.weapons.factory.WeaponFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import game.gui.*;
public class modeController {
	private Stage stage;
	private Scene scene;
	private Parent root;
public void easy(ActionEvent e) throws IOException{
	root = FXMLLoader.load(getClass().getResource("gameplay.fxml"));
	stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
	Battle battle = new Battle(1,0,0,3,250);
	Text score= new Text("SCORE: "+battle.getScore());
	Text turn= new Text("currentturn: "+battle.getNumberOfTurns());
	Text phase= new Text("currentphase: "+battle.getBattlePhase());
	Text resources= new Text("resources: "+battle.getResourcesGathered());
	WeaponFactory x = new WeaponFactory();
	x.getWeaponShop();
	//+avaliable lanes
}

public void hard(ActionEvent e) throws IOException{
	root = FXMLLoader.load(getClass().getResource("gameplay.fxml"));
	stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
	Battle battle = new Battle(1,0,0,5,125);
	
	Text score= new Text("SCORE: "+battle.getScore());
	Text turn= new Text("currentturn: "+battle.getNumberOfTurns());
	Text phase= new Text("currentphase: "+battle.getBattlePhase());
	Text resources= new Text("resources: "+battle.getResourcesGathered());
	//weaponshop+avaliable lanes
	
}
}
