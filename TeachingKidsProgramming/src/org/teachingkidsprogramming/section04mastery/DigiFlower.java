package org.teachingkidsprogramming.section04mastery;

import java.awt.Color;

import org.teachingextensions.logo.utils.ColorUtils.ColorWheel;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;

public class DigiFlower
{
  public static void main(String[] args)
  {
    //    Show the tortoise --#1
    //    Make the tortoise move as fast as possible --#7
    //    Make the background silver  --#8
    //    Make the line the tortoise draws 3 pixels wide --#15
    //    createColorPalette (recipe below) --#9.1
    //        Do the following 15 times --#13.1
    //          drawOctogon (recipe below) --#10.1
    //          Turn the tortoise 1/15th of 360 degrees to the right --#12
    //        End Repeat --#14.2
    //    ------------- Recipe for createColorPalette --#9.2
    Color color1 = PenColors.Reds.Red;
    Color color2 = PenColors.Oranges.DarkOrange;
    Color color3 = PenColors.Yellows.Gold;
    Color color4 = PenColors.Yellows.Yellow;
    ColorWheel.addColor(color1);
    ColorWheel.addColor(color2);
    ColorWheel.addColor(color3);
    ColorWheel.addColor(color4);
    ColorWheel.addColor(color4);
    ColorWheel.addColor(color3);
    ColorWheel.addColor(color2);
    ColorWheel.addColor(color1);
    //    ------------- End of createColorPalette recipe --#9.3
    //
    //    ------------- Recipe for drawOctogon --#10.2
    //    Do the following 8 times --#6.1
    //      Change the pen color of the line the tortoise draws to the next color on the color wheel --#4
    //      Move the tortoise 50 pixels --#2
    //      Turn the tortoise 1/8th of 360 degrees to the right --#5
    //    End Repeat --#6.2 
    //    ------------- End of drawOctogon recipe --#10.3
  }
}
