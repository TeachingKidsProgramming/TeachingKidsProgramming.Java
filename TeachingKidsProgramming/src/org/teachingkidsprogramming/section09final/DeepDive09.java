package org.teachingkidsprogramming.section09final;

import java.awt.Cursor;

import org.junit.Assert;
import org.junit.Test;
import org.teachingextensions.logo.Tortoise;

//This deepdive is in progress!
@SuppressWarnings("unused")
public class DeepDive09
{
  //  Step 1: SELECT the method name (stringsCanBeArrays on line 24), then click the Run Button
  //            Keyboard shortcut to run ->  PC: Ctrl+F11 or Mac: Command+fn+F11
  //  Step 2: READ the name of the method that failed
  //  Step 3: FILL IN the blank (___) to make that method pass
  //  Step 4: SAY at least one thing you just learned
  //  Step 5: GO to the next method
  //  
  //  NOTE:   Do not change anything except the blank (___)
  //  
  @Test
  public void stringsCanBeArrays() throws Exception
  {
    String[] words = {"happy ", ___};
    String result = words[0] + words[1];
    Assert.assertEquals("happy baby", result);
  }
  @Test
  public void stringsCanBePartOfStringBuilder() throws Exception
  {
    StringBuilder sb = new StringBuilder();
    sb.append("happy");
    sb.append(" baby");
    String result = sb.toString();
    Assert.assertEquals("happy baby", ___);
  }
  @Test
  public void stringsCanBePartOfStringBuilderAgain() throws Exception
  {
    StringBuilder sb = new StringBuilder();
    sb.append("very happy");
    sb.append(" lady");
    String result = sb.toString();
    Assert.assertEquals(___, result);
  }
  @Test
  public void stringsCanBeReversedInStringBuilder() throws Exception
  {
    StringBuilder sb = new StringBuilder("very happy lady");
    sb.reverse();
    String result = sb.toString();
    Assert.assertEquals(___, result);
  }
  @Test
  public void numbersCanBeStrings() throws Exception
  {
    StringBuilder sb = new StringBuilder();
    for (int i = 97; i <= 99; i++)
    {
      sb.append(convertArray(i));
    }
    String result = sb.toString();
    Assert.assertEquals(___, result);
  }
  @Test
  public void numbersCanBeStringsAgain() throws Exception
  {
    StringBuilder sb = new StringBuilder();
    for (int i = 99; i > ____; i--)
    {
      sb.append(convertArray(i));
    }
    String result = sb.toString();
    Assert.assertEquals(" 99 98 97", result);
  }
  @Test
  public void theLineEndsWhenItEnds() throws Exception
  {
    StringBuilder sb = new StringBuilder("one end ");
    sb.append("\n");
    sb.append(" another end");
    String result = sb.toString();
    Assert.assertEquals(___, result);
  }
  @Test
  public void theLineEndsReally() throws Exception
  {
    StringBuilder sb = new StringBuilder("one end ");
    sb.append("\n");
    sb.append(" another end ");
    sb.append(___);
    String result = sb.toString();
    Assert.assertEquals("one end \n another end \n", result);
  }
  @Test
  public void chainThoseMethods() throws Exception
  {
    StringBuilder sb = new StringBuilder("method");
    String result = sb.reverse().toString();
    Assert.assertEquals(___, result);
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
  public boolean   _____  = false;
  public boolean   ______ = true;
  public Character _______;
  public String    ___    = "You need to fill in the blank ___";
  public int       ____   = 0;
  public String ___()
  {
    return ___;
  }
  private Cursor getCursor()
  {
    Cursor cursor = Tortoise.getBackgroundWindow().getCursor();
    return cursor;
  }
  public static String convertArray(int i)
  {
    return " " + i;
  }
}
