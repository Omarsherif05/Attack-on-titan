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

	@Override
	public int turnAttack(PriorityQueue<Titan> laneTitans) {
		// TODO Auto-generated method stub
		return 0;
	}

   


}
