package org.teachingkidsprogramming.recipes;

import org.teachingextensions.logo.Colors;
import org.teachingextensions.logo.Tortoise;

public class SimpleSquare
{
  public static void main(String[] args) throws Exception
  {
    Tortoise.show();
    Tortoise.setSpeed(10);
    for (int i = 1; i <= 4; i++)
    {
      Tortoise.setPenColor(Colors.Blues.Blue);
      Tortoise.move(50);
      Tortoise.turn(90);
    }
  }
  /*
   * After you finish, watch the video recap at http://youtu.be/5bqUZEsJh_Q
   */
}
