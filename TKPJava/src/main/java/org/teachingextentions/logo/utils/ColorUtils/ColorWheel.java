package src.main.java.org.teachingextentions.logo.utils.ColorUtils;

import java.awt.Color;

/**
 * <img src="https://cdn0.iconfinder.com/data/icons/pixelo/32/color-palette.png" style="text-align:left" alt="A painter's palette" >
 * ColorWheel is a place to store a color palette. <br>
 * <b>Example:</b> If you have a palette of
 * <font style="color: blue">blue</font>,
 * <font style="color: red">red</font>,
 * and <font style="color: purple">purple</font> <br>
 * and then used it to print out the numbers, you would get <br>
 * <font style="color: blue">1</font>
 * <font style="color: red">2</font>
 * <font style="color: purple">3</font>
 * <font style="color: blue">4</font>
 * <font style="color: red">5</font>
 * <font style="color: purple">6</font>
 * <font style="color: blue">7</font>
 * <font style="color: red">8</font>
 * <font style="color: purple">9</font>
 */
public class ColorWheel
{
  private static Wheel<Color> wheel = new Wheel<>();
  /**
   * This method adds a color to the ColorWheel. <br>
   * <b>Example:</b> {@code  ColorWheel.addColor(PenColors.Reds.Red);}
   * @param color
   *          the color to add to the wheel
   */
  public static void addColor(Color color)
  {
    wheel.add(color);
  }
  protected static void assertNonEmpty()
  {
    if (wheel.isEmpty())
    {
      String message = "I call shenanigans!!!\nThis ColorWheel is empty\nYou can NOT get a color from the ColorWheel before you've added anything to it.";
      throw new RuntimeException(message);
    }
  }
  /**
   * This method returns the next color of the ColorWheel. <br>
   * <b>Example:</b> {@code  Color color = ColorWheel.getNextColor();}
   * 
   * @return the next color of the ColorWheel
   */
  public static Color getNextColor()
  {
    assertNonEmpty();
    return wheel.next();
  }
  /**
   * This method returns the a random color from the options on the ColorWheel. <br>
   * <b>Example:</b> {@code  Color color = ColorWheel.getNextColor();}
   * 
   * @return A random color from the ColorWheel
   */
  public static Color getRandomColorFromWheel()
  {
    assertNonEmpty();
    return wheel.getRandomFrom();
  }
  public static void removeAllColors()
  {
    wheel.empty();
  }
}
