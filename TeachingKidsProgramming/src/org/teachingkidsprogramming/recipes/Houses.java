package org.teachingkidsprogramming.recipes;

import java.awt.Color;

import org.teachingextensions.logo.Tortoise;

public class Houses
{
  public static void main(String[] args)
  {
    Tortoise.setSpeed(10);
    Tortoise.setX(200);
    int Height = 40;
    drawHouse(Height);
    drawHouse(120);
    drawHouse(90);
    drawHouse(20);
  }
  private static void drawHouse(int Height)
  {
    Tortoise.setPenColor(Color.lightGray);
    Tortoise.move(Height);
    //flatRoof();
    //MavericksRoof
    mavericksRoof();
    Tortoise.move(Height);
    Tortoise.turn(-90);
    Tortoise.move(20);
    Tortoise.turn(-90);
  }
  private static void mavericksRoof()
  {
    //turn left 90
    Tortoise.turn(-90);
    //move 10
    Tortoise.move(10);
    //turn right 90+45 degrees
    Tortoise.turn(90 + 45);
    //move 50
    Tortoise.move(50);
    //turn 90
    Tortoise.turn(90);
    //move 50
    Tortoise.move(50);
    //turn 90+45
    Tortoise.turn(90 + 45);
    //move 10
    Tortoise.move(10);
    //turn 90 left
    Tortoise.turn(-90);
  }
  private static void amittaisRoof()
  {
    Tortoise.turn(45);
    Tortoise.move(10);
    Tortoise.turn(90);
    Tortoise.move(10);
    Tortoise.turn(45);
  }
  private static void flatRoof()
  {
    Tortoise.turn(90);
    Tortoise.move(30);
    Tortoise.turn(90);
  }
  // Related Videos:
  // Sub recipe-> Method : http://youtu.be/C6fnqjceVcs
}
