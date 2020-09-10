package org.teachingextensions.logo.utils.PuzzleUtils;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;

import org.teachingextensions.approvals.lite.util.ObjectUtils;

/**
 * A tile is a square on the board with an image on it.
 */
public class Tile
{
  private static final String[] resources = {"Batgirl1a.png",
      "Batgirl2a.png",
      "Batgirl3a.png",
      "Batgirl1b.png",
      "Batgirl2b.png",
      "Batgirl3b.png",
      "Batgirl1c.png",
      "Batgirl2c.png",
      "Batgirl3c.png"                     };
  private static final Point    origin    = new Point(35, 35);
  private final Image           image;
  private final Dimension       dimension = new Dimension(122, 122);
  private Point                 position;
  private Point                 target;
  public Tile(int cell, int image)
  {
    this.position = getPosition(cell);
    this.image = getImage(image);
  }
  public static Point getPosition(int cell)
  {
    Point offset = Puzzle.getPosition(cell);
    return new Point(origin.x + (127 * offset.x), origin.y + (127 * offset.y));
  }
  private static Image getImage(int image)
  {
    return ObjectUtils.loadImage(Tile.class, resources[image]);
  }
  private static int stepTowardGoal(int current, int goal)
  {
    if (current < goal) { return current + 1; }
    if (goal < current) { return current - 1; }
    return current;
  }
  public void paint(Graphics2D g2d)
  {
    g2d.drawImage(this.image, this.position.x, this.position.y, this.dimension.width, this.dimension.height, null);
  }
  public boolean isAtTarget()
  {
    return target == null || (target.x == position.x && target.y == position.y);
  }
  public void step()
  {
    int x = stepTowardGoal(position.x, target.x);
    int y = stepTowardGoal(position.y, target.y);
    this.position = new Point(x, y);
  }
  public void moveTo(Point goal)
  {
    target = goal;
  }
  @Override
  public String toString()
  {
    return "Tile{" + position.x + ", " + position.y + '}';
  }
}
