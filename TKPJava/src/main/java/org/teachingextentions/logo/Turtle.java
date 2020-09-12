package src.main.java.org.teachingextentions.logo;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import src.main.java.org.teachingextentions.logo.utils.TurtleWindowUtils.ProgramWindow;
import src.main.java.org.teachingextentions.logo.utils.TurtleWindowUtils.Sound;
import src.main.java.org.teachingextentions.logo.utils.TurtleWindowUtils.TurtleWindow;
import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.ThreadLauncher;
import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.Action0;
import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.Saver;
import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.SavingException;
import src.main.java.org.teachingextentions.logo.utils.LineAndShapeUtils.AngleCalculator;
import src.main.java.org.teachingextentions.logo.utils.LineAndShapeUtils.DeltaCalculator;
import src.main.java.org.teachingextentions.logo.utils.InterfaceUtils.TurtleFrame;
import src.main.java.org.teachingextentions.logo.utils.LineAndShapeUtils.LineSegment;

/**
 * <img src="https://lh5.googleusercontent.com/-B3Q59gpYW8o/T4tA2k_TYUI/AAAAAAAAAjo/WiqdoXjbkb0/s65/Tortoise.png" style="text-align: left" alt="A turtle drawing a line" >
 * The Turtle allows you to draw lines and shapes by moving it around on the window, and you can put more than one turtle on the same window...
 */
