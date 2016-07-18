package org.teachingkidsprogramming.section02methods;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;

public class PyramidsOfGiza
{
  public static void main(String[] args) throws Exception
  {
    setUpPyramidLand();
    //  Turn the tortoise 90 degrees to the left 
    //  Move the tortoise 220 pixels
    //  Turn the tortoise 135 degrees to the right 
    //  Move the tortoise 100 pixels
    //  Turn the tortoise 90 degrees to the right
    //  Move the tortoise 100 pixels
    //  Turn the tortoise 90 degrees to the left 
    //  Move the tortoise 100 pixels
    //  Turn the tortoise 90 degrees to the right 
    //  Move the tortoise 100 pixels
    //  Turn the tortoise 90 degrees to the left 
    //  Move the tortoise 100 pixels
    //  Turn the tortoise 90 degrees to the right 
    //  Move the tortoise 100 pixels
    //  Turn the tortoise 135 degrees to the right 
    //  Move the tortoise 210 pixels
  }
  private static void setUpPyramidLand()
  {
    Tortoise.show();
    Tortoise.setSpeed(10);
    Tortoise.getBackgroundWindow().setBackground(PenColors.Blues.AliceBlue);
    Tortoise.setPenColor(PenColors.Yellows.DarkGoldenrod);
    Tortoise.setPenWidth(2);
    Tortoise.hide();
  }
}
