package logo.utils.LineAndShapeUtils;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import org.teachingextensions.WindowUtils.ProgramWindow;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;

/**
 * The Diamond allows you to draw diamonds on the window
 */
public class Diamond implements Paintable
{
  private final int   radius;
  private final Color mainColor;
  private int         x;
  private int         y;
  private int         percentTransparent;
  public Diamond(int radius, Color color)
  {
    this.radius = radius;
    this.mainColor = color;
  }
  /**
   * Sets the corners of the diamond
   * <div><b>Example:</b> {@code  diamond.setCorners(8,10)}</div>
   *
   * @param x
   *          The x value
   * @param y
   *          The y value
   */
  public void setCorners(int x, int y)
  {
    this.x = x;
    this.y = y;
  }
  public int getRadius()
  {
    return this.radius;
  }
  /**
   * Adds a diamond to the window
   * <div><b>Example:</b> {@code  diamond.addTo(panel)}</div>
   *
   * @param panel
   *          the ProgramWindow or panel
   */
  public void addTo(ProgramWindow panel)
  {
    panel.getCanvas().add(this);
  }
  /**
   * Paints a diamond
   * <div><b>Example:</b> {@code  diamond.paint(g,caller)}</div>
   *
   * @param g
   *          the graphics object
   * @param caller
   *          the Program Window or panel
   */
  @Override
  public void paint(Graphics2D g, JPanel caller)
  {
    Color color2 = PenColors.getTransparentVersion(mainColor, percentTransparent);
    g.setColor(color2);
    int width = 400;
    int height = 300;
    g.rotate(50);
    g.fillRect(x, y, width, height);
  }
  /**
   * Sets the transparency of the diamond
   * <div><b>Example:</b> {@code  diamond.setTransparency(80)}</div>
   *
   * @param percentTransparent
   *          The percentage of transparency of the diamond
   */
  public void setTransparency(int percentTransparent)
  {
    this.percentTransparent = percentTransparent;
  }
  public void removeFrom(ProgramWindow panel)
  {
    panel.remove(this);
  }
  public int getX()
  {
    return this.x;
  }
  public int getY()
  {
    return this.y;
  }
}
