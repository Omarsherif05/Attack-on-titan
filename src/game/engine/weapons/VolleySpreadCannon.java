package game.engine.weapons;


import java.util.ArrayList;
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

//	public int turnAttack(PriorityQueue<Titan> laneTitans) {
//		int resourcesValue = 0;
//		int damage = this.getDamage();
//		int count  = laneTitans.size();
//		PriorityQueue<Titan> currentTitans = new PriorityQueue<Titan>();
//		while (!laneTitans.isEmpty()) {
//			Titan titan = laneTitans.poll();
//				for(int i=0; i<count; i++) {
//				if (titan.getDistance() >= this.getMinRange() && titan.getDistance() <= this.getMaxRange()) {
//					resourcesValue+=titan.takeDamage(damage);
//				
//				if (titan.isDefeated()) {
//					resourcesValue += titan.getResourcesValue();
//				} else {
//					currentTitans.add(titan);
//				}
//				
//			}
//				}
//		}
//		laneTitans.addAll(currentTitans);
//		return resourcesValue;
//	}
	
	public int turnAttack(PriorityQueue<Titan> laneTitans) {
		int resourcesGathered = 0;
		ArrayList<Titan> t = new ArrayList<Titan>();

		while (laneTitans.isEmpty() == false) {
			t.add(laneTitans.poll());
		}
		for (int i = 0; i < t.size(); i++) {
			if (t.get(i).getDistance() >= this.getMinRange() && t.get(i).getDistance() <= this.getMaxRange()) {
				attack(t.get(i));
				if (t.get(i).isDefeated() == true)
					resourcesGathered += t.get(i).getResourcesValue();
				else
					laneTitans.add(t.get(i));
			} else
				laneTitans.add(t.get(i));

		}

		return resourcesGathered;
	}
}
