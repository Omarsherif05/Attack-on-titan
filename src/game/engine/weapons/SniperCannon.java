package game.engine.weapons;

import java.util.PriorityQueue;

import game.engine.titans.Titan;

public class SniperCannon extends Weapon {
	public static final int WEAPON_CODE = 2;

    public SniperCannon(int baseDamage) {
		super(baseDamage);
	}

	int turnAttack(PriorityQueue<Titan> laneTitans){
		Titan currentTitan =laneTitans.peek();
		int damage =this.getDamage();
		currentTitan.takeDamage(damage);
		if(currentTitan.isDefeated()){
			laneTitans.remove();
			return currentTitan.getResourcesValue();
		}
		return 0;
	}

    
}
