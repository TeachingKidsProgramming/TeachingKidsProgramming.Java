package org.teachingkidsprogramming.section08tdd;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import org.teachingextensions.logo.PenColors;

public class PuzzleBoard extends JPanel
{
  private static final long serialVersionUID = -3592444274530147326L;
  private List<Tile>        tiles;
  private List<Point>       positions;
  public PuzzleBoard()
  {
    this.positions = createPositions();
    this.tiles = createTiles(this.positions);
  }
  private static List<Point> createPositions()
  {
    ArrayList<Point> p = new ArrayList<Point>(9);
    Point point = null;
    for (int i = 0; i < 9; i++)
    {
      if (i < 3)
      {
        point = new Point(35, 35 + (127 * i));
      }
      else if (i < 6)
      {
        point = new Point(162, 35 + (127 * (i - 3)));
      }
      else
      {
        point = new Point(289, 35 + (127 * (i - 6)));
      }
      if (point != null)
      {
        p.add(point);
      }
      point = null;
    }
    return p;
  }
  private static List<Tile> createTiles(List<Point> positions)
  {
    ArrayList<Tile> t = new ArrayList<Tile>(9);
    for (int i = 0; i < 8; i++)
    {
      t.add(new Tile(i, positions.get(i)));
    }
    return t;
  }
  @Override
  protected void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    drawBorder(g);
    drawField(g);
    drawTiles(g);
  }
  private void drawTiles(Graphics g)
  {
    Graphics2D g2d = (Graphics2D) g.create();
    for (Tile tile : tiles)
    {
      tile.paint(g2d);
    }
    g2d.dispose();
  }
  private void drawField(Graphics g)
  {
    g.setColor(PenColors.Blues.SkyBlue);
    g.fillRect(30, 30, 386, 386);
  }
  private void drawBorder(Graphics g)
  {
    g.setColor(PenColors.Blues.DarkBlue);
    g.fillRect(20, 20, 410, 410);
  }
  public Tile getPiece(int i)
  {
    return this.tiles.get(i);
  }
  public List<Point> getPositions()
  {
    return new ArrayList<Point>(positions);
  }
}