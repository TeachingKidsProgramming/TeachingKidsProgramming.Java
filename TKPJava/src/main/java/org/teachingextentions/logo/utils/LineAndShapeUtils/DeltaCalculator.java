package src.main.java.org.teachingextentions.logo.utils.LineAndShapeUtils;

public class DeltaCalculator {
  private final double angleInDegrees;
  private final double size;

  public DeltaCalculator(double angleInDegrees, double size) {
    this.angleInDegrees = angleInDegrees;
    this.size = size;
  }

  public double getX() {
    return this.size * Math.sin(Math.toRadians(this.angleInDegrees));
  }

  public double getY() {
    return -this.size * Math.cos(Math.toRadians(this.angleInDegrees));
  }
}
