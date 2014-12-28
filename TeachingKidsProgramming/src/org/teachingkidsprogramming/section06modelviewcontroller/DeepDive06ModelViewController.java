package org.teachingkidsprogramming.section06modelviewcontroller;

import java.awt.Color;
import java.awt.Cursor;

import org.junit.Assert;
import org.junit.Test;
import org.teachingextensions.logo.Tortoise;

//  This deepdive is in progress!
//
public class DeepDive06ModelViewController
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
  //   concepts:
  //   string concatenation, including int-> string conversions
  //   MVC
  @Test
  public void stringsCanBeArrays() throws Exception
  {
    //create a new string from the strings "happy " + "baby"
    String[] words = {"happy ", ___};
    Assert.assertEquals("happy baby", words);
  }
  @Test
  public void trashtalkingFlorida() throws Exception
  {
    String compareThis = "is to";
    String analogy = "Florida " + ___ + " America as appendix " + ___ + " body";
    Assert.assertEquals("Florida is to America as appendix is to body", analogy);
  }
  @Test
  public void sardinesFlyCoach() throws Exception
  {
    String fishReference = "The sardines were";
    String airplaneStress = "the coach section of a 747.";
    String analogy = fishReference + " packed as tight as " + airplaneStress;
    Assert.assertEquals("The sardines were packed as tight as the coach section of a 747.", ___);
  }
  @Test
  public void sanityProblems() throws Exception
  {
    String selfDeprecation = "The nerds who made this were";
    String anAppleADay = "the doctors who complimented their mental stability.";
    String analogy = selfDeprecation + " as sarcastic as " + anAppleADay;
    Assert.assertEquals(___, analogy);
  }
  @Test
  public void skydivingFrenchKings() throws Exception
  {
    String compareThis = ___;
    String analogy = "Skydiving " + compareThis + " sensible as Louis XVI " + compareThis + " leadership";
    Assert.assertEquals("Skydiving is to sensible as Louis XVI is to leadership", analogy);
  }
  @Test
  public void infiniteB() throws Exception
  {
    String infinite = "B";
    String analogy = "The " + ___ + " in " + ___ + "enoît " + ___ + ". Mandelbrot stands for " + ___ + "enoît "
        + ___ + ". Mandelbrot.";
    Assert.assertEquals("The B in Benoît B. Mandelbrot stands for Benoît B. Mandelbrot.", analogy);
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
