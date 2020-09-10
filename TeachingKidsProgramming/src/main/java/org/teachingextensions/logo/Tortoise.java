package org.teachingextensions.logo;

import java.awt.Color;

import org.teachingextensions.WindowUtils.TurtleWindow;
import org.teachingextensions.logo.Turtle.Animals;
import org.teachingextensions.logo.utils.TortoiseUtils;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;
import org.teachingextensions.logo.utils.LineAndShapeUtils.Text;
import org.teachingextensions.logo.utils.PizzaUtils.Pizza;
import org.teachingextensions.logo.utils.PizzaUtils.Topping;
import org.teachingextensions.virtualproctor.VirtualProctor;

/**
 * <img src="https://lh5.googleusercontent.com/-B3Q59gpYW8o/T4tA2k_TYUI/AAAAAAAAAjo/WiqdoXjbkb0/s65/Tortoise.png" style="text-align: left" alt="A tortoise drawing a line" >
 * The Tortoise allows you to draw lines and shapes by moving it around on the window
 */
public class Tortoise
{
  private Topping topping;
  /**
   * Displays the Tortoise
   * <div><b>Example:</b> {@code  Tortoise.show()} </div>
   */
  public static void show()
  {
    turtle().show();
  }
  /**
   * Gets the name for the tortoise 
   * <div><b>Example:</b> {@code String name =  Tortoise.getName("Anita Borg");}</div>
   *
   * @return the name for the Tortoise 
   */
  public static String getName()
  {
    return turtle().getName();
  }
  /**
   * Sets the name for the tortoise 
   * <div><b>Example:</b> {@code  Tortoise.setName("Ada Lovelace")}</div>
   *
   * @param name
   *          The name for the Tortoise
   */
  public static void setName(String name)
  {
    turtle().setName(name);
  }
  /**
   * Gets the speed that the tortoise moves
   * <div><b>Example:</b> {@code int speed =  Tortoise.getSpeed(8);}</div>
   *
   * @return the speed the Tortoise is currently set to
   */
  public static int getSpeed()
  {
    return turtle().getSpeed();
  }
  /**
   * Sets the speed the tortoise moves
   * <div><b>Example:</b> {@code  Tortoise.setSpeed(8)}</div>
   *
   * @param speed
   *          The speed from 1 (slowest) to 10 (fastest)
   */
  public static void setSpeed(int speed)
  {
    turtle().setSpeed(speed);
  }
  /**
   * Moves the Tortoise Forward the number of pixels specified. <br>
   * <div><b>Example:</b> {@code Tortoise.move(72)}</div>
   *
   * @param lengthInPixels
   *          The number of pixels to move. Negative numbers will move the
   *          Tortoise backwards.
   */
  public static void move(Number lengthInPixels)
  {
    turtle().move(lengthInPixels);
  }
  /**
   * Turns the Tortoise to the right (clockwise) the degrees specified. <br>
   * <div><b>Example:</b> {@code Tortoise.turn(90)}</div>
   *
   * @param degreesToTheRight
   *          The degrees to turn. Negative numbers will move the Tortoise to
   *          the left (counter-clockwise)
   */
  public static void turn(Number degreesToTheRight)
  {
    turtle().turn(degreesToTheRight.doubleValue());
  }
  /**
   * Gives you access to the window the
   * Tortoise is moving on so you can do things like change it's color. <br>
   * <b>Example:</b> {@code  TurtlePanel panel = Tortoise.getBackgroundWindow()}
   * @return the (program) window that the Tortoise is moving on
   */
  public static TurtleWindow getBackgroundWindow()
  {
    return turtle().getBackgroundWindow();
  }
  /**
   * Gets the current width of the pen drawn by the Tortoise. <br>
   * <div><b>Example:</b> {@code  width = Tortoise.getPenWidth()}</div>
   *
   * @return the width of the pen stroke
   */
  public static int getPenWidth()
  {
    return turtle().getPenWidth();
  }
  /**
   * Sets the width of the pen drawn by the Tortoise. <br>
   * <div><b>Example:</b> {@code  Tortoise.setPenWidth(2)}</div>
   *
   * @param width
   *          the width of the pen stroke
   */
  public static void setPenWidth(Number width)
  {
    turtle().setPenWidth(width.intValue());
  }
  /**
   * Gets the current color of the pen drawn by the Tortoise. <br>
   * <div><b>Example:</b> {@code  pen = Tortoise.getPenColor()}</div>
   *
   * @return the color of the pen stroke
   */
  public static Color getPenColor()
  {
    return turtle().getPenColor();
  }
  /**
   * Sets the color of the line drawn by the Tortoise. <br>
   * <div><b>Example:</b> {@code  Tortoise.setPenColor(PenColors.Reds.Red)}</div>
   *
   * @param color
   *          the color of the line drawn 
   * @see PenColors
   */
  public static void setPenColor(Color color)
  {
    turtle().setPenColor(color);
  }
  /**
   * Gets the current position of the Tortoise on the y axis. <br>
   * (0,0) is the top left of the screen <br>
   * <div><b>Example:</b> {@code  y = Tortoise.getY()}</div>
   *
   * @return y the position in pixels of the Tortoise on the Y axis
   */
  public static int getY()
  {
    return turtle().getY();
  }
  /**
   * Sets the position of the Tortoise on the y axis. <br>
   * (0,0) is the top left of the screen <br>
   * <div><b>Example:</b> {@code  Tortoise.setY(30);}</div>
   *
   * @param y
   *          the position in pixels of the Tortoise on the Y axis
   */
  public static void setY(int y)
  {
    turtle().setY(y);
  }
  /**
   * Gets the current position of the Tortoise on the x axis. <br>
   * (0,0) is the top left of the screen <br>
   * <div><b>Example:</b> {@code  x = Tortoise.getX()}</div>
   *
   * @return x the position in pixels of the Tortoise on the X axis
   */
  public static int getX()
  {
    return turtle().getX();
  }
  /**
   * Sets the position of the Tortoise on the x axis. <br>
   * (0,0) is the top left of the screen <br>
   * <div><b>Example:</b> {@code  Tortoise.setX(30);}</div>
   *
   * @param x
   *          the position in pixels of the Tortoise on the X axis
   */
  public static void setX(int x)
  {
    turtle().setX(x);
  }
  /**
   * Gets the current heading of the Tortoise. <br>
   * 0 degrees is due north. <br>
   * 90 degrees is due east. <br>
   * <div><b>Example:</b> {@code  angle = Tortoise.getAngleInDegrees()}</div>
   *
   * @return the angle in degrees of the Tortoise
   */
  public static double getAngle()
  {
    return turtle().getAngleInDegrees();
  }
  /**
   * Sets the angle the Tortoise is facing. <br>
   * 0 is straight up (like 'North') <br>
   * <div><b>Example:</b> {@code  Tortoise.setAngle(42);}</div>
   *
   * @param angle
   *          the angle in degrees
   */
  public static void setAngle(int angle)
  {
    turtle().setAngleInDegrees(angle);
  }
  /**
   * Changes the type of animal you are using. <br>
   * <div><b>Example:</b> {@code  Tortoise.setAnimal(Animals.Spider);}</div>
   *
   * @param animal the animal you want to use
   * @see Animals
   */
  public static void setAnimal(Animals animal)
  {
    turtle().setAnimal(animal);
  }
  /**
   * Blows up your turtle! <br>
   * <div><b>Example:</b> {@code  Tortoise.explode(Animals.ExplodedTurtle);}</div>
   *
   * @see Animals
   */
  public static void explode()
  {
    turtle().setAnimal(Animals.ExplodedTurtle);
  }
  /**
   * Makes it so the tortoise will not draw a line of color out of its butt. <br>
   * <b>Example:</b> {@code  Tortoise.penUp()}
   */
  public static void setPenUp()
  {
    turtle().penUp();
  }
  /**
   * Makes it so a line of color out of will trail from the Tortoise. <br>
   * <b>Example:</b> {@code  Tortoise.penDown()}
   */
  public static void setPenDown()
  {
    turtle().penDown();
  }
  /**
   * Removes everything from the window. <br>
   * <b>Example:</b> {@code  Tortoise.clearWindow()}
   */
  public static void clear()
  {
    turtle().clear();
    turtle().getBackgroundWindow().setTurtle(turtle());
  }
  /**
   * Hides the tortoise, you will still see the pen markings it made before and after it's hidden. <br>
   * <b>Example:</b> {@code  Tortoise.hide()}
   */
  public static void hide()
  {
    turtle().hide();
  }
  private static Turtle turtle()
  {
    return TortoiseUtils.getTurtle();
  }
  /**
   * Moves the Tortoise to a particular spot on the canvas. <br>
   * <div><b>Example:</b> {@code  Tortoise.moveTo(100,200);}</div>
   *
   * @param x
   *          the x position
   * @param y
   *          the y position
   */
  public static void moveTo(int x, int y)
  {
    turtle().moveTo(x, y);
  }
  public static TurtleWindow ___()
  {
    return new TurtleWindow();
  }
  /**
   * Makes a cool shape fast
   * <div><b>Example: </b> {@code tortoise.drawShape(6,PenColors.Reds.Red, 50, 20)}</div>
   * @param sides
   *            the number of sides
   * @param color
   *            a snazzy line color
   * @param length
   *            the bigger the better
   * @param width
   *            make a thick line - it's cool
   */
  public static void drawShape(int sides, Color color, int length, int width)
  {
    Tortoise.show();
    Tortoise.setSpeed(7);
    Tortoise.getBackgroundWindow().getCanvas().setBackground(PenColors.Yellows.Goldenrod);
    new Text("TKP Java - Make Some Shapes!").setTopLeft(225, 50).addTo(Tortoise.getBackgroundWindow());
    for (int i = 0; i < sides; i++)
    {
      Tortoise.setPenColor(color);
      Tortoise.setPenWidth(width);
      Tortoise.move(length);
      Tortoise.turn(360 / sides);
    }
    VirtualProctor.setClassName("Grace Hopper's Class");
    VirtualProctor.setName("Jean Bartik");
  }
  /**
   * Draws an entire Tortoise --  fast!
   * <div><b>Example: </b> {@code tortoise.drawTortoise()}</div>
   */
  public static void drawTortoise()
  {
    Tortoise.show();
    Tortoise.setSpeed(9);
    Tortoise.getBackgroundWindow().setBackground(PenColors.Greens.DarkSeaGreen);
    new Text("TKP Java - It's the Tortoise!").setTopLeft(200, 75).addTo(Tortoise.getBackgroundWindow());
    Tortoise.setPenColor(PenColors.Greens.Green);
    Tortoise.setPenWidth(3);
    makeTortoiseBody();
    Tortoise.setPenColor(PenColors.Browns.Brown);
    Tortoise.turn(-65);
    Tortoise.makeTortoiseLeg();
    Tortoise.turn(90);
    Tortoise.move(150);
    Tortoise.turn(-90);
    Tortoise.makeTortoiseLeg();
  }
  private static void makeTortoiseLeg()
  {
    for (int i = 0; i < 4; i++)
    {
      Tortoise.move(35);
      Tortoise.turn(90);
    }
  }
  private static void makeTortoiseBody()
  {
    Tortoise.turn(-90);
    Tortoise.move(255);
    Tortoise.turn(135);
    Tortoise.move(135);
    Tortoise.turn(45);
    Tortoise.move(120);
    Tortoise.turn(45);
    Tortoise.move(70);
    Tortoise.turn(-90);
    Tortoise.move(35);
    Tortoise.turn(45);
    Tortoise.move(60);
    Tortoise.turn(65);
    Tortoise.move(50);
    Tortoise.turn(115);
    Tortoise.move(65);
    Tortoise.turn(-25);
    Tortoise.move(65);
  }
  public static void setVisible(boolean b)
  {
    turtle().setFrameVisible(b);
    turtle().setPanelVisible(b);
  }
  /**
   * Checks if a tortoise can eat a slice of a pizza
   * <div><b>Example:</b> {@code  tortoise.eatPizza(pizza)}</div>
   *
   * @param pizza
   *            the pizza
   * @return whether or not there is pizza left to eat that a tortoise likes
   */
  public boolean eatPizza(Pizza pizza)
  {
    if (!pizza.takeSlice()) { return false; }
    if (this.topping == null) { return true; }
    if (this.topping != Topping.Cheese) { return pizza.hasTopping(topping); }
    return pizza.wasCooked() && pizza.hasTopping(topping);
  }
  /**
   * Checks to see if a tortoise likes a particular kind of pizza topping
   * <div><b>Example:</b> {@code  tortoise.likesTopping(topping)}</div>
   *
   * @param topping
   *            the topping
   */
  public void likesTopping(Topping topping)
  {
    this.topping = topping;
  }
}
