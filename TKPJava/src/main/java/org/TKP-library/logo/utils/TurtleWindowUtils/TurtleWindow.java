package WindowUtils;

import org.teachingextensions.approvals.lite.util.ObjectUtils;
import org.teachingextensions.logo.Turtle;
import org.teachingextensions.logo.Turtle.Animals;
import org.teachingextensions.logo.utils.InterfaceUtils.TurtleFrame;
import org.teachingextensions.logo.utils.InterfaceUtils.TurtlePainter;
import org.teachingextensions.logo.utils.InterfaceUtils.TurtleTrailPainter;
import org.teachingextensions.logo.utils.LineAndShapeUtils.Paintable;

import java.awt.*;

public class TurtleWindow extends ProgramWindow {
  protected Animals animal = Animals.Turtle;
  protected Image     image;
  private   Turtle    turtle;
  private   Paintable trailPainter;
  private   Paintable turtlePainter;

  public TurtleWindow() {
    this(null, null);
  }

  public TurtleWindow(String title) {
    this(title, null);
  }

  public TurtleWindow(String title, Turtle turtle) {
    super(title);
    this.turtle = turtle;
    this.image = loadAnimal();
    configurePainters();
  }

  public void setTurtle(Turtle turtle) {
    this.turtle = turtle;
    clearPainters();
    configurePainters();
  }

  public synchronized Image getImage() {
    if (image == null) {
      setAnimal(Animals.Turtle);
    }
    return image;
  }

  public synchronized void setAnimal(Animals animal) {
    this.animal = animal;
    this.image = loadAnimal();
    clearPainters();
    configurePainters();
  }

  public void ___() {
    // blank for the DeepDive
  }

  protected void clearPainters() {
    this.getCanvas().remove(this.trailPainter)
        .remove(this.turtlePainter);
  }

  protected void configurePainters() {
    this.getCanvas().add(createTurtleTrailPainter())
        .add(createTurtlePainter());
  }

  protected Paintable createTurtleTrailPainter() {
    return this.turtlePainter = new TurtlePainter(this.turtle, this.getImage());
  }

  protected Paintable createTurtlePainter() {
    return this.trailPainter = new TurtleTrailPainter(this.turtle);
  }

  protected Image loadAnimal() {
    return ObjectUtils.loadImage(TurtleWindow.class, this.animal + ".png");
  }

  protected Paintable getTrailPainter() {
    return trailPainter;
  }

  protected void setTrailPainter(Paintable trailPainter) {
    this.trailPainter = trailPainter;
  }

  protected Paintable getTurtlePainter() {
    return turtlePainter;
  }

  protected void setTurtlePainter(Paintable turtlePainter) {
    this.turtlePainter = turtlePainter;
  }

  public TurtleWindow init(Turtle turtle, TurtleFrame frame) {
    if (this.turtle != null){
      return this;
    }

    if (turtle.getSpeed() != Turtle.TEST_SPEED) {
      this.addTo(frame);
      frame.setStandardLayout();
    }

    this.setTurtle(turtle);
    return this;
  }
}

