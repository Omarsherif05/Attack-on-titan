package game.engine.titans;

import game.engine.interfaces.Attackee; 
import game.engine.interfaces.Attacker;
import game.engine.interfaces.Mobil;

abstract public class Titan implements Comparable<Titan>,Mobil,Attacker,Attackee{
    private final int baseHealth;
    private int currentHealth;
    private final int baseDamage;
    private final int heightInMeters;
    private int distanceFromBase;
    private int speed;
    private final int resourcesValue;
    private final int dangerLevel;

    public Titan(int baseHealth, int baseDamage, int heightInMeters, int distanceFromBase, int speed, int resourcesValue, int dangerLevel) {
        this.baseHealth = baseHealth;
        this.baseDamage = baseDamage;
        this.heightInMeters = heightInMeters;
        this.distanceFromBase = distanceFromBase;
        this.speed = speed;
        this.resourcesValue = resourcesValue;
        this.dangerLevel = dangerLevel;
        this.currentHealth = Math.max(0,baseHealth);
    }

    

    public int getCurrentHealth() {
		return currentHealth;
	}



	public void setCurrentHealth(int currentHealth) {
        if(currentHealth<0)
        	this.currentHealth =0;
        else
        	this.currentHealth =currentHealth;
    }

    public int getDistance() {
        return distanceFromBase;
    }

    public void setDistance(int distanceFromBase) {
        this.distanceFromBase = distanceFromBase;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

	public int compareTo(Titan o) {
		return Integer.compare(this.distanceFromBase, o.distanceFromBase);
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
	
}