public class Turtle
{
  public static final int     TEST_SPEED      = Integer.MIN_VALUE;
  private static final double MAX_MOVE_AMOUNT = 5.0;
  private String              DEFAULT_NAME    = "Grace Hopper";
  public TurtleWindow         panel           = new TurtleWindow();
  public List<LineSegment>    trail           = new ArrayList<LineSegment>();
  private double              x               = 640 / 2;
  private double              y               = 480 / 2;
  private double              angleInDegrees  = 0;
  private TurtleFrame         frame           = new TurtleFrame();
  private int                 speed           = 1;
  private Color               color           = Color.black;
  private int                 width           = 2;
  private boolean             penDown         = true;
  private boolean             hidden;
  private Animals             animal;
  private Sound               sound           = new Sound();
  private String              name            = DEFAULT_NAME;
  public BufferedImage getImage()
  {
    BufferedImage image = panel.getWindowImage();
    clear();
    return image;
  }
  public void clear()
  {
    trail.clear();
    if (panel != null)
    {
      panel.getCanvas().clear();
    }
  }
  public void setPanel(TurtleWindow panel)
  {
    this.panel = panel;
  }
  public int getX()
  {
    return (int) x;
  }
  public void setX(Number x)
  {
    this.x = x.doubleValue();
  }
  public int getY()
  {
    return (int) y;
  }
  public void setY(Number y)
  {
    this.y = y.doubleValue();
  }
  public double getAngleInDegrees()
  {
    return angleInDegrees;
  }
  public void setAngleInDegrees(double angleInDegrees)
  {
    this.angleInDegrees = angleInDegrees;
  }
  public void turn(double amount)
  {
    double max = getTurnAmount(amount);
    Saver<Double> s = new Turner();
    animate(amount, max, s);
  }
  private double getTurnAmount(double amount)
  {
    amount = Math.abs(amount);
    if (getSpeed() == TEST_SPEED) { return amount; }
    return amount / (11 - getSpeed());
  }
  private void animate(double amount, double max, Saver<Double> s)
  {
    double sign = amount > 0 ? 1 : -1;
    amount = Math.abs(amount);
    while (amount > max)
    {
      s.save(max * sign);
      refreshPanel();
      amount -= max;
    }
    s.save(amount * sign);
    refreshPanel();
  }
  private void refreshPanel()
  {
    refreshPanel(panel);
  }
  private void refreshPanel(ProgramWindow panel)
  {
    long delay = getDelay();
    if (delay != TEST_SPEED)
    {
      panel.repaint();
      try
      {
        Thread.sleep(delay);
      }
      catch (InterruptedException e)
      {
        // do nothing
      }
    }
  }
  private long getDelay()
  {
    if (getSpeed() == 10) { return 1; }
    if (getSpeed() == TEST_SPEED) { return TEST_SPEED; }
    return 100 / getSpeed();
  }
  public String getName()
  {
    return name;
  }
  /**
   * Sets the name for a turtle instance 
   * <p><b>Example:</b> {@code myTurtle.setName(name)}</p>
   *
   * @param name
   *     Your turtle's name 
   */
  public void setName(String name)
  {
    this.name = name;
  }
  public int getSpeed()
  {
    return speed;
  }
  /**
   * Sets the speed that a turtle instance moves
   * <p><b>Example:</b> {@code myTurtle.setSpeed(speed)}</p>
   *
   * @param speed
   *     The speed from 1 (slowest) to 10 (fastest)
   */
  public void setSpeed(int speed)
  {
    if (speed != TEST_SPEED)
    {
      if (speed < 1 || 10 < speed) { throw new RuntimeException(String.format(
          "I call shenanigans!!!\nThe speed '%s' is not between the acceptable range of [1-10]\nPerhaps you should read the documentation",
          speed)); }
    }
    this.speed = speed;
  }
  public double getHeadingInDegrees()
  {
    return angleInDegrees;
  }
  /**
   * Sets the distance that a turtle instance moves in pixels
   * <p><b>Example:</b> {@code myTurtle.move(100)}</p>
   *
   * @param amount
   *     The distance that your turtle moves in pixels. Negative numbers will move your turtle backwards
   */
  public void move(Number amount)
  {
    double max = MAX_MOVE_AMOUNT;
    Saver<Double> s = penDown ? new Mover(new Point(getX(), getY())) : new EmptyMover();
    animate(amount.doubleValue(), max, s);
  }
  private void moveWithoutAnimation(Double save)
  {
    DeltaCalculator calculator = new DeltaCalculator(this.angleInDegrees, save);
    x += calculator.getX();
    y += calculator.getY();
  }
  public LineSegment[] getTrail()
  {
    return trail.toArray(new LineSegment[0]);
  }
  public Color getPenColor()
  {
    return color;
  }
  public void setPenColor(Color color)
  {
    this.color = color;
  }
  public int getPenWidth()
  {
    return width;
  }
  public void setPenWidth(int width)
  {
    this.width = width;
  }
  public void show()
  {
    this.panel.init(this, this.frame);
    hidden = false;
    this.setFrameVisible(true);
    this.setPanelVisible(true);
    refreshPanel(panel);
  }
  public TurtleWindow getBackgroundWindow()
  {
    return panel;
  }
  /**
   * Sets the animal
   * <p><b>Example:</b> {@code myTurtle.setAnimal(Animals.spider)}</p>
   *
   * @param animal
   *     The type of animal that appears on your window
   */
  public void setAnimal(Animals animal)
  {
    refreshPanel();
    getBackgroundWindow().setAnimal(animal);
    this.animal = animal;
  }
  public void penUp()
  {
    penDown = false;
  }
  public void penDown()
  {
    penDown = true;
  }
  public void print(String string)
  {
    // TODO Auto-generated method stub
  }
  public void speak()
  {
    this.sound.playSound();
  }
  public void hide()
  {
    hidden = true;
  }
  public boolean isHidden()
  {
    return hidden;
  }
  public void moveTo(final int x, final int y)
  {
    ThreadLauncher.launch(new Action0()
    {
      @Override
      public void call()
      {
        moveSynchronized(x, y);
      }
    });
  }
  public void moveSynchronized(int x, int y)
  {
    AngleCalculator calculator = new AngleCalculator(getX(), getY(), x, y);
    double angleOfWherePointIs = calculator.getDegreesWith0North();
    double direction = angleOfWherePointIs - getAngleInDegrees();
    turn(direction);
    // move the turtle the distance to the x y point
    double distance = new Point(x, y).distance(getX(), getY());
    move(distance);
  }
  /**
   * Draws a triangle of a specified size and orientation
   * <p><b>Example:</b> {@code myTurtle.drawTriangle(size)}</p>
   *
   * @param size
   *     The size of a side of the triangle, negative numbers draw an upside down triangle
   */
  public void drawTriangle(int size)
  {
    for (int i = 1; i <= 3; i++)
    {
      this.turn(360 / 3);
      this.move(size);
    }
  }
  /**
   * Draws a star of a specified size
   * <p><b>Example:</b> {@code myTurtle.drawStar(size)}</p>
   *
   * @param size
   *     The size of a side of the star
   */
  public void drawStar(int size)
  {
    for (int i = 1; i <= 5; i++)
    {
      this.turn(360 / 2.5);
      this.move(size);
    }
  }
  public boolean isDead()
  {
    return this.animal == Animals.ExplodedTurtle;
  }
  /**
   * Draws a lightning bolt of a specified length
   * <p><b>Example:</b> {@code myTurtle.drawLightning(length)}</p>
   *
   * @param length
   *     The length of a lightning bolt
   */
  public void drawLightning(int length)
  {
    this.setX(50);
    this.setY(350);
    this.setSpeed(10);
    for (int i = 1; i < 5; i++)
    {
      this.setPenWidth(i * 4);
      this.turn(65 + i);
      this.move(length);
      this.turn(-65);
      this.move(length);
    }
  }
  public void setFrameVisible(boolean b)
  {
    this.frame.setVisible(b);
  }
  public void setPanelVisible(boolean b)
  {
    panel.setVisible(b);
  }
  public void setFrame(JFrame frame2)
  {
    this.frame = new TurtleFrame(frame2);
  }
  public void setSound(Sound sound)
  {
    this.sound = sound;
  }
  /**
   * Current types are: ExplodedTurtle, Turtle, Spider, Squid, Unicorn
   */
  public enum Animals {
                       ExplodedTurtle, Turtle, Spider, Squid, Unicorn
  }
  private class Turner implements Saver<Double>
  {
    @Override
    public Double save(Double save) throws SavingException
    {
      smallTurn(save);
      return save;
    }
    private void smallTurn(double i)
    {
      angleInDegrees += i;
    }
  }
  private class Mover implements Saver<Double>
  {
    private final Point starting;
    private LineSegment line = null;
    public Mover(Point point)
    {
      this.starting = point;
    }
    @Override
    public Double save(Double save) throws SavingException
    {
      moveWithoutAnimation(save);
      if (line != null)
      {
        trail.remove(line);
      }
      line = new LineSegment(color, starting, new Point(getX(), getY()), width);
      trail.add(line);
      return save;
    }
  }
  private class EmptyMover implements Saver<Double>
  {
    @Override
    public Double save(Double save) throws SavingException
    {
      moveWithoutAnimation(save);
      return save;
    }
  }
}
