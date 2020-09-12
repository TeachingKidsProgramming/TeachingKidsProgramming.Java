package src.main.java.org.teachingextentions.logo.utils.InterfaceUtils;

import src.main.java.org.teachingextentions.logo.Turtle;
import src.main.java.org.teachingextentions.logo.utils.ColorUtils.PenColors;
import src.main.java.org.teachingextentions.logo.utils.LineAndShapeUtils.LineSegment;
import src.main.java.org.teachingextentions.logo.utils.LineAndShapeUtils.Paintable;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.List;

public class MultiTurtleTrailPainter implements Paintable {
  private final List<Turtle> turtles;

  public MultiTurtleTrailPainter(List<Turtle> turtles) {
    this.turtles = turtles;
  }

  @Override
  public void paint(Graphics2D g, JPanel caller) {
    if (turtles == null) { return; }

    for (Turtle turtle : turtles)
    {
      paintTrail(turtle.getTrail(), g);
    }
  }

  private void paintTrail(final LineSegment[] trail, Graphics2D g) {
    for (LineSegment l : trail) {
      g.setColor(PenColors.Yellows.Gold);
      g.setStroke(new BasicStroke(l.getWidth(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
      g.draw(new Line2D.Double(l.getStart().x, l.getStart().y, l.getEnd().x, l.getEnd().y));
    }
  }
}
