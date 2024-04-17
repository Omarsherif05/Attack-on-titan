package game.engine.interfaces;
public interface Attackee {
	
	void setCurrentHealth(int currentHealth);
	int getCurrentHealth();
	int getResourcesValue();
	
    default boolean isDefeated() {
        return getCurrentHealth() <= 0;
    }
    //ERROR
    default int takeDamage(int damage) {
    	getCurrentHealth() = getCurrentHealth() - damage;
        if (isDefeated()) {
            return getResourcesValue(); 
        }
        return 0;
    }
}
