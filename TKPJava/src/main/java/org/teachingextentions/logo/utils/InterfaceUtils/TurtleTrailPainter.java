package src.main.java.org.teachingextentions.logo.utils.InterfaceUtils;

import src.main.java.org.teachingextentions.logo.Turtle;
import src.main.java.org.teachingextentions.logo.utils.LineAndShapeUtils.LineSegment;
import src.main.java.org.teachingextentions.logo.utils.LineAndShapeUtils.Paintable;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class TurtleTrailPainter implements Paintable {
  private final Turtle turtle;

  public TurtleTrailPainter(Turtle turtle) {

    this.turtle = turtle;
  }

  @Override
  public void paint(Graphics2D g, JPanel caller) {
    if (turtle == null) {
      return;
    }
    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
    g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
    g.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
    for (LineSegment l : turtle.getTrail()) {
      if (l != null) {
        g.setColor(l.getColor());
        g.setStroke(new BasicStroke(l.getWidth(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
        g.draw(new Line2D.Double(l.getStart().x, l.getStart().y, l.getEnd().x, l.getEnd().y));
      }
    }
  }
}
