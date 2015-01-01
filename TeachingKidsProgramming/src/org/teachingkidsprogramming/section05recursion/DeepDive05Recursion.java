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
  //  Step 1: Select the method name (changeThePointerToAHand on line 29) Press the Run Button
  //            PC: Ctrl+F11 
  //            Mac: Command+fn+F11
  //  Step 2: Read the name of the method that failed
  //  Step 3: Fill in the blank (___) to make it pass
  //  Step 4: Consider at least one thing you just learned
  //  Step 5: Advance to the next method
  //  Do not change anything except the blank (___)
  //
  @Test
  public void changeThePointerToAHand() throws Exception
  {
    Tortoise.getBackgroundWindow().___();
    Assert.assertEquals(getCursor(), Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
  }
  @Test
  public void getTheWindow() throws Exception
  {
    Tortoise.___().setCursor(Cursor.CROSSHAIR_CURSOR);
    Assert.assertEquals(getCursor(), Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
  }
  @Test
  public void setColorUsingKey() throws Exception
  {
    HashMap<Integer, Color> colors = new HashMap<Integer, Color>();
    colors.put(10, Colors.Greens.Lime);
    colors.put(____, Colors.Greens.DarkGreen);
    Assert.assertEquals(Colors.Greens.DarkGreen, colors.get(20));
  }
  @Test
  public void findTheGreenKey() throws Exception
  {
    HashMap<Integer, Color> colors = new HashMap<Integer, Color>();
    colors.put(20, Colors.Greens.DarkGreen);
    colors.put(30, Colors.Greens.Green);
    Assert.assertEquals(Colors.Greens.Green, colors.get(___));
  }
  @Test
  public void findTheColorForTheBananaKey() throws Exception
  {
    HashMap<String, Color> colors = new HashMap<String, Color>();
    colors.put("banana", Colors.Yellows.Yellow);
    colors.put("apple", Colors.Reds.Red);
    Assert.assertEquals(_______, colors.get("banana"));
  }
  @Test
  public void findTheNumberPositionOfTheWorld() throws Exception
  {
    List<String> messages = Arrays.asList("Hello", "World!", "How", "Are", "You");
    String result = messages.get(____);
    Assert.assertEquals("World!", result);
  }
  @Test
  public void getWhatsLast() throws Exception
  {
    List<String> messages = Arrays.asList("Hello", "World!", "How", "Are", "You");
    String result = messages.get(4);
    Assert.assertEquals(___, result);
  }
  @Test
  public void whatIsLastNow() throws Exception
  {
    List<String> messages = Arrays.asList("Hello", "World!", "How", "Are", "You");
    messages.set(4, ___);
    String result = messages.get(4);
    Assert.assertEquals("The rest of them", result);
  }
  @Test
  public void putAQuarterAtTheEnd() throws Exception
  {
    int[] coins = {1, 5, 10, ____};
    Assert.assertEquals(25, coins[3]);
  }
  @Test
  public void getThirdCoin() throws Exception
  {
    int[] coins = {1, 5, 10, 25};
    Assert.assertEquals(10, coins[____]);
  }
  @Test
  public void whichCoinIsSecond() throws Exception
  {
    int[] coins = {1, 5, 10, 25};
    Assert.assertEquals(____, coins[1]);
  }
  @Test
  public void putAFiftyCentPieceFirst() throws Exception
  {
    int[] coins = {1, 5, 10, 25};
    coins[0] = ____;
    Assert.assertEquals(50, coins[0]);
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
