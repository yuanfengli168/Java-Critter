// This class is one of the critters that represents the Giant, which has gray color
// it infect if an enemy is in front, otherwise hop if possible, otherwise turn right
// it will represent as "fee" for 6 moves, then "fie" for 6 moves, then "foe" for 6 
// moves, then "fum" for 6 moves, then repeat. 

import java.awt.*;

public class Giant extends Critter {
   // step represents the current step
   private int step;
   
   // This is the constructor of Giant class which initialize the value for the fields.
   public Giant() {
      this.step = 0;
   }

   // This method override the critter's default, Giant will infect if an enemy is
   // in front, otherwise hop if possible, otherwise turn right. 
   // parameters needed: CritterInfor info - represent giant itself
   // return: Action - such as Action.INFECT/ Action.HOP / Action.RIGHT
   public Action getMove(CritterInfo info) {
      if (info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
      } else if (info.getFront() == Neighbor.EMPTY) {
         return Action.HOP;
      } else {
         return Action.RIGHT;
      }
   }
   
   // This method override the Critter's default method and return a gray.
   public Color getColor() {
      return Color.GRAY;
   }
   
   // This method will be overriden, and the result is:
   // "fee" for 6 moves, the "fie" for 6 moves, the "foe" for 6 moves,
   // then "fum" for 6 moves, then repeat.
   public String toString() {
      if (step < 6) {
         step++;
         return "fee";
      } else if (step < 12) {
         step++;
         return "fie";
      } else if (step < 18) {
         step++;
         return "foe";
      } else if (step < 23) {
         step++;
         return "fum";
      } else {
         step = 0;
         return "fum";
      }  
   }
   
}