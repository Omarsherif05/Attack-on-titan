package game.engine.weapons.factory;

import java.io.IOException;
import java.util.HashMap;
import game.engine.dataloader.DataLoader;
import game.engine.exceptions.InsufficientResourcesException;
import game.engine.weapons.Weapon;
import game.engine.weapons.WeaponRegistry;

public class WeaponFactory {

	private final HashMap<Integer, WeaponRegistry> weaponShop;

	public WeaponFactory() throws IOException {
		this.weaponShop = DataLoader.readWeaponRegistry();
	}

	public HashMap<Integer, WeaponRegistry> getWeaponShop() {
		return weaponShop;
	}

	public FactoryResponse buyWeapon(int resources, int weaponCode) throws InsufficientResourcesException {
		int remainingResources;
		if (!weaponShop.containsKey(weaponCode)) {
			throw new IllegalArgumentException("This weapon code doesn't exist");
		}
		WeaponRegistry weaponData = weaponShop.get(weaponCode);
		int weaponPrice = weaponData.getPrice();
		if (resources < weaponPrice) {
			throw new InsufficientResourcesException(resources);
		} else {
			Weapon weapon = weaponData.buildWeapon();
			remainingResources = resources - weaponPrice;
			return new FactoryResponse(weapon, remainingResources);
		}
	}

	public void addWeaponToShop(int code, int price) {
		weaponShop.put(code, new WeaponRegistry(code, price));
	}

	public void addWeaponToShop(int code, int price, int damage, String name) {
		weaponShop.put(code, new WeaponRegistry(code, price, damage, name));
	}

	public void addWeaponToShop(int code, int price, int damage, String name, int minRange, int maxRange) {
		weaponShop.put(code, new WeaponRegistry(code, price, damage, name, minRange, maxRange));
	}
}
