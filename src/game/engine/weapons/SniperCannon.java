package game.engine.weapons;

import java.util.PriorityQueue;

import game.engine.titans.Titan;

public class SniperCannon extends Weapon {
	public static final int WEAPON_CODE = 2;

	public SniperCannon(int baseDamage) {
		super(baseDamage);
	}

	public int turnAttack(PriorityQueue<Titan> laneTitans) {
		PriorityQueue<Titan> secondQueue = new PriorityQueue<>(
				(titan1, titan2) -> Integer.compare(titan1.getDistance(), titan2.getDistance()));
		Titan currentTitan = secondQueue.peek();
		int damage = this.getDamage();
		currentTitan.takeDamage(damage);
		if (currentTitan.isDefeated()) {
			secondQueue.remove();
			return currentTitan.getResourcesValue();
		}
		return 0;
	}
}
