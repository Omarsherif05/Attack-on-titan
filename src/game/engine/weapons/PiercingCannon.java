package game.engine.weapons;

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
		int count = Math.min(laneTitans.size(), 5);
		PriorityQueue<Titan> currentTitans = new PriorityQueue<Titan>();
		if (!laneTitans.isEmpty()) {
			for (int i = 0; i < count; i++) {
				Titan titan = laneTitans.poll();
				titan.takeDamage(damage);
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
