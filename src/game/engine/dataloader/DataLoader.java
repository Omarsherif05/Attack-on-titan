package game.engine.dataloader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import game.engine.titans.TitanRegistry;
import game.engine.weapons.WeaponRegistry;

public class DataLoader {
    
    private static final String TITANS_FILE_NAME = "titans.csv";
    private static final String WEAPONS_FILE_NAME = "weapons.csv";

    
    public static ArrayList<TitanRegistry> loadTitans() {
        ArrayList<TitanRegistry> titans = new ArrayList<>();
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
                titans.add(titan);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return titans;
    }

    
    public static ArrayList<WeaponRegistry> loadWeapons() {
        ArrayList<WeaponRegistry> weapons = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(WEAPONS_FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int code = Integer.parseInt(data[0]);
                int price = Integer.parseInt(data[1]);
                int damage = Integer.parseInt(data[2]);
                String name = data[3];
                int minRange = Integer.parseInt(data[4]);
                int maxRange = Integer.parseInt(data[5]);
                WeaponRegistry weapon = new WeaponRegistry(code, price, damage, name, minRange, maxRange);
                weapons.add(weapon);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weapons;
    }
}
