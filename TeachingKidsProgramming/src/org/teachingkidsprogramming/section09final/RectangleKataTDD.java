package org.teachingkidsprogramming.section09final;

//--------------------This recipe is in progress-------------------------------//
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.teachingkidsprogramming.recipes.completed.section09final.FizzBuzzTDD;

public class RectangleKataTDD
{
  //    Draw a rectangle 
  //    HINT: Write each step in English FIRST, then translate to Java one line at a time
  //    TIP: Be sure to run after each line of Java to make sure it works as expected
  //    Write tests using the Assert object via the TDD style shown below
  //    TIP: Fix this test to make it pass to get started
  @Test
  public void test1Returns1()
  {
    String result = FizzBuzzTDD.convert(1);
    assertEquals("2", result);
  }
}
