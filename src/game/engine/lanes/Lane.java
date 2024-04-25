package game.engine.lanes;

import java.util.ArrayList;

import java.util.PriorityQueue;
import game.engine.weapons.*;
import game.engine.base.Wall;
import game.engine.titans.Titan;

public class Lane implements Comparable<Lane> {
	private final Wall laneWall;
	private int dangerLevel;
	private final PriorityQueue<Titan> titans;
	private final ArrayList<Weapon> weapons;

	public Wall getLaneWall() {
		return laneWall;
	}

	public int getDangerLevel() {
		return dangerLevel;
	}

	public void setDangerLevel(int dangerLevel) {
		this.dangerLevel = dangerLevel;
	}

	public PriorityQueue<Titan> getTitans() {
		return titans;
	}

	public ArrayList<Weapon> getWeapons() {
		return weapons;
	}

	public Lane(Wall laneWall) {
		this.laneWall = laneWall;
		this.dangerLevel = 0;
		this.titans = new PriorityQueue<>();
		this.weapons = new ArrayList<>();
	}

	public int compareTo(Lane lane) {
		return Integer.compare(this.dangerLevel, lane.dangerLevel);
	}

	public void addTitan(Titan titan) {
		if (titan != null) {
			titans.add(titan);
		}
	}

	public void addWeapon(Weapon weapon) {
		if (weapon != null) {
			weapons.add(weapon);
		}
	}

	public void moveLaneTitans() {
		PriorityQueue<Titan> updatedTitans = new PriorityQueue<Titan>();
		while (!titans.isEmpty()) {
			Titan currentTitan = titans.poll();
			updatedTitans.add(currentTitan);
			if (!(currentTitan.hasReachedTarget()) && !currentTitan.isDefeated()) {
				currentTitan.move();
			}
		}
		titans.addAll(updatedTitans);
	}

	public int performLaneTitansAttacks() {
		int totalResourcesGathered = 0;
		if (!titans.isEmpty()) {
			for (Titan titan : titans) {
				if (titan.hasReachedTarget()) {
					totalResourcesGathered += titan.attack(laneWall);
				}
			}
		}
		return totalResourcesGathered;
	}

	public int performLaneWeaponsAttacks() {
		int totalResourcesGathered = 0;
		if (!weapons.isEmpty()) {
			for (Weapon weapon : weapons) {
				totalResourcesGathered += (weapon).turnAttack(titans);
			}
		}
		return totalResourcesGathered;
	}

	public boolean isLaneLost() {
		if (laneWall.getCurrentHealth() <= 0) {
			return true;
		}
		return false;
	}

	public void updateLaneDangerLevel() {
		int danger = 0;
		if (!titans.isEmpty()) {
			for (Titan titan : titans) {
				danger += titan.getDangerLevel();
			}
		}
		this.setDangerLevel(danger);
	}
}