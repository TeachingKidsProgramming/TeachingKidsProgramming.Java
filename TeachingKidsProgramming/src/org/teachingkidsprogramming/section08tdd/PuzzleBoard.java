package org.teachingkidsprogramming.section08tdd;

import java.awt.Color;
import java.awt.Graphics2D;

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
  }
}
//be aware of time, ex. every second change the x by a certain value (animates)
//be able to hold on to a tile so that it can be manipulated
