package game.engine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

import game.engine.lanes.Lane;
import game.engine.titans.Titan;
import game.engine.titans.TitanRegistry;
import game.engine.weapons.factory.WeaponFactory;

public class Battle {
    private final int PHASES_APPROACHING_TITANS[][]= new int[2][2];
    PHASES_APPROACHING_TITANS[1][1]=1;
    PHASES_APPROACHING_TITANS[1][2]=2;
    PHASES_APPROACHING_TITANS[2][1]=3;
    PHASES_APPROACHING_TITANS[2][2]=4;
    private final int WALL_BASE_HEALTH =10000;
    private int numberOfTurns ;
    private int resourcesGathered ;
    private BattlePhase battlePhase =BattlePhase.EARLY;
    private int numberOfTitansPerTurn=1;  
    private int score;
    private int titanSpawnDistance =1;
    private final WeaponFactory weaponFactory;
    //
    private final HashMap<Integer, TitanRegistry> titansArchives;
    private final ArrayList<Titan> approachingTitans ;
    private final PriorityQueue<Lane> lanes =new PriorityQueue<>(Lane.dangerLevel);
    private final ArrayList<Lane> originalLanes ;

    private Battle(int numberOfTurns, int score, int titanSpawnDistance, int initialNumOfLanes,int initialResourcesPerLane) throws IOException {
        this.numberOfTurns=numberOfTurns;
        this.score=score;
        this.titanSpawnDistance=titanSpawnDistance;
        this.resourcesGathered=initialNumOfLanes;
        this.initialResourcesPerLane= initialResourcesPerLane;
    }
    //last method 
    //last element in constructor
    //hashmap
}
