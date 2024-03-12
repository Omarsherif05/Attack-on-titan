package game.engine.titans;

public class PureTitan extends Titan{
	private final int TITAN_CODE = 	1;

	public PureTitan(int baseHealth, int baseDamage, int heightInMeters, int distanceFromBase, int speed,int resourcesValue, int dangerLevel) {
		super(baseHealth, baseDamage, heightInMeters, distanceFromBase, speed, resourcesValue, dangerLevel);
	}
	
	public void move() {
		
	}

	public void attack() {
		
	}


	public void getsAttacked() {

		
	}

	public  int getDistance(){
	return distanceFromBase;
	}
	
	

	public  void setDistance(int distance){;
	distanceFromBase=distance;
	
	}


	public  int getSpeed(){
	return speed;
	}
	

	public void setSpeed(int speed){
	this.speed=speed;	 }

	
	public  int getResourcesValue(){
		return resourcesValue;
		}

		public int compareTo(Object o) {
			o =new PureTitan(baseHealth, baseDamage, heightInMeters, distanceFromBase, speed, resourcesValue, dangerLevel);
			if (this.distanceFromBase <o.distanceFromBase) {
				return -1;
			} else if (this.distanceFromBase > o.distanceFromBase) {
				return 1;
			} else {
				return 0;
			}
	}



///////compare to problem

}