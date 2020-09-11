package src.main.java.org.teachingextentions.logo.utils.TurtleWindowUtils;

import java.util.ArrayList;
import java.util.List;

import src.main.java.org.teachingextentions.logo.Turtle;
import src.main.java.org.teachingextentions.logo.utils.ColorUtils.PenColors;
import src.main.java.org.teachingextentions.logo.utils.InterfaceUtils.MultiTurtlePainter;
import src.main.java.org.teachingextentions.logo.utils.InterfaceUtils.MultiTurtleTrailPainter;
import src.main.java.org.teachingextentions.logo.utils.InterfaceUtils.TurtleFrame;
import src.main.java.org.teachingextentions.logo.utils.LineAndShapeUtils.Paintable;

/**
 * Use this window when you want to put more than one turtle on the same window
 */
public class MultiTurtleWindow extends TurtleWindow
{
  private List<Turtle> turtles = new ArrayList<Turtle>();
  public MultiTurtleWindow()
  {
    super("Turtles, Turtles, Turtles!");
    this.setBackground(PenColors.Blues.DarkSlateBlue);
  }
  /**
   * Adds a turtle instance to a window
   * NOTE: this method must be called BEFORE calling any other methods on turtle instances
   * <p><b>Example:</b> {@code multiTurtleWindow.addTurtle(myTurtle)}</p>
   *
   * @param turtle
   *     A turtle instance
   */
  public void addTurtle(Turtle turtle)
  {
    if (turtle == null) { return; }
    turtle.setFrame(this.getFrame());
    turtle.setPanel(this);
    this.turtles.add(turtle);
    clearPainters();
    configurePainters();
  }
  @Override
  public TurtleWindow init(Turtle turtle, TurtleFrame frame)
  {
    return this;
  }
  @Override
  protected Paintable createTurtleTrailPainter()
  {
    this.setTrailPainter(new MultiTurtleTrailPainter(this.turtles));
    return this.getTrailPainter();
  }
  @Override
  protected Paintable createTurtlePainter()
  {
    this.setTurtlePainter(new MultiTurtlePainter(this.turtles, this.getImage()));
    return this.getTurtlePainter();
  }
  /**
   * Gets a count of turtles for a window 
   * <p><b>Example:</b> {@code multiTurtleWindow.getTurtlesCount()}</p>
   *
   */
  public int getTurtleCount()
  {
    return this.turtles.size();
  }
  /**
   * Adds a turtle instance to a window and shows it on the window
   * <p><b>Example:</b> {@code multiTurtleWindow.addAndShowTurtle(myTurtle)}</p>
   *
   * @param turtle
   *     A turtle instance
   */
  public void addAndShowTurtle(Turtle turtle)
  {
    this.addTurtle(turtle);
    this.showTurtle(turtle);
  }
  private void showTurtle(Turtle turtle)
  {
    turtle.show();
  }
}
