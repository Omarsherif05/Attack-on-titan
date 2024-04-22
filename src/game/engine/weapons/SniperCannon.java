package game.engine.weapons;

import java.util.PriorityQueue;

import game.engine.titans.Titan;

public class SniperCannon extends Weapon {
	public static final int WEAPON_CODE = 2;

	public SniperCannon(int baseDamage) {
		super(baseDamage);
	}

	public int turnAttack(PriorityQueue<Titan> laneTitans) {
		if (!laneTitans.isEmpty()) {
			Titan currentTitan = laneTitans.poll();
			int damage = this.getDamage();
			currentTitan.takeDamage(damage);
			if (currentTitan.isDefeated()) {
				return currentTitan.getResourcesValue();
			} else {
				laneTitans.offer(currentTitan);
			}
		}
		return 0;

	}
}
