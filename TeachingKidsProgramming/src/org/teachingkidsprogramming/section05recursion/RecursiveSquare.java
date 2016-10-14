package org.teachingkidsprogramming.section05recursion;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;

public class RecursiveSquare
{
  public static void main(String[] args) throws Exception
  {
    Tortoise.show();
    Tortoise.getBackgroundWindow().setBackground(PenColors.Greens.DarkGreen);
    Tortoise.setPenColor(PenColors.Yellows.Gold);
    //
    //  Set the speed to the fastest --#8
    //  Update the length to 100.0 --#1.1
    double length = 50.0;
    //  MakeASquare with the current length(recipe below) --#11.4
    //
    //  Create the makeASquare recipe --#11.1
    //  If the current length is greater than 10 --#10.2
    //      Run the recipe moveToTheSquareStart with the current length  --#4.3
    //
    //      Create the moveToTheSquareStart recipe  --#4.1
    //          Set the pen up for the tortoise --#1.2
    //          Move the tortoise the current length divided by two --#1.3
    //          Turn the tortoise 90 degrees to the left --#2.1
    //          Move the tortoise the current length divided by two --#2.2
    //          Turn the tortoise 180 degrees to the right --#3.1
    //          Set the pen down for the tortoise --#3.2
    //      End of moveToTheSquareStart recipe  --#4.2
    //
    //  Do the following 4 times --#7.1
    //    Move the Tortoise the current length --#6.2
    //    MakeASquare with the current length divided by 1.7 (recipe below)--#11.3 
    //      If the current process count is less than 3 (HINT: use 'i') --#9
    //          Turn the tortoise 90 degrees to the right --#6.1
    //  End Repeat --#7.2
    //
    //  MoveBackToCenter with the current length (recipe below)--#5.3
    //  Create the moveBackToCenter recipe --#5.1
    Tortoise.setPenUp();
    Tortoise.turn(90);
    Tortoise.move(length / 2);
    Tortoise.turn(90);
    Tortoise.move(length / 2);
    Tortoise.turn(180);
    Tortoise.setPenDown();
    //
    //
    //  End of moveBackToCenter recipe--#5.2
    //
    //  Set the current length to the current length times two --#10.1
    //
    //  End of makeASquare recipe --#11.2
  }
}
