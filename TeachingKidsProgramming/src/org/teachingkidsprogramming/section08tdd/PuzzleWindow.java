package org.teachingkidsprogramming.section08tdd;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.net.URL;
import java.util.Calendar;

import javax.swing.ImageIcon;

import org.teachingextensions.windows.ProgramWindow;

public class PuzzleWindow extends ProgramWindow
{
  private int      y     = 35;
  private String[] tiles = {"Batgirl1a.png",
      "Batgirl1b.png",
      "Batgirl1c.png",
      "Batgirl2a.png",
      "Batgirl2b.png",
      "Batgirl2c.png",
      "Batgirl3a.png",
      "Batgirl3b.png",
      "Batgirl3c.png"    };
  public PuzzleWindow(String title)
  {
    super(title);
  }
  //  @Override
  //  public void paint(Graphics g)
  //  {
  //    super.paint(g);
  //    for (int i = 0; i < 8; i++)
  //    {
  //      if (i < 3)
  //      {
  //        Tile t = new Tile(tiles[i], 35, y + (127 * i));
  //        t.paint((Graphics2D) g, this);
  //        //drawTile(g, tiles[i], 35, 35 + (127 * i));
  //      }
  //      else if (i < 6)
  //        drawTile((Graphics2D) g, tiles[i], 162, y + (127 * (i - 3)));
  //      else
  //      {
  //        drawTile((Graphics2D) g, tiles[i], 289, y + (127 * (i - 6)));
  //      }
  //    }
  //  }
  private void drawTile(Graphics2D g, String tile, int x, int y)
  {
    URL imagePicture = this.getClass().getResource(tile);
    Image img = new ImageIcon(imagePicture).getImage();
    g.drawImage(img, x, y, 122, 122, null);
  }
  @Override
  public void update(Graphics g)
  {
    super.update(g);
    Calendar c = Calendar.getInstance();
    long l = c.getTimeInMillis();
    long m = l % 1000;
    if (m == 0)
    {
      y += 20;
    }
    for (int i = 0; i < 8; i++)
    {
      if (i < 3)
      {
        Tile t = new Tile(tiles[i], 35, y + (127 * i));
        t.paint((Graphics2D) g, this);
        //drawTile(g, tiles[i], 35, 35 + (127 * i));
      }
      else if (i < 6)
        drawTile((Graphics2D) g, tiles[i], 162, y + (127 * (i - 3)));
      else
      {
        drawTile((Graphics2D) g, tiles[i], 289, y + (127 * (i - 6)));
      }
    }
  }
}
