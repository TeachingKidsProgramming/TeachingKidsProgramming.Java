package org.teachingkidsprogramming.section08tdd;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.net.URL;

import javax.swing.ImageIcon;

public class Tile
{
  private final static String[] resources = {"Batgirl1a.png",
      "Batgirl1b.png",
      "Batgirl1c.png",
      "Batgirl2a.png",
      "Batgirl2b.png",
      "Batgirl2c.png",
      "Batgirl3a.png",
      "Batgirl3b.png",
      "Batgirl3c.png"                     };
  private final static int      width     = 122;
  private final static int      height    = 122;
  private Image                 image;
  private Point                 position;
  private Point                 target;
  public Tile(int imageIdx, Point position)
  {
    this.position = new Point(position.x, position.y);
    URL resource = this.getClass().getResource(resources[imageIdx]);
    if (resource == null) { throw new IllegalStateException("Could not find tile image"); }
    this.image = new ImageIcon(resource).getImage();
  }
  public void paint(Graphics2D g2d)
  {
    g2d.drawImage(this.image, this.position.x, this.position.y, width, height, null);
  }
  public boolean isAt(Point point)
  {
    return this.position.x == point.x && this.position.y == point.y;
  }
  public void moveTo(Point target)
  {
    this.target = target;
  }
  public boolean isMovingTo(Point target)
  {
    return this.target != null && this.target.x == target.x && this.target.y == target.y;
  }
  public void step()
  {
    int x = this.position.x;
    int size = 1;
    if (x < this.target.x)
    {
      x += size;
    }
    if (this.target.x < x)
    {
      x -= size;
    }
    int y = this.position.y;
    if (y < this.target.y)
    {
      y += size;
    }
    if (this.target.y < y)
    {
      y -= size;
    }
    this.position = new Point(x, y);
  }
}
