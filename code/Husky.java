// This class represent the Husky, which will infect if an enemy is in front,
// otherwise hop if possibl, otherwise it will turn left. It show a "Husky" at
// the step 0, and it will gather together when there is an another husky in front
// it will show different strings, each strings depends on the facing direction of 
// previous step and it will show in color purple. 

import java.awt.*;

public class Husky extends Critter {
   private int direction;
   
   // This is the constructor of Husky class which initialize the value for the fields.
   public Husky() {
      this.direction = -1;
   }
   
   // This method override the critter's default method it will make Husky infected when it 
   // encounter an enemy and it will hop if possible, or it will turn left otherwise 
   // parameters needed: CritterInfo info - to 
   public Action getMove(CritterInfo info) {
      if (info.getDirection() == Direction.NORTH) {
         direction = 0;
      }
      else if (info.getDirection() == Direction.SOUTH) {
         direction = 1;
      } else if (info.getDirection() == Direction.WEST) {
         direction = 2;
      } else {
         direction = 3;
      }
      
      if (info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
      } else if (info.getFront() == Neighbor.WALL || 
                 info.getRight() == Neighbor.WALL) {
         return Action.LEFT;
      } else if (info.getFront() == Neighbor.SAME) {
         direction = 4;
         return Action.HOP;
      } else {
         return Action.HOP;
      }
   }
   
   // This method override the Critter's default method and return a purple. 
   // parameters needed: nothing.
   // return: color - purple. 
   public Color getColor() {
      return new Color(102, 0, 153);
   }
   
   // This method override the Critter's default method and return a Husky String 
   // on the drawing panel.
   // return: different strings based on the previous direction of the husky.
   public String toString() {
      if (direction == 0) {
         return "U - H - U";
      } else if (direction == 1){
         return "Y - H - Y";
      } else if (direction == 2) {
         return "W - H - W";
      } else if (direction == 3) {
         return "E - H - E";
      } else if (direction == 4) {
         return "Friend!!";
      } else {
         return "Husky!!";
      } 
   }
}