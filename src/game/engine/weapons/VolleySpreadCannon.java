package game.engine.weapons;

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
		int count = laneTitans.size();
		PriorityQueue<Titan> currentTitans = new PriorityQueue<Titan>();
		if (!laneTitans.isEmpty()) {
			for (int i = 0; i < count; i++) {
				Titan titan = laneTitans.poll();
				if (titan.getDistance() >= this.getMinRange()
						&& titan.getDistance() <= this.getMaxRange()) {
					resourcesValue += titan.takeDamage(damage);

					if (!titan.isDefeated()) {
						currentTitans.add(titan);
					} 
				} else {
					currentTitans.add(titan);
				}
			}
		}
		laneTitans.addAll(currentTitans);
		return resourcesValue;
	}
}
