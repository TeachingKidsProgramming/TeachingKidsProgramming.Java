package src.main.java.org.teachingkidsprogramming.section04mastery;

import java.awt.Color;

import src.main.java.org.teachingextentions.logo.utils.ColorUtils.ColorWheel;
import src.main.java.org.teachingextentions.logo.utils.ColorUtils.PenColors;

public class DigiFlower
{
  public static void main(String[] args)
  {
    //    Show the tortoise --#1
    //    Make the tortoise move as fast as possible --#6
    //    Make the background silver  --#7
    //    Make the line the tortoise draws 3 pixels wide --#12
    //    createColorPalette (recipe below) --#8.1
    //        Do the following 15 times --#11.1
    //          drawOctogon (recipe below) --#9.1
    //          Turn the tortoise 1/15th of 360 degrees to the right --#10
    //        End Repeat --#11.2
    //    ------------- Recipe for createColorPalette --#8.2
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
    //    ------------- End of createColorPalette recipe --#8.3
    //
    //    ------------- Recipe for drawOctogon --#9.2
    //    Do the following 8 times --#5.1
    //      Change the pen color of the line the tortoise draws to the next color on the color wheel --#3
    //      Move the tortoise 50 pixels --#2
    //      Turn the tortoise 1/8th of 360 degrees to the right --#4
    //    End Repeat --#5.2 
    //    ------------- End of drawOctogon recipe --#10.3
  }
}
