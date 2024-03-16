package game.engine.interfaces;

public interface Mobil {
	 int getDistance();
	 void setDistance(int distance);
	 int getSpeed();
	 void setSpeed(int speed);

	 
	 /*
	 default int getDistance(){
		 return distanceFromBase;
	 }
	 distance from the mobil and its target
	 

	 default  void setDistance(int distance){;
	 distanceFromBase=distance;
	 }


	 default int getSpeed(){
		 return speed;
	 }
	 

	  default void setSpeed(int speed){
		 this.speed=speed;	 }
	 }
		 */ 
}
