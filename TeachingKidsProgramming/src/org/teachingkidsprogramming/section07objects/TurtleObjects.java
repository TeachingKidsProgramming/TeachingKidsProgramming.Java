package org.teachingkidsprogramming.section07objects;

import org.teachingextensions.WindowUtils.MultiTurtleWindow;
import org.teachingextensions.logo.Turtle;
//
//NOTE: This recipe is in development and will be updated as it goes through our testing process
//

public class TurtleObjects
{
  //Uncomment the line of code below to create a window for your turtles --#1
  public MultiTurtleWindow mtw = new MultiTurtleWindow();
  //
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
  //Create this method and body --#2
  //Teacher to point out the mtw.addAndShowTurtle method
  //Teacher to ask 'what are the steps of the drawTriangle method'?
  private void makeSpeedyTurtle()
  {
    Turtle speedyTurtle = new Turtle();
    speedyTurtle.setSpeed(10);
    mtw.addAndShowTurtle(speedyTurtle);
    speedyTurtle.drawTriangle(100);
  }
  //Create this method and body --#3
  //Teacher to ask why this turtle is slower than the first one
  //Teacher to ask why the two turtles start at the same spot
  private void makeSlowTurtle()
  {
    Turtle slowTurtle = new Turtle();
    mtw.addAndShowTurtle(slowTurtle);
    slowTurtle.drawTriangle(-50);
  }
  //Create this method and body --#4
  //Teacher to ask why is this turtle faster than the second one
  //Teacher to ask why does this turtle 'start' in a different location
  //Teacher to ask why does this turtle show up AFTER the other two HINT: mtw.addTurtle method
  //Teacher to ask what does the drawLightning method do?
  private void makeCrazyTurtle()
  {
    Turtle crazyTurtle = new Turtle();
    mtw.addTurtle(crazyTurtle);
    crazyTurtle.drawLightning(55);
  }
}
