package game.engine;

import java.io.IOException;

public class BattleSingleton {
    private static Battle instance;

    private BattleSingleton() {}

    public static Battle getInstance() throws IOException {
        if (instance == null) {
            instance = new Battle(1, 0, 0, 3, 250);
            instance.initializeLanes(3);
        }
        return instance;
        
    }
}

