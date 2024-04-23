package game.engine;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

import game.engine.base.Wall;
import game.engine.dataloader.DataLoader;
import game.engine.exceptions.InsufficientResourcesException;
import game.engine.exceptions.InvalidLaneException;
import game.engine.lanes.Lane;
import game.engine.titans.Titan;
import game.engine.titans.TitanRegistry;
import game.engine.weapons.Weapon;
import game.engine.weapons.factory.FactoryResponse;
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

	public void refillApproachingTitans() {
		int[] approachingTitansarray = PHASES_APPROACHING_TITANS[battlePhase.ordinal()];
		for (int index : approachingTitansarray) {
			TitanRegistry x = titansArchives.get(index);
			if (x != null) {
				Titan titan = x.spawnTitan(index);
				if (titan != null) {
					approachingTitans.add(titan);

				}
			}

		}
	}

	public void purchaseWeapon(int weaponCode, Lane lane) throws InsufficientResourcesException, InvalidLaneException {
		if (!lanes.contains(lane)) {
			throw new InvalidLaneException("Lane doesn't exist");
		}
		if (!lane.isLaneLost()) {

			FactoryResponse Factoryresponsex;
			 WeaponFactory.buyWeapon(, weaponCode);

			this.performWeaponsAttacks();
			this.performTitansAttacks();
			this.updateLanesDangerLevels();
			this.finalizeTurns();
		}
		// if(weaponCode==null) {
		// throw new InvalidLaneException();
		// }

	}

	public void passTurn() {
		performTurn();
	}

	private void addTurnTitansToLane() {
		int TitansPerTurnNumber = numberOfTitansPerTurn;
		Lane leastDangerlane = lanes.poll();
		PriorityQueue<Titan> titans = leastDangerlane.getTitans();
		for (int i = TitansPerTurnNumber; i > 0; i--) {
			if (approachingTitans.isEmpty()) {
				refillApproachingTitans();
			}
			Titan currentTitan = approachingTitans.remove(0);
			titans.add(currentTitan);
		}
		lanes.add(leastDangerlane);

	}

	private void moveTitans() {
		PriorityQueue<Lane> newLanesValue = new PriorityQueue<Lane>();
		if (!lanes.isEmpty()) {
			for (int i = 0; i < lanes.size(); i++) {
				Lane currentLane = lanes.poll();
				if (!currentLane.isLaneLost()) {
					currentLane.moveLaneTitans();
					newLanesValue.add(currentLane);
					currentLane = lanes.poll();
				}
			}
			lanes.addAll(newLanesValue);
		}
	}

	private int performWeaponsAttacks() {
		int totalResourcesGathered = 0;
		PriorityQueue<Lane> newLanesValue = new PriorityQueue<Lane>();
		if (!lanes.isEmpty()) {
			for (int i = 0; i < lanes.size(); i++) {
				Lane currentLane = lanes.poll();
				if (!currentLane.isLaneLost()) {
					totalResourcesGathered += currentLane.performLaneWeaponsAttacks();
					newLanesValue.add(currentLane);
				}
			}
		}
		lanes.addAll(newLanesValue);
		return totalResourcesGathered;
	}

	private int performTitansAttacks() {
		int resources = 0;
		for (Lane lane : lanes) {
			if (!lane.isLaneLost()) {
				for (Titan titan : lane.getTitans()) {
					titan.attack(lane.getLaneWall());
					if (lane.getLaneWall().isDefeated()) {
						resources += lane.getLaneWall().getResourcesValue();
					}
				}
			}
		}
		return resources;

	}

	private void updateLanesDangerLevels() {
		int totalDangerLevel = 0;
		for (Lane lane : lanes) {
			if (!lane.isLaneLost()) {
				for (Titan titan : lane.getTitans()) {
					totalDangerLevel += titan.getDangerLevel();
				}
				lane.setDangerLevel(totalDangerLevel);
			}
		}
	}

	private void finalizeTurns() {
		numberOfTurns++;
		if (numberOfTurns < 15) {
			battlePhase = BattlePhase.EARLY;
		} else if (numberOfTurns < 30) {
			battlePhase = BattlePhase.INTENSE;
		} else {
			battlePhase = BattlePhase.GRUMBLING;
			if (numberOfTurns >= 30 && numberOfTurns % 5 == 0) {
				numberOfTitansPerTurn *= 2;
			}
		}
	}

	private void performTurn() {
		if (isGameOver()) {
			return;
		}else {
			moveTitans();
		performWeaponsAttacks();
		performTitansAttacks();
		addTurnTitansToLane();
		updateLanesDangerLevels();
		finalizeTurns();
		}
	}

	public boolean isGameOver() {
		if (lanes.isEmpty()) {
			return true;
		}
		return false;
	}

}