package game.engine.weapons;

import java.util.Iterator;
import java.util.PriorityQueue;

import game.engine.titans.Titan;

public class PiercingCannon extends Weapon {

	public static final int WEAPON_CODE = 1;

	public PiercingCannon(int baseDamage) {
		super(baseDamage);

	}

	public int turnAttack(PriorityQueue<Titan> laneTitans) {
		int resourcesValue = 0;
		int damage = this.getDamage();
		int currentTitans = Math.min(laneTitans.size(), 5);

		PriorityQueue<Titan> secondQueue = new PriorityQueue<>(
				(titan1, titan2) -> Integer.compare(titan1.getDistance(), titan2.getDistance()));

		for (int i = 0; i < currentTitans; i++) {
			if (laneTitans.isEmpty()) {
				break;
			}
			secondQueue.add(laneTitans.poll());
		}
		while (!secondQueue.isEmpty()) {
			Titan targetTitan = secondQueue.poll();
			targetTitan.takeDamage(damage);
			if (targetTitan.isDefeated()) {
				resourcesValue += targetTitan.getResourcesValue();
			}
		}
		return resourcesValue;
	}

}
