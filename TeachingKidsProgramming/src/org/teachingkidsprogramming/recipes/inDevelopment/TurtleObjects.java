package org.teachingkidsprogramming.recipes.inDevelopment;

import org.teachingextensions.logo.MultiTurtleWindow;
import org.teachingextensions.logo.Turtle;

public class TurtleObjects
{
  public MultiTurtleWindow mtw = new MultiTurtleWindow();
  public static void main(String[] args)
  {
    new TurtleObjects();
  }
  public TurtleObjects()
  {
    showSomeTurtles();
  }
  //
  private void showSomeTurtles()
  {
    makeSpeedyTurtle();
    makeSlowTurtle();
    makeCrazyTurtle();
  }
  private void makeSpeedyTurtle()
  {
    Turtle speedyTurtle = new Turtle();
    speedyTurtle.setSpeed(10);
    mtw.addAndShowTurtle(speedyTurtle);
    speedyTurtle.drawTriangle(100);
  }
  private void makeSlowTurtle()
  {
    Turtle slowTurtle = new Turtle();
    mtw.addAndShowTurtle(slowTurtle);
    slowTurtle.drawTriangle(-50);
  }
  private void makeCrazyTurtle()
  {
    Turtle crazyTurtle = new Turtle();
    mtw.addTurtle(crazyTurtle);
    crazyTurtle.drawLightning(55);
  }
}
