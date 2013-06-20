package org.teachingkidsprogramming.recipes;

import java.awt.Color;

import org.teachingextensions.logo.Tortoise;

public class SimpleSquare
{
  public static void main(String[] args) throws Exception
  {
    Tortoise.show();
    Tortoise.setSpeed(10);
    simpleSquare();
    simpleSquare();
  }
  private static void simpleSquare()
  {
    for (int i = 1; i <= 4; i++)
    {
      Tortoise.setPenColor(Color.blue);
      Tortoise.move(50);
      Tortoise.turn(90);
    }
  }
}
