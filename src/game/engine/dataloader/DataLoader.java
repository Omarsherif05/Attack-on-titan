package game.engine.dataloader;

import game.engine.titans.TitanRegistry;
import game.engine.weapons.WeaponRegistry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class DataLoader {
   
    private static final String TITANS_FILE_NAME = "titans.csv";
    private static final String WEAPONS_FILE_NAME = "weapons.csv";

    
    public static HashMap<Integer, TitanRegistry> readTitanRegistry() throws IOException {
        HashMap<Integer, TitanRegistry> titanMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(TITANS_FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int code = Integer.parseInt(data[0]);
                int baseHealth = Integer.parseInt(data[1]);
                int baseDamage = Integer.parseInt(data[2]);
                int heightInMeters = Integer.parseInt(data[3]);
                int speed = Integer.parseInt(data[4]);
                int resourcesValue = Integer.parseInt(data[5]);
                int dangerLevel = Integer.parseInt(data[6]);
                TitanRegistry titan = new TitanRegistry(code, baseHealth, baseDamage, heightInMeters, speed, resourcesValue, dangerLevel);
                titanMap.put(code, titan);
            }
        }
        return titanMap;
    }

    
    public static HashMap<Integer, WeaponRegistry> readWeaponRegistry() throws IOException {
        HashMap<Integer, WeaponRegistry> weaponMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(WEAPONS_FILE_NAME))) {
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
                WeaponRegistry weapon;
                if (data.length == 4) {
                    weapon = new WeaponRegistry(code, price, damage, name);
                } else {
                    weapon = new WeaponRegistry(code, price, damage, name, minRange, maxRange);
                }
                weaponMap.put(code, weapon);
            }
        }
        return weaponMap;
    }
}
