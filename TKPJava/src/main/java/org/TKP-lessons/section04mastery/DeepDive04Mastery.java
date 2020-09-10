package org.teachingkidsprogramming.section04mastery;

import org.junit.Assert;
import org.junit.Test;

import you.need.to.fill.in.the.______;

@SuppressWarnings("unused")
public class DeepDive04Mastery
{
  //  Step 1: SELECT the method name (theseNumbersCount on line 21), then click the Run Button
  //            Keyboard shortcut to run ->  PC: Ctrl+F11 or Mac: Command+fn+F11
  //  Step 2: READ the name of the method that failed
  //  Step 3: FILL IN the blank (___) to make that method pass
  //  Step 4: SAY at least one thing you just learned
  //  Step 5: GO to the next method
  //  IMPORTANT - Do NOT change anything except the blank (___)//  
  //  
  @Test
  public void theseNumbersCount() throws Exception
  {
    Integer number = 2;
    Assert.assertEquals(number.getClass(), ______.class);
  }
  @Test
  public void textTypes() throws Exception
  {
    String text = "Beans";
    Assert.assertEquals(text.getClass(), ______.class);
  }
  @Test
  public void theNumbersAfterTheDot() throws Exception
  {
    Double number = 2.3;
    Assert.assertEquals(number.getClass(), ______.class);
  }
  @Test
  public void everythingIsAnObject() throws Exception
  {
    Object number = 2.3;
    Assert.assertEquals(number.getClass(), ______.class);
  }
  @Test
  public void iMeanEverythingIsAnObject() throws Exception
  {
    Object number = 2;
    Assert.assertEquals(number.getClass(), ______.class);
  }
  @Test
  public void iMeanEverySinglethingIsAnObject() throws Exception
  {
    Object number = "Everything";
    Assert.assertEquals(number.getClass(), ______.class);
  }
  @Test
  public void integersAreATypeOfNumber() throws Exception
  {
    Number number = 2;
    Assert.assertEquals(number.getClass(), ______.class);
  }
  @Test
  public void doublesAreATypeOfNumber() throws Exception
  {
    Number number = 2.0;
    Assert.assertEquals(number.getClass(), ______.class);
  }
  @Test
  public void addingIntegers() throws Exception
  {
    Number number = 2 + 3;
    Assert.assertEquals(number.getClass(), ______.class);
  }
  @Test
  public void addingDoubles() throws Exception
  {
    Number number = 2.1 + 3.2;
    Assert.assertEquals(number.getClass(), ______.class);
  }
  @Test
  public void addingMixedTypes() throws Exception
  {
    Number number = 2 + 0.1;
    Assert.assertEquals(number.getClass(), ______.class);
    Assert.assertEquals(number, ____);
  }
  @Test
  public void addingMixingMoreTypes() throws Exception
  {
    Object number = "19 fought 20, " + 21;
    Assert.assertEquals(number.getClass(), ______.class);
    Assert.assertEquals(number, ____);
  }
  @Test
  public void convertingToText() throws Exception
  {
    Integer number = 21;
    String text = number.toString();
    Assert.assertEquals(text.getClass(), ______.class);
    Assert.assertEquals(text, ____);
  }
  @Test
  public void convertingToText2() throws Exception
  {
    Integer number = 21;
    String text = "" + number;
    Assert.assertEquals(text.getClass(), ______.class);
    Assert.assertEquals(text, ____);
  }
  @Test
  public void dividing() throws Exception
  {
    Number number = 1.0 / 5;
    Assert.assertEquals(number.getClass(), ______.class);
    Assert.assertEquals(number, ___);
  }
  @Test
  public void dividingIntegers() throws Exception
  {
    Number number = 11 / 5;
    Assert.assertEquals(number.getClass(), ______.class);
    Assert.assertEquals(number, ____);
  }
  @Test
  public void understandingNumbers() throws Exception
  {
    String text = "42";
    Number theAnswer = Integer.parseInt(text);
    Assert.assertEquals(theAnswer.getClass(), ______.class);
    Assert.assertEquals(theAnswer, ____);
  }
  @Test
  public void understandingDoubleNumbers() throws Exception
  {
    String text = "42";
    Number theAnswer = Double.parseDouble(text);
    Assert.assertEquals(theAnswer.getClass(), ______.class);
    Assert.assertEquals(theAnswer, ____);
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
  public Integer ____   = null;
  private Double _______;
  public String ___()
  {
    return ___;
  }
}
