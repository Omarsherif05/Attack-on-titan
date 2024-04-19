package game.engine.interfaces;

public interface Mobil {
	
	 int getDistance();
	 void setDistance(int distance);
	 int getSpeed();
	 void setSpeed(int speed);

	 //not finished
	 default boolean hasReachedTarget(){
		 return getDistance().equals(setDistance(distance));
		}

	   
	 default boolean move(){
		 getDistance().moveTowards(setDistance());
         return hasReachedTarget();
        }
	 
	 default boolean hasReachedTarget() {
	        return getDistance() <= 0; // Assuming target is reached when distance is 0 or less
	    }
	 
	 default boolean move() {
	        int distance = getDistance();
	        int speed = getSpeed();

	       
	        setDistance(Math.max(distance - speed, 0));

	        return hasReachedTarget();
	    }
}
