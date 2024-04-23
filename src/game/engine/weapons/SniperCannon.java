package game.engine.weapons;

import java.util.PriorityQueue;

import game.engine.titans.Titan;

public class SniperCannon extends Weapon {
	public static final int WEAPON_CODE = 2;

	public SniperCannon(int baseDamage) {
		super(baseDamage);
	}

	public int turnAttack(PriorityQueue<Titan> laneTitans) {
		int resourcesValue = 0;
		int damage = this.getDamage();
		PriorityQueue<Titan> currentTitans = new PriorityQueue<Titan>();
		if (!laneTitans.isEmpty()) {
			for (int i = 0; i < laneTitans.size(); i++) {
				Titan titan = laneTitans.poll();
				currentTitans.add(titan);
			}
			laneTitans.addAll(currentTitans);
			Titan currentTitan = laneTitans.poll();
			currentTitan.takeDamage(damage);
			if (currentTitan.isDefeated()) {
				return currentTitan.getResourcesValue();
			} else {
				laneTitans.add(currentTitan);
			}
		}
		return resourcesValue;
	}
}
