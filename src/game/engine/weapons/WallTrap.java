package game.engine.weapons;

import java.util.PriorityQueue;

import game.engine.titans.Titan;

public class WallTrap extends Weapon {

	public static final int WEAPON_CODE = 4;

	public WallTrap(int baseDamage) {
		super(baseDamage);
	}

	public int turnAttack(PriorityQueue<Titan> laneTitans) {
		int resourcesValue = 0;
		int damage = this.getDamage();
		PriorityQueue<Titan> currentTitans = new PriorityQueue<Titan>();
		if (!laneTitans.isEmpty()) {
			for (Titan titan: laneTitans) {
				if (titan.hasReachedTarget()) {
					titan.takeDamage(damage);
				}
				if (titan.isDefeated()) {
					resourcesValue += titan.getResourcesValue();
				} else {
					currentTitans.add(titan);
				}
			}
		}
		laneTitans.clear();
		laneTitans.addAll(currentTitans);
		return resourcesValue;
	}
}
