package game.engine.titans;

public class AbnormalTitan extends Titan{
	public AbnormalTitan(int baseHealth, int baseDamage, int heightInMeters, int distanceFromBase, int speed, int resourcesValue, int dangerLevel){
		super(baseHealth, baseDamage, heightInMeters, distanceFromBase, speed, resourcesValue, dangerLevel);
	}
	//// depend on comparing element
	public int compareTo(Object o){
	o =new AbnormalTitan(baseHealth, baseDamage, heightInMeters, distanceFromBase, speed, resourcesValue, dangerLevel);
	return 0;	
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
}
