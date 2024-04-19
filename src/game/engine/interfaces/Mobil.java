package game.engine.interfaces;

import game.engine.titans.Titan;

public interface Mobil {
	
	 int getDistance();
	 void setDistance(int distance);
	 int getSpeed();
	 void setSpeed(int speed);

	 //not finished
	 default boolean hasReachedTarget(){
		 return Titan.equals(getDistance());
		}

	   
	 default boolean move(){
		 getDistance().moveTowards(setDistance());
         return hasReachedTarget();
        }

}
