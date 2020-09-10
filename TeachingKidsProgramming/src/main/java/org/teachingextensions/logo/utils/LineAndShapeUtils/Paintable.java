package org.teachingextensions.logo.utils.LineAndShapeUtils;

import java.awt.Graphics2D;

import javax.swing.JPanel;

public interface Paintable
{
  public static Paintable NOTHING = new Paintable()
                                  {
                                    @Override
                                    public void paint(Graphics2D g, JPanel caller)
                                    {
                                    }
                                  };
  void paint(Graphics2D g, JPanel caller);
}
