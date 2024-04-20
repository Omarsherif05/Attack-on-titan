package game.engine.interfaces;

public interface Mobil {

	int getDistance();

	void setDistance(int distance);

	int getSpeed();

	void setSpeed(int speed);

	
	 default boolean hasReachedTarget() {
		return getDistance() <= 0;
	}

	public default boolean move() {
		int distance = getDistance();
		int speed = getSpeed();

		setDistance(Math.max(distance - speed, 0));

		return hasReachedTarget();
	}
}
