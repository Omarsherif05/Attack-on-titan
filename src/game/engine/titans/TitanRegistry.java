package game.engine.titans;

import game.engine.dataloader.DataLoader;

public class TitanRegistry {

	private final int code;
	private final int baseHealth;
	private final int baseDamage;
	private final int heightInMeters;
	private final int speed;
	private final int resourcesValue;
	private final int dangerLevel;

	public TitanRegistry(int code, int baseHealth, int baseDamage, int heightInMeters, int speed, int resourcesValue,
			int dangerLevel) {
		this.code = code;
		this.baseHealth = baseHealth;
		this.baseDamage = baseDamage;
		this.heightInMeters = heightInMeters;
		this.speed = speed;
		this.resourcesValue = resourcesValue;
		this.dangerLevel = dangerLevel;
	}

	public int getCode() {
		return code;
	}

	public int getBaseHealth() {
		return baseHealth;
	}

	public int getBaseDamage() {
		return baseDamage;
	}

	public int getHeightInMeters() {
		return heightInMeters;
	}

	public int getSpeed() {
		return speed;
	}

	public int getResourcesValue() {
		return resourcesValue;
	}

	public int getDangerLevel() {
		return dangerLevel;
	}
	
	 public static Titan spawnTitan(int distanceFromBase, String registryCode, TitanRegistry registry) throws Exception {
	        if (registry == null || !registry.hasTitan(registryCode)) {
	            throw new Exception("Invalid Titan registry code: " + registryCode);
	        }

	        TitanData titanData = registry.getTitanData(registryCode);
	        return new Titan(
	                titanData.getBaseHealth(),
	                titanData.getBaseDamage(),
	                titanData.getHeightInMeters(),
	                distanceFromBase,
	                titanData.getSpeed(),
	                titanData.getResourcesValue(),
	                titanData.getDangerLevel());
	    }
}
