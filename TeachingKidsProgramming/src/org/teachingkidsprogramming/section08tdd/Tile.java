package org.teachingkidsprogramming.section08tdd;

import java.awt.Graphics2D;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import org.teachingextensions.logo.Paintable;

public class Tile implements Paintable
{
  private String image;
  private int    x;
  private int    y;
  private int    w = 122;
  private int    h = 122;
  public Tile(String image, int x, int y)
  {
    this.image = image;
    this.setX(x);
    this.setY(y);
  }
  @Override
  public void paint(Graphics2D g, JPanel caller)
  {
    URL imagePicture = this.getClass().getResource(this.image);
    Image img = new ImageIcon(imagePicture).getImage();
    g.drawImage(img, getX(), getY(), w, h, null);
  }
  private int getX()
  {
    return x;
  }
  private void setX(int x)
  {
    this.x = x;
  }
  private int getY()
  {
    return y;
  }
  private void setY(int y)
  {
    this.y = y;
  }
}
// use 're-paint' over and over on each move (use awt to loop)