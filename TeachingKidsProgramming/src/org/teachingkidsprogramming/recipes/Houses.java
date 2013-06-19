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
    Tortoise.turn(90);
    Tortoise.move(30);
    Tortoise.turn(90);
    Tortoise.move(Height);
    Tortoise.turn(-90);
    Tortoise.move(20);
    Tortoise.turn(-90);
  }
}
