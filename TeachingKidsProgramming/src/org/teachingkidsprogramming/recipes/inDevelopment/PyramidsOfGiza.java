package org.teachingkidsprogramming.recipes.inDevelopment;

import org.teachingextensions.logo.Tortoise;
//  NOTE: this might need to be broken into several different recipes??
//  e.g. PyramidsOfGiza01, PyramidsOfGiza02, PyramidsOfGiza03, etc...
//  This is a very simple/basic recipe introducing passing multiple values 
//  into methods and reinforcing basic refactoring.
//  This can be completed in several 'passes' or 'steps of refactoring' as follows:
//
//  1. entire recipe written in linear fashion with lots of repeated code
//  2.  a) turnAndMove() method created 
//      b) every 2 linear turn() and move() calls are replaced by 1 call to new turnAndMove() method
//  3. Now another pattern emerges, and a 3rd refactoring/abstraction takes place
//      when the student notices that there are several each of 
//      turnAndMove(90, 100) & turnAndMove(-90, 100), so 2 new methods are written:
//      turnAndMove(90, 100) becomes -> moveDown() & turnAndMove(-90, 100) -> moveUp()
//  4. At this point, students are encouraged to see if there might be any other possible patterns
//      to refactor

//  Where to add?  In Course 1 or Course 2 - concepts taught: refactoring
public class PyramidsOfGiza
{
  public static void main(String[] args) throws Exception
  {
    Tortoise.show();
    Tortoise.setSpeed(10);
    turnAndMove(-90, 220);
    // Tortoise.turn(-90); 
    // Tortoise.move(220);
    turnAndMove(135, 100);
    // Tortoise.turn(135);
    // Tortoise.move(100);
    moveDown();
    // turnAndMove(90, 100);
    // Tortoise.turn(90);
    // Tortoise.move(100);
    moveUp();
    // turnAndMove(-90, 100);
    // Tortoise.turn(-90);
    // Tortoise.move(100);
    moveDown();
    // turnAndMove(90, 100);
    // Tortoise.turn(90);
    // Tortoise.move(100);
    moveUp();
    //turnAndMove(-90, 100);
    // Tortoise.turn(-90);
    // Tortoise.move(100);
    moveDown();
    // turnAndMove(90, 100);
    // Tortoise.turn(90);
    // Tortoise.move(100);
    Tortoise.turn(135);
    Tortoise.move(210);
  }
  public static void moveDown()
  {
    turnAndMove(90, 100);
  }
  public static void moveUp()
  {
    turnAndMove(-90, 100);
  }
  public static void turnAndMove(int degrees, int length)
  {
    Tortoise.turn(degrees);
    Tortoise.move(length);
  }
}
