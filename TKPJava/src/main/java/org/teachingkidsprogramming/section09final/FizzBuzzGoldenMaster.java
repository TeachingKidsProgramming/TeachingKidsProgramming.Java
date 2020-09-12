package org.teachingkidsprogramming.section09final;

import org.junit.Test;
import org.teachingextensions.approvals.lite.Approvals;

public class FizzBuzzGoldenMaster
{
  //    Write a test using the GoldenMaster method via the TDD style for the convert method
  //    IMPORTANT - GoldenMaster testing requires the use a of file compare tool
  //    Download 'BeyondCompare' -- http://www.scootersoftware.com/download.php
  @Test
  public void testNumbers() throws Exception
  {
    //  Arrange     Create a list of numbers from 1-100
    //  Act         Call the convert method on the list
    //  Verify      The list is a Golden Master (uses .received and .approved files)
    Approvals.verify("1");
  }
  public static String convert(int i)
  {
    //  For the whole numbers from 1 to 100, print either that number, or,  
    //  If that number is divisible by 3, then print the word 'Fizz', 
    //  If that number is divisible by 5, then print the word 'Buzz', 
    //  If that number is divisible by 3 and 5, then print the word 'FizzBuzz'
    return "";
  }
}
