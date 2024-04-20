package game.engine.weapons;

import java.util.PriorityQueue;

import game.engine.titans.Titan;

public class PiercingCannon extends Weapon{

	public static final int WEAPON_CODE = 1;

	public PiercingCannon(int baseDamage) {
		super(baseDamage);
		
	}

	@Override
	public int turnAttack(PriorityQueue<Titan> laneTitans) {
		// TODO Auto-generated method stub
		return 0;
	}

}
