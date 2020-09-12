package src.main.java.org.teachingextentions.logo.utils.InterfaceUtils;

import src.main.java.org.teachingextentions.logo.Turtle;
import src.main.java.org.teachingextentions.logo.utils.LineAndShapeUtils.Paintable;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.List;

public class MultiTurtlePainter implements Paintable {
  private final List<Turtle> turtles;
  private final Image        image;

  public MultiTurtlePainter(List<Turtle> turtles, Image image) {
    this.turtles = turtles;
    this.image = image;
  }

  @Override
  public void paint(Graphics2D g, JPanel caller) {
    if (this.turtles == null){
      return;
    }

    for (Turtle turtle : turtles)
    {
      if (turtle.isHidden())
      {
        continue;
      }
      Image image = getImage();
      int xCenter = image.getWidth(null) / 2;
      int yCenter = image.getHeight(null) / 2;
      int x = turtle.getX() - xCenter;
      int y = turtle.getY() - yCenter;
      AffineTransform rotate = AffineTransform.getRotateInstance(Math.toRadians(turtle.getHeadingInDegrees()),
          xCenter, yCenter);
      AffineTransform move = AffineTransform.getTranslateInstance(x, y);
      move.concatenate(rotate);
      g.drawImage(image, move, null);
    }
  }

  public Image getImage() {
    return image;
  }
}
