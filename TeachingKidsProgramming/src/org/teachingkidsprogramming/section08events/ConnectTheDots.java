package org.teachingkidsprogramming.section08events;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.utils.EventUtils.MouseLeftClickListener;
import org.teachingextensions.logo.utils.EventUtils.MouseRightClickListener;

public class ConnectTheDots implements MouseRightClickListener, MouseLeftClickListener
{
  public static void main(String[] args)
  {
    //    Create a new 'Connect The Dots' object. --#1.1
  }
  public ConnectTheDots()
  {
    Tortoise.show();
    //    Listen for right clicks on the window for the tortoise  --#20.2
    //    Listen for left clicks on the window for the tortoise  --#1.2
    //    Make the Tortoise go as fast as possible. --#4
    //    clearTheScreen (recipe below) --#19.1
    //
    //    ------------- Recipe for clearTheScreen --#19.2
    //       Clear the Tortoise --#20.1
    //       Write "Right click to clear" on the screen at position 100, 100 --#18
    //    ------------- End of clearTheScreen Recipe --#19.3
    //
    //    prepareColorPalette (recipe below) --#17.1
    //    ------------- Recipe for prepareColorPalette --#17.2
    //       Add red to the color wheel --#6
    //       Add green to the color wheel --#12
    //       Add blue to the color wheel --#13
    //       Add purple to the color wheel --#14
    //       Add pink to the color wheel --#15
    //       Add teal to the color wheel --#16
    //    ------------- End of prepareColorPalette Recipe --#17.3
  }
  @Override
  public void onRightMouseClick(int x, int y)
  {
    //    clearTheScreen (recipe above) --#20.3
  }
  @Override
  public void onLeftMouseClick(int x, int y)
  {
    //    addDot (recipe below) --#11.1
    //
    //    ------------- Recipe for addDot --#11.2
    //        addACircle (recipe below) --#10.1
    //
    //        ------------- Recipe for addACircle --#10.2
    //           Create a circle with a radius of 7 which is the same color as the next color on the color wheel --#5
    //           Change the circle to be 40% opaque --#9
    //           Move the circle so that it's center is at the current position of the mouse --#8
    //           Place the circle on the tortoise's window. --#7
    //        ------------- End of addACircle Recipe --#10.3
    //
    //    Move the tortoise to the current position of the mouse --#2
    //  ------------- End of addDot Recipe --#11.3
  }
}
