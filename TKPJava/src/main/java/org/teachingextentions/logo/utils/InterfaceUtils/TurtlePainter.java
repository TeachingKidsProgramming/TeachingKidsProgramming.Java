package src.main.java.org.teachingextentions.logo.utils.InterfaceUtils;

import src.main.java.org.teachingextentions.logo.Turtle;
import src.main.java.org.teachingextentions.logo.utils.LineAndShapeUtils.Paintable;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class TurtlePainter implements Paintable {
  private final Turtle turtle;
  private final Image  image;

  public TurtlePainter(Turtle turtle, Image image) {

    this.turtle = turtle;
    this.image = image;
  }

  @Override
  public void paint(Graphics2D g, JPanel caller) {
    if (turtle == null || turtle.isHidden()) {
      return;
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

  public Image getImage() {
    return image;
  }
}
