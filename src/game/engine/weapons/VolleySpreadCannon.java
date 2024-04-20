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
		PriorityQueue<Titan> secondQueue = new PriorityQueue<>(
				(titan1, titan2) -> Integer.compare(titan1.getDistance(), titan2.getDistance()));
		Titan currentTitan = secondQueue.peek();
		int damage = this.getDamage();
		if (currentTitan.getDistance() > this.getMinRange() && currentTitan.getDistance() < this.getMaxRange()) {
			currentTitan.takeDamage(damage);
		}
		if (currentTitan.isDefeated()) {
			secondQueue.remove();
			return currentTitan.getResourcesValue();
		}
		return 0;
	}

}
