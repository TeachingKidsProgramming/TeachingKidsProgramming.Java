package org.teachingkidsprogramming.section00demos;

import java.util.Random;

import org.teachingextensions.logo.Tortoise;

@SuppressWarnings("unused")
public class QuickShape
{
  public static void main(String[] args) throws Exception
  {
    Tortoise.show();
    Tortoise.setX(150);
    //  Tip: Use the Tortoise object to draw shapes!
    //  Draw a red square that is 50 pixels per side with a line that's 2 pixels thick -- #1
    //
    Tortoise.setX(425);
    //  Draw a blue hexagon that is 65 pixels per side with a line that's 40 pixels thick -- #2
    //
    Tortoise.setX(250);
    Tortoise.setY(375);
    Random r = new Random();
    int sides = r.nextInt(10) + 1;
    //  Draw a purple shape that is 50 pixel on each side with a line that's 10 pixels thick -- #3
    //
  }
  //    See "your" work at http://virtualproctor.tkpjava.org
}
