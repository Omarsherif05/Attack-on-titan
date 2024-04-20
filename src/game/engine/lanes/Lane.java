package game.engine.lanes;

import java.util.ArrayList;
import java.util.PriorityQueue;
import game.engine.weapons.*;
import game.engine.Battle;
import game.engine.base.Wall;
import game.engine.interfaces.Attackee;
import game.engine.interfaces.Attacker;
import game.engine.interfaces.Mobil;
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
		titans.add(titan);
	}

	public void addWeapon(Weapon weapon) {
		weapons.add(weapon);
	}

	public void moveLaneTitans() {
		while (!titans.isEmpty()) {
			if (!((Mobil) titans).hasReachedTarget()) {
				((Mobil) titans).move();
			}
		}

<<<<<<< HEAD
	 public int performLaneTitansAttacks(){
		if(((Mobil) titans).hasReachedTarget()&&titans.isEmpty())
		return Battle.getResourcesGathered();
	 }
=======
	}

	public int performLaneTitansAttacks() {
		if (((Mobil) titans).hasReachedTarget())

			return Battle.getResourcesGathered();
	}
>>>>>>> 4a3d6e71b9f79fbf807f7640f8d51396eb6b70ab

}
