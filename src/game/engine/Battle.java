package game.engine;

import java.io.IOException;
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

	public void initializeLanes(int numOfLanes) {
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
		ArrayList<Titan> updatedTitans = new ArrayList<>();
		switch (battlePhase) {
		case EARLY:
			for (int titanCode : PHASES_APPROACHING_TITANS[0]) {
				Titan currentTitan = titansArchives.get(titanCode).spawnTitan(titanSpawnDistance);
				updatedTitans.add(currentTitan);
			}
			break;
		case INTENSE:
			for (int titanCode : PHASES_APPROACHING_TITANS[1]) {
				Titan currentTitan = titansArchives.get(titanCode).spawnTitan(titanSpawnDistance);
				updatedTitans.add(currentTitan);
			}
			break;
		case GRUMBLING:
			for (int titanCode : PHASES_APPROACHING_TITANS[2]) {
				Titan currentTitan = titansArchives.get(titanCode).spawnTitan(titanSpawnDistance);
				updatedTitans.add(currentTitan);
			}
			break;
		default:
			break;
		}
		approachingTitans.addAll(updatedTitans);
	}

	public void purchaseWeapon(int weaponCode, Lane lane)
			throws InsufficientResourcesException, InvalidLaneException, IOException {
		if (!lanes.contains(lane) || lane.isLaneLost()) {
			throw new InvalidLaneException();
		}
		WeaponFactory weaponFactory = new WeaponFactory();
		FactoryResponse factoryResponse = weaponFactory.buyWeapon(this.getResourcesGathered(), weaponCode);
		setResourcesGathered(factoryResponse.getRemainingResources());
		lane.addWeapon(factoryResponse.getWeapon());
		performTurn();
	}

	public void passTurn() {
		performTurn();
	}

	private void addTurnTitansToLane() {
		int numberOfTitans = numberOfTitansPerTurn;
		if (!lanes.isEmpty()) {
			Lane leastDangerousLane = lanes.poll();
			PriorityQueue<Titan> currentTitans = leastDangerousLane.getTitans();
			if (!leastDangerousLane.isLaneLost()) {
				for (int i = numberOfTitans; i > 0; i--) {
					if (approachingTitans.isEmpty()) {
						refillApproachingTitans();
					}
					Titan currentTitan = approachingTitans.remove(0);
					currentTitans.add(currentTitan);
				}
			}
			lanes.add(leastDangerousLane);
		}

	}

	private void moveTitans() {
		if (!lanes.isEmpty()) {
			for (Lane lane : lanes) {
				if (!lane.isLaneLost()) {
					lane.moveLaneTitans();
				}
			}
		}
	}

	private int performWeaponsAttacks() {
		int totalResourcesGathered = 0;
		PriorityQueue<Lane> newLanesValue = new PriorityQueue<Lane>();
		while (!lanes.isEmpty()) {
			Lane currentLane = lanes.poll();
			if (!currentLane.isLaneLost()) {
				totalResourcesGathered += currentLane.performLaneWeaponsAttacks();
				if (!currentLane.isLaneLost()) {
					newLanesValue.add(currentLane);
				}
			}
		}
		lanes.addAll(newLanesValue);
		this.resourcesGathered += totalResourcesGathered;
		this.score += totalResourcesGathered;
		return totalResourcesGathered;
	}

	private int performTitansAttacks() {
		int resources = 0;
		PriorityQueue<Lane> updatedLane = new PriorityQueue<Lane>();
		while (!lanes.isEmpty()) {
			Lane currentLane = lanes.poll();
			if (!currentLane.isLaneLost()) {
				resources += currentLane.performLaneTitansAttacks();
				if (!currentLane.isLaneLost()) {
					updatedLane.add(currentLane);
				}
				
			}
		}
		lanes.addAll(updatedLane);
		
		return resources;
	}

	private void updateLanesDangerLevels() {
		PriorityQueue<Lane> updatedLanes = new PriorityQueue<Lane>();
		while (!lanes.isEmpty()) {
			Lane currentLane = lanes.poll();
			if (!currentLane.isLaneLost()) {
				currentLane.updateLaneDangerLevel();
				updatedLanes.add(currentLane);
			}
		}
		lanes.addAll(updatedLanes);
	}

	private void finalizeTurns() {
		numberOfTurns++;
		if (numberOfTurns < 15) {
			battlePhase = BattlePhase.EARLY;
		} else if (numberOfTurns < 30) {
			battlePhase = BattlePhase.INTENSE;
		} else {
			battlePhase = BattlePhase.GRUMBLING;
			if (numberOfTurns > 30 && numberOfTurns % 5 == 0) {
				numberOfTitansPerTurn *= 2;
			}
		}
	}

	private void performTurn() {
		if (isGameOver()) {
			return;
		} else {
			moveTitans();
			performWeaponsAttacks();
			performTitansAttacks();
			addTurnTitansToLane();
			updateLanesDangerLevels();
			finalizeTurns();
		}
	}

	public boolean isGameOver() {
		for (Lane lane : lanes) {
			if (!lane.isLaneLost()) {
				return false;
			}
		}
		return true;
	}

}