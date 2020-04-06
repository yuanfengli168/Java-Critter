// This defines a class of critters that represents the Lion, it will infect when if confront
// an enemy, or it will turn left when there is a wall in front of it or on the right of it,
// it will turn right when another lion is in front of it, it will hop if possible, and finally
// it will randomly pick up its color for every 3 steps from the beginning from red, green, and 
// blue.

import java.awt.*;
import java.util.*;

public class Lion extends Critter {
   Random random = new Random();
   private int step;
   private int color;
   
   // This is the constructor of Lion class which initialize the value for the fields.
   public Lion() {
      this.step = 0;
      this.color = random.nextInt(3);
   }
   // This method override the critter's default method, Lion will infect when there is an enemy
   // in front of it, and it will turn to the left when there is wall in front of it or to the 
   // right, otherwise if a fellow Lion is in front, then turn right, Otherwise hop.
   // Parameters needed: CritterInfo info - the critter beside it.  
   // return: It returns different Actions such as infect, turn left, turn right, or hop.
   public Action getMove(CritterInfo info) {
      step++;
      if (info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
      } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
         return Action.LEFT;  
      } else if (info.getFront() == Neighbor.SAME) {
         return Action.RIGHT;
      } else {
         return Action.HOP;  
      }
   }
   
   // This method override the Critter's default method and return a random color from red, green,
   // and blue and use that color for three moves, then randomly pick one of those colors again 
   // for next three moves and so on
   // parameters needed: nothing
   // return: color - one of green, blue, or red.
   public Color getColor() {
      if (step % 3 == 0) {
         color = random.nextInt(3);
      } else {
         this.color = color;
      }
      
      if (color == 0) {
         return Color.RED;
      } else if (color == 1) {
         return Color.GREEN;
      } else {
         return Color.BLUE;
      }
   }
   
   // This method override the Critter's default method and return a "L" to represent the Lion
   public String toString() {
      return "L";
   }
}