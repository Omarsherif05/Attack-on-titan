package game.engine.lanes;
import java.util.ArrayList;
import java.util.PriorityQueue;
import game.engine.weapons.*;
import game.engine.base.Wall;
import game.engine.interfaces.Comparable;
import game.engine.titans.Titan;
public class Lane  {
     public final Wall laneWall =new  Wall(Wall.baseHealth);
     //
     protected int dangerLevel =0;
     PriorityQueue<Titan> titan =new PriorityQueue<>();
     final ArrayList<Weapon> weapons =new ArrayList<>();
     private Lane(Wall laneWall){
     this.laneWall=laneWall; 
     }
}
