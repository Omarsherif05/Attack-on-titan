package game.engine.lanes;
import java.util.ArrayList;
import java.util.PriorityQueue;
import game.engine.weapons.*;
import game.engine.base.Wall;
import game.engine.interfaces.Comparable;
import game.engine.titans.Titan;

public class Lane implements Comparable{
     public final Wall laneWall =new  Wall(Wall.baseHealth);
     public static int dangerLevel;
     protected final PriorityQueue<Titan> titans =new PriorityQueue<>();
     private final ArrayList<Weapon> weapons =new ArrayList<>();

     
     public Wall getLaneWall() {
         return laneWall;
     }

     public static int getDangerLevel() {
		return dangerLevel;
	}

	public static void setDangerLevel(int dangerLevel) {
		Lane.dangerLevel = dangerLevel;
	}

	public PriorityQueue<Titan> getTitan() {
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

     
     public int compareTo(Object o){
          o = new Lane(laneWall) ;
          if(this.Lane.dangerLevel<Lane.dangerLevel)
               return -1;
          if(this.Lane.dangerLevel>Lane.dangerLevel)
               return 1;
          else
               return 0;
     }

     
     
     
     
     
}
