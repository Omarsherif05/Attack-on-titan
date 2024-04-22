package game.engine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

import game.engine.base.Wall;
import game.engine.dataloader.DataLoader;
import game.engine.lanes.Lane;
import game.engine.titans.Titan;
import game.engine.titans.TitanRegistry;
import game.engine.weapons.factory.WeaponFactory;

public class Battle {
	private static final int[][] PHASES_APPROACHING_TITANS = { { 1, 1, 1, 2, 1, 3, 4 }, { 2, 2, 2, 1, 3, 3, 4 },
			{ 4, 4, 4, 4, 4, 4, 4 } };
	private final static int WALL_BASE_HEALTH = 10000;
	private int numberOfTurns;
	private int resourcesGathered;
	private BattlePhase battlePhase = BattlePhase.EARLY;
	private int numberOfTitansPerTurn = 1;
	private int score;
	private int titanSpawnDistance = 1;
	private final WeaponFactory weaponFactory = new WeaponFactory();
	private final HashMap<Integer, TitanRegistry> titansArchives = DataLoader.readTitanRegistry();
	private final ArrayList<Titan> approachingTitans;
	private final PriorityQueue<Lane> lanes;
	private final ArrayList<Lane> originalLanes;

	public Battle(int numberOfTurns, int score, int titanSpawnDistance, int initialNumOfLanes,
			int initialResourcesPerLane) throws IOException {
		this.numberOfTurns = numberOfTurns;
		this.score = score;
		this.titanSpawnDistance = titanSpawnDistance;
		this.resourcesGathered = initialNumOfLanes * initialResourcesPerLane;
		this.lanes = new PriorityQueue<>();
		this.originalLanes = new ArrayList<>();
		this.approachingTitans = new ArrayList<>();
		initializeLanes(initialNumOfLanes);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getTitanSpawnDistance() {
		return titanSpawnDistance;
	}

	public void setTitanSpawnDistance(int titanSpawnDistance) {
		this.titanSpawnDistance = titanSpawnDistance;
	}

	public WeaponFactory getWeaponFactory() {
		return weaponFactory;
	}

	public PriorityQueue<Lane> getLanes() {
		return lanes;
	}

	public void setNumberOfTurns(int numberOfTurns) {
		this.numberOfTurns = numberOfTurns;
	}

	public int getNumberOfTurns() {
		return numberOfTurns;
	}

	public int getNumberOfTitansPerTurn() {
		return numberOfTitansPerTurn;
	}

	public void setNumberOfTitansPerTurn(int numberOfTitansPerTurn) {
		this.numberOfTitansPerTurn = numberOfTitansPerTurn;
	}

	public ArrayList<Titan> getApproachingTitans() {
		return approachingTitans;
	}

	public int getResourcesGathered() {
		return resourcesGathered;
	}

	public void setResourcesGathered(int resourcesGathered) {
		this.resourcesGathered = resourcesGathered;
	}

	public HashMap<Integer, TitanRegistry> getTitansArchives() {
		return titansArchives;
	}

	public ArrayList<Lane> getOriginalLanes() {
		return originalLanes;
	}

	public BattlePhase getBattlePhase() {
		return battlePhase;
	}

	public void setBattlePhase(BattlePhase battlePhase) {
		this.battlePhase = battlePhase;
	}

	private void initializeLanes(int numOfLanes) {
		for (int i = 0; i < numOfLanes; i++) {
			Wall wall = new Wall(WALL_BASE_HEALTH);
			Lane lane = new Lane(wall);
			this.lanes.add(lane);
			this.originalLanes.add(lane);

		}
	}

	public static int[][] getPhasesApproachingTitans() {
		return PHASES_APPROACHING_TITANS;
	}
	
	public void refillApproachingTitans(){
		approachingTitans.
	}
	public boolean isGameOver() {
	    for (Lane lane : lanes) {
	        if (lane.getLaneWall().isDefeated()) {
	            return true;
	        }
	    }
	    return false;
	}

}
