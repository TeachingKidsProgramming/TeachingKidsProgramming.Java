package org.teachingkidsprogramming.section05recursion.KataQuestions;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;

//------------Snowflake Kata---------------//
public class CompleteSnowflakeAnswer
{
  public static void main(String[] args)
  {
    setUpBackground();
    for (int i = 0; i < 6; i++)
    {
      makeStarTop(4);
      Tortoise.turn(-60);
    }
  }
  private static void makeStarTop(int starSides)
  {
    for (int i = 0; i < starSides - 1; i++)
    {
      makeTriangleTop(3);
      Tortoise.turn(-60);
    }
    Tortoise.move(45);
    Tortoise.turn(-60);
    Tortoise.move(45);
  }
  private static void makeTriangleTop(int triangleSides)
  {
    for (int i = 1; i < triangleSides - 1; i++)
    {
      Tortoise.move(60);
      Tortoise.turn(360 / triangleSides);
      Tortoise.move(60);
    }
  }
  private static void setUpBackground()
  {
    Tortoise.show();
    Tortoise.setX(400);
    Tortoise.setY(100);
    Tortoise.setSpeed(10);
    Tortoise.getBackgroundWindow().setBackground(PenColors.Whites.AliceBlue);
    Tortoise.setPenColor(PenColors.Grays.SlateGray);
  }
}
