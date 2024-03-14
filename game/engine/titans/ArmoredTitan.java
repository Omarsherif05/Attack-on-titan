package game.engine.titans;

public class ArmoredTitan extends Titan{
	public static final int TITAN_CODE = 3;
	
	public ArmoredTitan(int baseHealth, int baseDamage, int heightInMeters, int distanceFromBase, int speed,
			int resourcesValue, int dangerLevel) {
		super(baseHealth, baseDamage, heightInMeters, distanceFromBase, speed, resourcesValue, dangerLevel);
		
	}

	
	public int getDistance() {
		return distanceFromBase;

	}

	
	public void setDistance(int distance) {
		this.distanceFromBase = distance;
		
	}

	
	public int getResourcesValue() {
		return resourcesValue;
	}

	
	public void move() {
		
		
	}

	
	public void attack() {
		
		
	}


	public void getsAttacked() {
		
		
	}
	
}
