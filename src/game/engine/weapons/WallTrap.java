package game.engine.weapons;

import java.util.PriorityQueue;

import game.engine.titans.Titan;

public class WallTrap extends Weapon{
	
	public static final int WEAPON_CODE = 4;
	
    public WallTrap(int baseDamage) {
        super(baseDamage);
    }

    public int turnAttack(PriorityQueue<Titan> laneTitans) {
		Titan currentTitan = laneTitans.peek();
		int damage = this.getDamage();
		currentTitan.takeDamage(damage);
		if (currentTitan.isDefeated()) {
			laneTitans.remove();
			return currentTitan.getResourcesValue();
		}
		return 0;
	}


}
