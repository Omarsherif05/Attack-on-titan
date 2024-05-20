package game.engine;

import java.io.IOException;

import game.engine.base.Wall;

public class BattleSingleton {
    private static Battle instance;
    private static Wall wall;

    private BattleSingleton() {}

    public static Battle getInstance() throws IOException {
        if (instance == null) {
            instance = new Battle(1, 0, 0, 3, 250);
            instance.initializeLanes(3);
            
        }
        return instance;
        
    }
    public static Wall getInstance2() throws IOException {
        if (wall == null) {
        	wall = new Wall(1000);
        }
        return wall;
        
    }
}

