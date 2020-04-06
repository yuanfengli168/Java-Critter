// This defines a class of critters that represents the bear, there are two types
// of bear, the first type is a polar bear, and the second type is another bear with 
// black skin, and bear will infect if an enemy is in front, otherwise hop if possible
// otherwise turn left.

import java.awt.*;

public class Bear extends Critter {
   private boolean polar;
   private String move;
   
   // This is the constructor of Bear class which initialize the value for the fields.
   public Bear(boolean polar) {
      this.polar = polar;
      this.move = "/";
   }
   
   // This method override the critter's default, Bear will infect if an enemy is
   // in front, otherwise hop if possible, otherwise turn left. 
   // parameters needed: CritterInfor info - represent bear itself
   // return: Action - such as Action.INFECT/ Action.HOP / Action.LEFT
   public Action getMove(CritterInfo info) {
      if (info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
      } else if (info.getFront() == Neighbor.EMPTY) {
         return Action.HOP;
      } else {
         return Action.LEFT;
      }
   }
   
   // This method override the Critter's default method and return color depend on
   // what kind of bear it is. 
   // parameters needed: nothing.
   // return: color - white/black; if the polar is true, it will return white.
   // if the polar is not true, it will return black. 
   public Color getColor() {
      if (polar) {
         return Color.WHITE;
      } else {
         return Color.BLACK;
      }
   }
   
   // This method override the Critter's default method and return a Husky String 
   // on the drawing panel.
   // return: "\" "/" alternatively when it moves.
   public String toString() {
      if (move.equals("\\")) {
         move = "/";
         return "/";
      } else {
         move = "\\";
         return "\\";
      }
   }

}