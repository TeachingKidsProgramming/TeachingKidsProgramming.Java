package org.teachingkidsprogramming.section07events;

import java.awt.Cursor;

import org.junit.Assert;
import org.junit.Test;
import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.Turtle;
import org.teachingextensions.logo.Turtle.Animals;
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
  //   'this' - instance(s) - multiple Tortoises
  //    exploring Object methods other than Tortoise---Circle (TKP)...methods
  //    events / multiple event listeners - right click - move events to new section?
  @Test
  public void stringsCanBeArrays() throws Exception
  {
    String[] words = {"happy ", ___};
    String result = words[0] + words[1];
    Assert.assertEquals("happy baby", result);
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
  //Turtle Leonardo belongs to "this" 
  private Turtle leonardo;
  @Test
  public void fatTrailTurtle() throws Exception
  {
    Turtle ninja = new Turtle();
    this.leonardo = _______;
    ninja.setPenWidth(30);
    Assert.assertEquals(30, this.leonardo.getPenWidth());
  }
  //Turtle Donatello belongs to "this" 
  private Turtle donatello;
  @Test
  public void explodingTurtle() throws Exception
  {
    Turtle ninja = new Turtle();
    this._______ = ninja;
    this.donatello.setAnimal(Animals.ExplodedTurtle);
    Assert.assertTrue("The ninja is still alive!", ninja.isDead());
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
  public boolean  _____   = false;
  public boolean  ______  = true;
  public String   ___     = "You need to fill in the blank ___";
  public int      ____    = 0;
  public Turtle   _______ = new Turtle();
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
  public DeepDive07Events()
  {
    this.leonardo = new Turtle();
    this.donatello = new Turtle();
  }
}
