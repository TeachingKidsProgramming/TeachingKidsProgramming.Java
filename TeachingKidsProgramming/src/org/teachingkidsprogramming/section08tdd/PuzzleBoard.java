package org.teachingkidsprogramming.section08tdd;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import org.teachingextensions.logo.Paintable;
import org.teachingextensions.logo.PenColors;
import org.teachingextensions.windows.ProgramWindow;

public class PuzzleBoard extends JPanel implements Paintable
{
  private static final long serialVersionUID = 1L;
  public void addTo(ProgramWindow panel)
  {
    panel.addPaintable(this);
  }
  @Override
  public void paint(Graphics2D g, JPanel caller)
  {
    Color color2 = PenColors.Blues.DarkBlue;
    g.setColor(color2);
    g.fillRect(20, 20, 410, 410);
    g.setColor(PenColors.Blues.SkyBlue);
    g.fillRect(30, 30, 386, 386);
    String[] tiles = {"Batgirl1a.png",
        "Batgirl1b.png",
        "Batgirl1c.png",
        "Batgirl2a.png",
        "Batgirl2b.png",
        "Batgirl2c.png",
        "Batgirl3a.png",
        "Batgirl3b.png",
        "Batgirl3c.png"};
    for (int i = 0; i < 8; i++)
    {
      if (i < 3)
      {
        drawTile(g, tiles[i], 35, 35 + (127 * i));
      }
      else if (i < 6)
        drawTile(g, tiles[i], 162, 35 + (127 * (i - 3)));
      else
      {
        drawTile(g, tiles[i], 289, 35 + (127 * (i - 6)));
      }
    }
  }
  private void drawTile(Graphics2D g, String tile, int x, int y)
  {
    URL imagePicture = this.getClass().getResource(tile);
    Image img = new ImageIcon(imagePicture).getImage();
    g.drawImage(img, x, y, 122, 122, null);
  }
}
