package utils;

import java.util.Random;

/**
 * A static class of convenience functions for Manipulating numbers
 */
public class NumberUtils
{
  public static Random RANDOM = new Random();
  /**
   * Loads an int from a String.
   *
   * @param i            a string with an integer in it
   * @param defaultValue value to use when no integer can be found in the string
   * @return the integer found in the string
   */
  public static int load(String i, int defaultValue)
  {
    return load(i, defaultValue, true);
  }
  /**
   * Loads an int from a String.
   *
   * @param i               a string with an integer in it
   * @param defaultValue    value to use when no integer can be found in the string
   * @param stripNonNumeric true if non-numeric characters should be removed from the string
   * @return the integer found in the string
   */
  public static int load(String i, int defaultValue, boolean stripNonNumeric)
  {
    try
    {
      i = stripNonNumeric ? StringUtils.stripNonNumeric(i, true, true) : i;
      defaultValue = Integer.parseInt(i);
    }
    catch (Exception ignored)
    {
    }
    return defaultValue;
  }
  public static boolean equals(double one, double two, double delta)
  {
    double actualDelta = one - two;
    return (-delta < actualDelta) && (actualDelta < delta);
  }
  /**
   * randomly chooses a number between the minimum and maximum
   * <div><b>Example:</b>
   * {@code int grade =  NumberUtils.getRandomInt(1,100);} </div>
   *
   * @param minimum The lowest possible value (inclusive)
   * @param maximum The highest possible value (inclusive)
   * @return the random number
   */
  public static int getRandomInt(int minimum, int maximum)
  {
    int diff = maximum - minimum;
    if (diff == 0)
    {
      return maximum;
    }
    else
    {
      return RANDOM.nextInt(diff) + minimum;
    }
  }
}