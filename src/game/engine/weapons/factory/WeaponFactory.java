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
		if (!weaponShop.containsKey(weaponCode)) {
			throw new IllegalArgumentException("Invalid weapon code: " + weaponCode);
		}

		WeaponRegistry weaponData = weaponShop.get(weaponCode);
		int weaponPrice = weaponData.getPrice();

		if (resources < weaponPrice) {
			throw new InsufficientResourcesException(resources);
		}

		Weapon weapon = weaponData.buildWeapon();
		int remainingResources = resources - weaponPrice;

		return new FactoryResponse(weapon, remainingResources);
	}

	public void addWeaponToShop(int code, int price) {
		if (!weaponShop.containsKey(code)) {
			weaponShop.put(code, new WeaponRegistry(code, price));
			
		} else {
			throw new IllegalArgumentException("Weapon with code " + code + " already exists in the shop");
		}

	}

	public void addWeaponToShop(int code, int price, int damage, String name) {
		if (!weaponShop.containsKey(code)) {
			weaponShop.put(code, new WeaponRegistry(code, price, damage, name));
		} else {
			throw new IllegalArgumentException("Weapon with code " + code + " already exists in the shop");
		}

	}

	public void addWeaponToShop(int code, int price, int damage, String name, int minRange, int maxRange) {
		if (!weaponShop.containsKey(code)) {
			weaponShop.put(code, new WeaponRegistry(code, price, damage, name, minRange, maxRange));
		} else {
			throw new IllegalArgumentException("Weapon with code " + code + " already exists in the shop");
		}
	}
}
