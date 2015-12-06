package org.teachingkidsprogramming.section08events;

import org.junit.Assert;
import org.junit.Test;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;
import org.teachingextensions.logo.utils.LineAndShapeUtils.Circle;

public class DeepDive08Events
{
  //  Step 1: SELECT the method name (twoTortoises on line 26), then click the Run Button
  //            Keyboard shortcut to run ->  PC: Ctrl+F11 or Mac: Command+fn+F11
  //  Step 2: READ the name of the method that failed
  //  Step 3: FILL IN the blank (___) to make that method pass
  //  Step 4: SAY at least one thing you just learned
  //  Step 5: GO to the next method
  //  
  //  NOTE:   Do not change anything except the blank (___)
  // 
  //*****************In Progress************************//
  //Looking at testing object instances and properties
  //Also testing more events
  //NOTE for Deep Dive Authors: Copy 'answer' to TKPJava answer section when done
  //
  @Test
  public void twoCircles() throws Exception
  {
    Circle c1 = new Circle(20, PenColors.Blues.Blue);
    Circle c2 = new Circle(20, PenColors.Blues.Blue);
    boolean result = c1.equals(c2);
    Assert.assertEquals(_____, result);
  }
  @Test
  public void twoCirclesAgain() throws Exception
  {
    Circle c1 = new Circle(20, PenColors.Blues.Blue);
    Circle c2 = new Circle(20, PenColors.Blues.Blue);
    boolean result = c2.equals(c1);
    Assert.assertNotSame(_____, result);
  }
  /**
   * Ignore the following, It's needed to run the deep dive
   * 
   * 
   * 
   * 
   * 
   * 
   * 
   * 
   * 
   * 
   */
  public boolean _____  = false;
  public boolean ______ = true;
  public String  ___    = "You need to fill in the blank ___";
  public int     ____   = 0;
  public String ___()
  {
    return ___;
  }
}
