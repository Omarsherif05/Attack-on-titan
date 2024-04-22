package game.engine.weapons;


public class WeaponRegistry {

	private final int code;
	private final int price;
	private int damage;
	private String name;
	private int minRange;
	private int maxRange;

	public WeaponRegistry(int code, int price) {
		this.code = code;
		this.price = price;
	}

	public WeaponRegistry(int code, int price, int damage, String name) {
		this(code, price);
		this.damage = damage;
		this.name = name;
	}

	public WeaponRegistry(int code, int price, int damage, String name, int minRange, int maxRange) {
		this(code, price, damage, name);
		this.minRange = minRange;
		this.maxRange = maxRange;
	}

	public int getCode() {
		return code;
	}

	public int getPrice() {
		return price;
	}

	public int getDamage() {
		return damage;
	}

	public String getName() {
		return name;
	}

	public int getMinRange() {
		return minRange;
	}

	public int getMaxRange() {
		return maxRange;
	}

	public Weapon buildWeapon() {
		switch (code) {
		case 1:
			return new PiercingCannon(getDamage());
		case 2:
			return new SniperCannon(getDamage());
		case 3:
			return new VolleySpreadCannon(getDamage(), getMinRange(), getMinRange());
		case 4:
			return new WallTrap(getDamage());
		default:
			return null;

		}
	}
}
