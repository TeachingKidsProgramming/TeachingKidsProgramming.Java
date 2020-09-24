package src.main.java.org.teachingextentions.logo.utils.LineAndShapeUtils;

public class AngleCalculator {

  private final int x1;
  private final int y1;
  private final int x2;
  private final int y2;

  public AngleCalculator(int x1, int y1, int x2, int y2) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
  }

  public double getDegreesWith0North(){
    int delta_x = this.x1 - this.x2;
    int delta_y = this.y1 - this.y2;
    double theta_radians = Math.atan2(delta_y, delta_x);
    double degrees = Math.toDegrees(theta_radians);
    return degrees - 90;
  }

}

