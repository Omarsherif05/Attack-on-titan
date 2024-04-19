package game.engine.interfaces;

import game.engine.titans.Titan;

public interface Mobil {
	
	 int getDistance();
	 void setDistance(int distance);
	 int getSpeed();
	 void setSpeed(int speed);

	 default boolean hasReachedTarget() {
        return getDistance() <= 0; 
    }

    
    default boolean move() {
        int distance = getDistance();
        int speed = getSpeed();
        setDistance(Math.max(distance - speed, 0));
		
        return hasReachedTarget();
    }
}
