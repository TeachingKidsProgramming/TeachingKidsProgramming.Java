package org.teachingkidsprogramming.section07events;

import java.util.ArrayList;

import org.teachingextensions.logo.MultiTurtlePanel;
import org.teachingextensions.logo.Turtle;
import org.teachingextensions.windows.MouseLeftClickListener;

public class ManyAnimals implements MouseLeftClickListener
{
  public ManyAnimals()
  {
    showSomeTurtles();
  }
  //create container for Turtles HINT: Use ArrayList
  public ArrayList<Turtle> turtles = new ArrayList<Turtle>();
  //create a window for many turtles HINT: Use MultiTurtlePanel
  public MultiTurtlePanel  mt      = new MultiTurtlePanel();
  private void showSomeTurtles()
  {
    //show the panel
    mt.showPanel();
    //listen for left mouse button click
    //mt.addMouseLeftClickListener(this);
    //set the size to 100
    int size = 100;
    //add three turtles HINT: Use a For loop
    for (int i = 1; i <= 3; i++)
    {
      //create a turtle
      Turtle turtle = new Turtle();
      //add the turtles to the container for turtles
      turtles.add(turtle);
    }
    //add all turtles to the window HINT: Use a FOR loop
    for (Turtle turtle : turtles)
    {
      //NOTE: must call addTurtle BEFORE calling other methods 
      //add all turtles to the window
      mt.addTurtle(turtle);
    }
    //teleport all turtles on the window HINT: Use a FOR loop and ZERO
    for (int i = 0; i < 3; i++)
    {
      //set the X position to i*100 + 350 
      turtles.get(i).setX(i * 100 + 350);
      //set the Y position to i*100 + 100 
      turtles.get(i).setY(i * 100 + 100);
    }
    //set some values for all turtles HINT: Use a FOR loop
    for (Turtle turtle : turtles)
    {
      //set the speed of all turtle's to 7
      turtle.setSpeed(7);
      //have every turtle draw a star of the current size
      turtle.drawStar(size);
    }
  }
  @Override
  //threading error - Virtual Proctor contention
  public void onLeftMouseClick(int x, int y)
  {
    int size = 200;
    //create a new Turtle
    Turtle turtle = new Turtle();
    //add another turtle to the turtles
    turtles.add(turtle);
    // the turtle to the window
    mt.addTurtle(turtle);
    turtle.show();
    // teleport the new turtle to the x and y of the mouse click
    turtle.setX(x);
    turtle.setY(y);
    // have this turtle draw a star
    turtle.drawStar(size);
  }
  public static void main(String[] args)
  {
    new ManyAnimals();
  }
}
