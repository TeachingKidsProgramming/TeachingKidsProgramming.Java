package org.teachingkidsprogramming.recipes;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.utils.VirtualProctor;

public class SimpleSquare
{
  public static void main(String[] args) throws Exception
  {
    VirtualProctor.internals.resetName();
    Tortoise.show();
    Tortoise.move(50);
    //  Make the tortoise move as fast as possible --#6
    //  Do the following 4 times --#5.1
    //      Change the color of the line the tortoise draws to "blue" --#4
    //      Move the tortoise 50 pixels --#2
    //      Turn the tortoise to the right (90 degrees) --#3
    //  Repeat --#5.2
  }
  /*
   * After you finish, watch the video recap at http://youtu.be/5bqUZEsJh_Q
   */
}
