package org.teachingkidsprogramming.section04mastery;

import org.teachingextensions.logo.Tortoise;

public class BackgroundPhoto
{
  @SuppressWarnings("unused")
  public static void main(String[] args)
  {
    //  Set the current picture to this url "https://usatftw.files.wordpress.com/2017/05/spongebob.jpg?w=1000&h=600&crop=1" --#1.0
    //  Set the background image to the current picture--#1.1
    Tortoise.show();
    Tortoise.setSpeed(10);
    int side = 2;
    //  Do the following 75 times --#7.1
    //     Set the current pen color to yellow --#6.1
    //     Use the current pen color for the line the tortoise draws --#6.2
    //     Increase the length of a side by 1 pixel --#3.0
    //     Move the tortoise the length of the current side --#3.1
    //     Set the X position of the tortoise to 555 pixels --#2.0
    //     Set the Y position of the tortoise to 65 pixels --#2.1
    //     Turn the tortoise 1/3rd of 360 degrees to the right --#4
    //     Turn the tortoise 1 more degree --#5
    //  End Repeat --#7.2
  }
}
