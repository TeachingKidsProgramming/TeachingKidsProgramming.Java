package src.main.java.org.teachingextentions.logo;

import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.Approvals;
import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.ApprovalResults;
import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.ObjectUtils;
import src.main.java.org.teachingextentions.logo.Turtle;

public class TortoiseUtils {
  private static Turtle TURTLE = new Turtle();

  /**
   * Captures an image of the result of your program and displays it to you
   */
  public static void verify() {
    try {
      Approvals.verify(TURTLE.getImage());
    } catch (Exception e) {
      throw ObjectUtils.throwAsError(e);
    } finally {
      TortoiseUtils.resetTurtle();
    }
  }

  public static void resetTurtle() {
    TURTLE = new Turtle();
  }

  public static void setOrientation(int x, int y, int angle) {
    TURTLE.setX(x);
    TURTLE.setY(y);
    TURTLE.setAngleInDegrees(angle);
  }

  public static Turtle getTurtle() {
    return TURTLE;
  }

  public static void setTurtle(Turtle turtle) {
    TortoiseUtils.TURTLE = turtle;
  }

  public static void verifyForOs() {
    ApprovalResults.UniqueForOs();
    verify();
  }

  public static void writeMessage(String string, int x, int y) {
    TURTLE.setX(x);
    TURTLE.setY(y);
    TURTLE.print(string);
  }
}
