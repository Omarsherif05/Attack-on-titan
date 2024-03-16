package game.engine.weapons;

public class WeaponRegistry {
   
    private final int code;
    private final int price;
    private final int damage;
    private final String name;
    private final int minRange;
    private final int maxRange;

   
    public WeaponRegistry(int code, int price) {
        this.code = code;
        this.price = price;
        this.damage = 0; 
        this.name = null; 
        this.minRange = 0; 
        this.maxRange = 0; 
    }

    
    public WeaponRegistry(int code, int price, int damage, String name) {
        this.code = code;
        this.price = price;
        this.damage = damage;
        this.name = name;
        this.minRange = 0; 
        this.maxRange = 0; 
    }

    
    public WeaponRegistry(int code, int price, int damage, String name, int minRange, int maxRange) {
        this.code = code;
        this.price = price;
        this.damage = damage;
        this.name = name;
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
}
