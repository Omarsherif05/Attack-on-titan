package game.engine.titans;

public abstract class Titan implements Comparable{
    protected final int baseHealth;
    protected int currentHealth;
    protected final int baseDamage;
    protected final int heightInMeters;
    protected int distanceFromBase;
    protected int speed;
    protected final int resourcesValue;
    protected final int dangerLevel;
   
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

	public int compareTo(Titan otherTitan) {
	    if (this.distanceFromBase < otherTitan.distanceFromBase) {
	        return -1;
	    } else if (this.distanceFromBase > otherTitan.distanceFromBase) {
	        return 1;
	    } else {
	        return 0;
	    }
	}
    public abstract void move();

    public abstract void attack();

    public abstract void getsAttacked();
}
