package game.engine;

import java.io.IOException;

public class BattleHard {

	  private static Battle instance;


	    private BattleHard() {}

	    public static Battle getInstance() throws IOException {
	        if (instance == null) {
	            instance = new Battle(1, 0, 0, 5, 125);
	            instance.initializeLanes(5);
	            
	        }
	        return instance;
	        
	    }
}
