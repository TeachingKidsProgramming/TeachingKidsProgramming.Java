package org.teachingkidsprogramming.recipes;

import java.awt.Color;

import org.teachingextensions.logo.Colors;
import org.teachingextensions.logo.Tortoise;

public class Houses
{
  public static void main(String[] args)
  {
    Tortoise.setX(200);
    int height = 40;
    drawHouse(height);
    drawHouse(120);
    drawHouse(90);
    drawHouse(20);
  }
  private static void drawHouse(int height)
  {
    Tortoise.setPenColor(colorChooser());
    Tortoise.setSpeed(10);
    Tortoise.hide();
    Tortoise.move(height);
    //flatRoof();
    //AmittaisRoof;
    Tortoise.turn(45);
    //move 10
    Tortoise.move(10);
    //turn 90 right
    Tortoise.turn(90);
    //move 10
    Tortoise.move(10);
    //turn 60
    Tortoise.turn(45);
    Tortoise.move(height);
    Tortoise.turn(-90);
    Tortoise.move(20);
    Tortoise.turn(-90);
  }
  private static void flatRoof()
  {
    Tortoise.turn(90);
    Tortoise.move(30);
    Tortoise.turn(90);
  }
  private static Color colorChooser()
  {
    return Colors.Grays.LightGray;
  }
}
