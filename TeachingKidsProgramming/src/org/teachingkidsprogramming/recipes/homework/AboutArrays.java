package org.teachingkidsprogramming.recipes.homework;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;


public class AboutArrays
{
  //  'How to do homework:
  //  'Step 1: Press the Run Button
  //            PC: Ctrl+F11 
  //            Mac: Command+fn+F11
  //  'Step 2: Read the name of the Method (Sub) that Failed
  //  'Step 3: Fill in the blank (___) to make it pass
  //  'Step 4: Repeat Until Enlightenment
  //  ' Do not change anything except the blank (___)
  //
  @Test
  public void arraysDoNotConsiderElementsWhenEvaluatingEquality()
  {
    // arrays utilize default object equality (A == {1} B == {1}, though A
    // and B contain the same thing, the container is not the same
    // referenced array instance...
    assertEquals(new int[]{1}.equals(new int[]{1}), __);
  }
  @Test
  public void cloneEqualityIsNotRespected()
  { //!
    int[] original = new int[]{1};
    assertEquals(original.equals(original.clone()), __);
  }
  @Test
  public void anArraysHashCodeMethodDoesNotConsiderElements()
  {
    int[] array0 = new int[]{0};
    int[] array1 = new int[]{0};
    assertEquals(Integer.valueOf(array0.hashCode()).equals(array1.hashCode()), __); // not equal!
    // TODO: ponder the consequences when arrays are used in Hash Collection implementations.
  }
  @Test
  public void arraysHelperClassEqualsMethodConsidersElementsWhenDeterminingEquality()
  {
    int[] array0 = new int[]{0};
    int[] array1 = new int[]{0};
    assertEquals(Arrays.equals(array0, array1), __); // whew - what most people assume 
                                                     // about equals in regard to arrays! (logical equality)
  }
  @Test
  public void arraysHelperClassHashCodeMethodConsidersElementsWhenDeterminingHashCode()
  {
    int[] array0 = new int[]{0};
    int[] array1 = new int[]{0};
    // whew - what most people assume about hashCode in regard to arrays!
    assertEquals(Integer.valueOf(Arrays.hashCode(array0)).equals(Arrays.hashCode(array1)), __);
  }
  @Test
  public void arraysAreMutable()
  {
    final boolean[] oneBoolean = new boolean[]{false};
    oneBoolean[0] = true;
    assertEquals(oneBoolean[0], __);
  }
  @Test
  public void arraysAreIndexedAtZero()
  {
    int[] integers = new int[]{1, 2};
    assertEquals(integers[0], __);
    assertEquals(integers[1], __);
  }
  @Test
  public void arrayIndexOutOfBounds()
  {
    int[] array = new int[]{1};
    @SuppressWarnings("unused")
    int meh = array[1]; // remember 0 based indexes, 1 is the 2nd element (which doesn't exist)
  }
  @Test
  public void arrayLengthCanBeChecked()
  {
    assertEquals(new int[1].length, __);
  }
  /**
   * Ignore the following, it's needed to run the homework
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
  public String __ = "You need to fill in the blank ___";
}
