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
			for (int i = 0; i < laneTitans.size(); i++) {
				Titan titan = laneTitans.poll();
				if (titan.hasReachedTarget()) {
					titan.takeDamage(damage);
				}
				if (titan.isDefeated()) {
					resourcesValue += titan.getResourcesValue();
				} else {
					currentTitans.offer(titan);
				}
			}

		}
		laneTitans.addAll(currentTitans);
		return resourcesValue;

	}

}
