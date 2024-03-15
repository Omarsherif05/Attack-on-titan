package game.engine.base;

import game.engine.interfaces.Attackee;

public class Wall implements Attackee{

	
	
	public  final int baseHealth ;
	protected int currentHealth;


	public Wall(int baseHealth) {
		this.baseHealth = baseHealth;
		this.currentHealth = baseHealth;
	}


}
