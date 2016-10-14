package org.teachingkidsprogramming.section04mastery;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.utils.ColorUtils.ColorWheel;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;

public class KnottedRing
{
  public static void main(String[] args)
  {
    Tortoise.show();
    //      Make the tortoise move as fast as possible --#4
    createColorPalette();
    //          Do the following 30 times --#10.1
    //              Change the pen color of the line the tortoise draws to the next color from the color wheel --#5
    //              drawOctagonWithOverlap (recipe below) --#8.0
    //              ------------- Recipe for drawOctagonWithOverlap --#7.1
    //                  Do the following 8 + 1 times --#3.1
    //                        Move the tortoise 110 pixels --#1
    //                        Turn the tortoise 1/8th of 360 degrees to the right --#2
    //                  End Repeat --#3.2
    //              ------------- End of drawOctagonWithOverlap recipe --#7.2
    //       Turn the tortoise 1/30th of 360 degrees to the right --#9
    //       Turn the tortoise 5 more degrees to the right --#11
    //       End Repeat --#10.2
  }
  private static void createColorPalette()
  {
    ColorWheel.addColor(PenColors.Pinks.HotPink);
    ColorWheel.addColor(PenColors.Reds.Red);
    ColorWheel.addColor(PenColors.Pinks.Fuchsia);
    ColorWheel.addColor(PenColors.Reds.OrangeRed);
    ColorWheel.addColor(PenColors.Pinks.DeepPink);
    ColorWheel.addColor(PenColors.Reds.MediumVioletRed);
    ColorWheel.addColor(PenColors.Reds.Crimson);
    ColorWheel.addColor(PenColors.Reds.Tomato);
  }
}
