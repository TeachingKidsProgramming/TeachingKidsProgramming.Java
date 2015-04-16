package org.teachingkidsprogramming.section05recursion;

public class RecursiveSquare
{
  public static void main(String[] args) throws Exception
  {
    //Set the speed to the fastest
    //Set the length to 100.0
    //Run the recipe makeASquare with the current length
    //
    //Create the makeASquare recipe 
    //If the current length is greater than 10
    //  Run the recipe moveToTheSquareStart with the current length
    //
    //  Create the moveToTheSquareStart recipe 
    //    Set the pen up for the tortoise
    //    Move the tortoise the current length divided by two
    //    Turn the tortoise 90 degrees to the left
    //    Move the tortoise the current length divided by two
    //    Turn the tortoise 180 degrees to the right
    //    Set the pen down for the tortoise
    //  End of moveToTheSquareStart recipe 
    //
    //  Do the following 4 times
    //    Move the Tortoise the current length  
    //    Run the recipe makeASquare with the current length divided by two  
    //      If the current process count is less than 4
    //      Turn the tortoise 90 degrees to the right
    //
    //  Run the recipe moveBackToCenter with the current length
    //  Create the moveBackToCenter recipe 
    //    Set the pen up for the tortoise
    //    Turn the tortoise 90 degrees to the right
    //    Move the tortoise the current length divided by two
    //    Turn the tortoise 90 degrees to the right
    //    Move the tortoise the current length divided by two
    //    Turn the tortoise 180 degrees to the right
    //    Set the pen down for the tortoise
    //
    //  End of moveToTheSquareStart recipe
    //
    //  Set the current length to the current length times two
    //
    //End of makeASquare recipe
  }
}
