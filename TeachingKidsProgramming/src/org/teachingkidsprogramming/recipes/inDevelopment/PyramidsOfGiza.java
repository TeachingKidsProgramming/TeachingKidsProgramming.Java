package org.teachingkidsprogramming.recipes.inDevelopment;

import org.teachingextensions.logo.Tortoise;

public class PyramidsOfGiza
{
  /*----IN PROGRESS-----------------------------------*/
  public static void main(String[] args) throws Exception
  {
    Tortoise.show();
    Tortoise.setSpeed(10);
    turnAndMove(-90, 220);
    turnAndMove(135, 100);
    moveDown();
    moveUp();
    moveDown();
    moveUp();
    moveDown();
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
