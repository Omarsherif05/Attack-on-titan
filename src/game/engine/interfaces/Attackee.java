package game.engine.interfaces;
public interface Attackee {
	
	void setCurrentHealth(int currentHealth);
	int getCurrentHealth();
	int getResourcesValue();
	
    default boolean isDefeated() {
        return getCurrentHealth() <= 0;
    }
    default int takeDamage(int damage) {
    	setCurrentHealth((int)getCurrentHealth() - damage);
        if (isDefeated()) {
            return getResourcesValue(); 
        }
        return 0;
    }
}
