package game.engine.weapons.factory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import game.engine.weapons.WeaponRegistry;

public class WeaponFactory {
    
    private final HashMap<Integer, WeaponRegistry> weaponShop;

    
    public WeaponFactory() throws IOException {
        this.weaponShop = readWeaponRegistry();
    }

    
    private HashMap<Integer, WeaponRegistry> readWeaponRegistry() throws IOException {
        HashMap<Integer, WeaponRegistry> weaponMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("weapons.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                
                int code = Integer.parseInt(data[0]);
                int price = Integer.parseInt(data[1]);
                int damage = Integer.parseInt(data[2]);
                String name = data[3];
                int minRange = 0;
                int maxRange = 0;
                if (data.length == 6) { 
                    minRange = Integer.parseInt(data[4]);
                    maxRange = Integer.parseInt(data[5]);
                }
                WeaponRegistry weapon = new WeaponRegistry(code, price, damage, name, minRange, maxRange);
                weaponMap.put(code, weapon);
            }
        }
        return weaponMap;
    }

    public HashMap<Integer, WeaponRegistry> getWeaponShop() {
        return weaponShop;
    }
}
