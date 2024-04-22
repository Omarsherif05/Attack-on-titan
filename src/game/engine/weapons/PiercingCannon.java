package game.engine.weapons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

import game.engine.titans.Titan;

public class PiercingCannon extends Weapon {

	public static final int WEAPON_CODE = 1;

	public PiercingCannon(int baseDamage) {
		super(baseDamage);

	}

////ERRORs
	public int turnAttack(PriorityQueue<Titan> laneTitans) {
		int resourcesValue = 0;
		int count = Math.min(laneTitans.size(), 5);
		Iterator<Titan> iterator = laneTitans.iterator();

		if (!laneTitans.isEmpty()) {
			for (int i = 0; i < count; i++) {
				Titan currentTitan = iterator.next();
				currentTitan.takeDamage(this.getDamage());
				if (currentTitan.isDefeated()) {
					iterator.remove();
					resourcesValue += currentTitan.getResourcesValue();
				}
			}
		}

		return resourcesValue;
	}
}
