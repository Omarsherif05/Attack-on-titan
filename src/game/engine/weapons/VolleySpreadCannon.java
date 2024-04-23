package game.engine.weapons;

import java.util.Iterator;
import java.util.PriorityQueue;

import game.engine.titans.Titan;

public class VolleySpreadCannon extends Weapon {
	public static final int WEAPON_CODE = 3;
	private final int minRange;
	private final int maxRange;

	public VolleySpreadCannon(int baseDamage, int minRange, int maxRange) {
		super(baseDamage);
		this.minRange = minRange;
		this.maxRange = maxRange;
	}

	public int getMinRange() {
		return minRange;
	}

	public int getMaxRange() {
		return maxRange;
	}

	public int turnAttack(PriorityQueue<Titan> laneTitans) {
		int resourcesValue = 0;
		int damage = this.getDamage();
		PriorityQueue<Titan> currentTitans = new PriorityQueue<Titan>();
		if (!laneTitans.isEmpty()) {
			for (int i = 0; i < laneTitans.size(); i++) {
				Titan titan = laneTitans.poll();
				if (titan.getDistance() > this.getMinRange() && titan.getDistance() < this.getMaxRange()) {
					titan.takeDamage(damage);
				}
				if (titan.isDefeated()) {
					resourcesValue += titan.getResourcesValue();
				} else {
					currentTitans.add(titan);
				}
			}
		}
		laneTitans.addAll(currentTitans);
		return resourcesValue;
	}

}
