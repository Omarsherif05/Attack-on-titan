package game.engine.titans;

import game.engine.interfaces.Attackee;
import game.engine.interfaces.Attacker;
import game.engine.interfaces.Comparable;
import game.engine.interfaces.Mobil;

public abstract class Titan implements Comparable,Mobil,Attacker,Attackee{
    protected final int baseHealth;
    protected int currentHealth;
    private final int baseDamage;
    private final int heightInMeters;
    protected int distanceFromBase;
    protected int speed;
    protected final int resourcesValue;
    protected final int dangerLevel;

    public Titan(int baseHealth, int baseDamage, int heightInMeters, int distanceFromBase, int speed, int resourcesValue, int dangerLevel) {
        this.baseHealth = baseHealth;
        this.baseDamage = baseDamage;
        this.heightInMeters = heightInMeters;
        this.distanceFromBase = distanceFromBase;
        this.speed = speed;
        this.resourcesValue = resourcesValue;
        this.dangerLevel = dangerLevel;
        this.currentHealth = baseHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getDistanceFromBase() {
        return distanceFromBase;
    }

    public void setDistanceFromBase(int distanceFromBase) {
        this.distanceFromBase = distanceFromBase;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

	public int compareTo(Titan o) {
	    if (this.distanceFromBase < o.distanceFromBase) {
	        return -1;
	    } else if (this.distanceFromBase > o.distanceFromBase) {
	        return 1;
	    } else {
	        return 0;
	    }
	}
    public int getBaseHealth() {
		return baseHealth;
	}

	public int getDamage() {
		return baseDamage;
	}

	public int getHeightInMeters() {
		return heightInMeters;
	}

	public int getResourcesValue() {
		return resourcesValue;
	}

	public int getDangerLevel() {
		return dangerLevel;
	}

	public abstract void move();

    public abstract void attack();

    public abstract void getsAttacked();
}

