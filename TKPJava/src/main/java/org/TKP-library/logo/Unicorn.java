package org.teachingextensions.logo;

import org.teachingextensions.WindowUtils.ProgramWindow;
import org.teachingextensions.approvals.lite.util.ObjectUtils;
import org.teachingextensions.logo.Turtle.Animals;
import org.teachingextensions.logo.utils.LineAndShapeUtils.Paintable;
import org.teachingextensions.logo.utils.PuzzleUtils.Tile;

import javax.swing.*;
import java.awt.*;

/**
 * <img src="http://vignette2.wikia.nocookie.net/farmville/images/0/06/Sweet_Dreams_Unicorn-icon.png/revision/latest/scale-to-width/100?cb=20130802132644" style="text-align: left" alt="Unicorns are magical - like programming!"height=35 width=35 >
 * The Unicorn lets you add Unicorns (rather than Turtles!) to your window
 */
public class Unicorn implements Paintable
{
  private int       x;
  private int       y;
  private Image     image;
  private int       scale;
  private Dimension dimension = new Dimension(10, 10);
  public Unicorn(int x, int y, int scale)
  {
    this.x = x;
    this.y = y;
    this.scale = scale / 10;
    this.image = getImage();
  }
  private static Image getImage()
  {
    return ObjectUtils.loadImage(Tile.class, Animals.Unicorn + ".png");
  }
  /**
   * Adds a Unicorn to the Program Window. <br>
   * <div><b>Example:</b> {@code  Unicorn.addTo(programWindow)}</div>
   *
   * @param programWindow
   *          the current Program Window
   */
  public void addTo(ProgramWindow programWindow)
  {
    programWindow.add(this);
  }
  @Override
  public void paint(Graphics2D g, JPanel caller)
  {
    g.drawImage(this.image, this.x, this.y, this.dimension.width * scale, this.dimension.height * scale, null);
  }
}
