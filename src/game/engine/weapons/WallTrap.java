package game.engine.weapons;

import java.util.PriorityQueue;

import game.engine.titans.Titan;

public class WallTrap extends Weapon {

	public static final int WEAPON_CODE = 4;

	public WallTrap(int baseDamage) {
		super(baseDamage);
	}

	public int turnAttack(PriorityQueue<Titan> laneTitans) {
		PriorityQueue<Titan> secondQueue = new PriorityQueue<>(
				(titan1, titan2) -> Integer.compare(titan1.getDistance(), titan2.getDistance()));
		Titan currentTitan = secondQueue.peek();
		int damage = this.getDamage();
		currentTitan.takeDamage(damage);
		if (currentTitan.isDefeated() && currentTitan.hasReachedTarget()) {
			secondQueue.remove();
			return currentTitan.getResourcesValue();
		}
		return 0;
	}

}
