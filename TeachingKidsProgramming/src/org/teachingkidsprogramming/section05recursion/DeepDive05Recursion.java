package org.teachingkidsprogramming.section05recursion;

import java.awt.Color;
import java.awt.Cursor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.teachingextensions.logo.Colors;
import org.teachingextensions.logo.Tortoise;


public class DeepDive05Recursion
{
  //  How to do deep dive:
  //  Step 1: Select the method name (doesABear on line 20) Press the Run Button
  //            PC: Ctrl+F11 
  //            Mac: Command+fn+F11
  //  Step 2: Read the name of the method that failed
  //  Step 3: Fill in the blank (___) to make it pass
  //  Step 4: Consider at least one thing you just learned
  //  Step 5: Advance to the next method
  //  Do not change anything except the blank (___)
  //
  @Test
  public void changeThePointer() throws Exception
  {
    //Set the cursor on the background window to a hand
    Tortoise.getBackgroundWindow().___();
    Assert.assertEquals(getCursor(), Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
  }
  @Test
  public void getTheWindow() throws Exception
  {
    //Get the correct background window in order to set the cursor
    Tortoise.___().setCursor(Cursor.CROSSHAIR_CURSOR);
    Assert.assertEquals(getCursor(), Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
  }
  @Test
  public void setPositionUsingHashKey() throws Exception
  {
    //set the color Dark Green into the right spot using the key
    HashMap<Integer, Color> colors = new HashMap<Integer, Color>();
    colors.put(10, Colors.Greens.Lime);
    colors.put(____, Colors.Greens.DarkGreen);
    Assert.assertEquals(Colors.Greens.DarkGreen, colors.get(20));
  }
  @Test
  public void getValueUsingHashKey() throws Exception
  {
    //get the key from the right spot using the color
    HashMap<Integer, Color> colors = new HashMap<Integer, Color>();
    colors.put(20, Colors.Greens.DarkGreen);
    colors.put(30, Colors.Greens.Green);
    Assert.assertEquals(Colors.Greens.Green, colors.get(___));
  }
  @Test
  public void getColorUsingHashKey() throws Exception
  {
    //get the color from the right spot using the key
    HashMap<Integer, Color> colors = new HashMap<Integer, Color>();
    colors.put(20, Colors.Greens.DarkGreen);
    colors.put(30, Colors.Greens.Green);
    Assert.assertEquals(_______, colors.get(30));
  }
  @Test
  public void getWhatsSecond() throws Exception
  {
    //get the second item on the list
    List<String> messages = Arrays.asList("Hello", "World!", "How", "Are", "You");
    String result = messages.get(____);
    Assert.assertEquals("World!", result);
  }
  @Test
  public void getWhatsLast() throws Exception
  {
    //get the last item on the list
    List<String> messages = Arrays.asList("Hello", "World!", "How", "Are", "You");
    String result = messages.get(4);
    Assert.assertEquals(___, result);
  }
  @Test
  public void whatIsLastNow() throws Exception
  {
    //get the last item on the list now
    List<String> messages = Arrays.asList("Hello", "World!", "How", "Are", "You");
    messages.set(4, ___);
    String result = messages.get(4);
    Assert.assertEquals("The rest of them", result);
  }
  @Test
  public void getThirdArrayItem() throws Exception
  {
    //get the third item from the right spot using the key
    int[] numbers = {1, 5, 10, 25};
    Assert.assertEquals(10, numbers[____]);
  }
  @Test
  public void whatIsThird() throws Exception
  {
    //put 25 at the third position
    int[] numbers = {1, 5, 10, ____};
    Assert.assertEquals(25, numbers[3]);
  }
  @Test
  public void whatIsFirst() throws Exception
  {
    //get the number at the first position
    int[] numbers = {1, 5, 10, 25};
    Assert.assertEquals(____, numbers[1]);
  }
  @Test
  public void whatIsFirstNow() throws Exception
  {
    //change the number at the listed position
    int[] numbers = {1, 5, 10, 25};
    numbers[0] = ____;
    Assert.assertEquals(53, numbers[0]);
  }
  /**
   * Ignore the following, It's needed to run the homework
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
  public Color   _______;
  public String ___()
  {
    return ___;
  }
  private Cursor getCursor()
  {
    Cursor cursor = Tortoise.getBackgroundWindow().getCursor();
    return cursor;
  }
}
