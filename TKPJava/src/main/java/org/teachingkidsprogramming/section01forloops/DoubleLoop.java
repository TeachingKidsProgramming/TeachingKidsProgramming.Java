package org.teachingkidsprogramming.section01forloops;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.utils.ColorUtils.ColorWheel;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;

public class DoubleLoop
{
  public static void main(String[] args)
  {
    Tortoise.show();
    //    Set the tortoise x position to 225 --#1.1
    //    Set the tortoise y position to 150 --#1.2
    //    UPDATE the tortoise speed to 10 --#8.2
    Tortoise.setSpeed(5);
    //  
    ColorWheel.addColor(PenColors.Reds.Crimson);
    ColorWheel.addColor(PenColors.Reds.DarkRed);
    ColorWheel.addColor(PenColors.Reds.FireBrick);
    //    Do the following 6 times --#3.1
    //         Change the pen color of the line the tortoise draws to the next color on the Color Wheel --#5
    //         Move the tortoise 4 times the current line number you are drawing --#4
    //         Turn the tortoise 1/6 of 360 degrees to the left --#2
    // 
    //         Do the following 15 times --(HINT: The new line number is j) --#7.1
    //              Set the pen width of the line the tortoise draws to 17 --#9
    //              Move the tortoise 8 times the current line number you are drawing --#8.1
    //              Turn the tortoise 1/5 of 360 degrees to the right --#6
    //         End Repeat --#7.2 
    //  
    //    Hide the Tortoise --#10
    Tortoise.getBackgroundWindow().setBackground(PenColors.Yellows.PeachPuff);
    //    End Repeat --#3.2
    //    Set the tortoise x position to 300 --#15.1
    //    Set the tortoise y position to 200 --#15.2
    //    Do the following 5 times --#12.1
    //        Change the pen color of the line the tortoise draws to black --#14 
    //        Move the Tortoise 25 pixels --#11
    //        Turn the tortoise 1/5 of 360 degrees to the right --#13  
    //    End Repeat --#12.2
    //  
  }
}
