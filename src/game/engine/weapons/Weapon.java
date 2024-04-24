package game.engine.weapons;

import java.util.PriorityQueue;

import game.engine.titans.Titan;

public abstract class Weapon {

	private final int baseDamage;
	
	
	public Weapon (int baseDamage){
		this.baseDamage = baseDamage;
	}


	public int getDamage() {
		return baseDamage;
	}
	
	public abstract int turnAttack(PriorityQueue<Titan> laneTitans);
}
