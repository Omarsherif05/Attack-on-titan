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

}
