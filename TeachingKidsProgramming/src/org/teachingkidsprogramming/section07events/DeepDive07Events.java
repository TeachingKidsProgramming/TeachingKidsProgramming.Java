package org.teachingkidsprogramming.section07events;

import java.awt.Cursor;

import org.junit.Assert;
import org.junit.Test;
import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.Turtle;
//This deepdive is in progress!

//
public class DeepDive07Events
{
  //  How to do deep dive:
  //  Step 1: Select the method name (xxx on line xx) Press the Run Button
  //            PC: Ctrl+F11 
  //            Mac: Command+fn+F11
  //  Step 2: Read the name of the method that failed
  //  Step 3: Fill in the blank (___) to make it pass
  //  Step 4: Consider at least one thing you just learned
  //  Step 5: Advance to the next method
  //  Do not change anything except the blank (___)
  //
  //   concepts:
  //   events / multiple event listeners - right click 
  //   'this' - instance(s) - multiple Tortoises
  //    exploring Object methods other than Tortoise---Circle (TKP)...methods
  @Test
  public void concatenateString() throws Exception
  {
    //create a new string from the strings "happy " + "baby"
    String[] words = {"happy ", ___};
    Assert.assertEquals("happy baby", words);
  }
  @Test
  public void twoTortoises() throws Exception
  {
    Tortoise rafael = new Tortoise();
    Tortoise michealangelo = new Tortoise();
    boolean result = rafael.equals(michealangelo);
    Assert.assertEquals(______, result);
  }
  @Test
  public void twoTortoisesAgain() throws Exception
  {
    Tortoise rafael = new Tortoise();
    Tortoise anonymousNinja = rafael;
    boolean result = rafael.equals(anonymousNinja);
    Assert.assertEquals(_____, result);
  }
  @Test
  public void twoTortoisesYetAgain() throws Exception
  {
    Tortoise rafael = new Tortoise();
    Tortoise michealangelo = new Tortoise();
    Tortoise anonymousNinja = ________;
    boolean result = michealangelo.equals(anonymousNinja);
    Assert.assertEquals(true, result);
  }
  //"this" Tortoise belongs here (to this Object)
  private Turtle leonardo;
  @Test
  public void sadTortoise() throws Exception
  {
    this._______ = new Turtle();
    //sorry, leonardo must die now - joking
    this.leonardo.getPenWidth();
    Assert.assertEquals(2, this.leonardo.getPenWidth());
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
  public boolean  _____  = false;
  public boolean  ______ = true;
  public String   ___    = "You need to fill in the blank ___";
  public int      ____   = 0;
  public Turtle   _______;
  public Tortoise ________;
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
