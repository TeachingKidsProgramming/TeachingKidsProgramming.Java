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
  //create an ArrayList of Turtle Objects
  public ArrayList<Turtle> turtles = new ArrayList<Turtle>();
  //create a window for many turtles
  public MultiTurtlePanel  mt      = new MultiTurtlePanel();
  private void showSomeTurtles()
  {
    mt.showPanel();
    //Have SimpleBubble listen for when the left mouse button is clicked in your program window
    //mt.addMouseLeftClickListener(this);
    int size = 100;
    //add three turtles
    for (int i = 1; i <= 3; i++)
    {
      //create a turtle
      Turtle turtle = new Turtle();
      //add the turtles to the turtles
      turtles.add(turtle);
    }
    //add all the turtles to the window
    for (Turtle turtle : turtles)
    {
      //must call addTurtle BEFORE calling other methods 
      //add the first turtle to the windows
      mt.addTurtle(turtle);
    }
    //set the X, Y - teleport
    for (int i = 0; i < 3; i++)
    {
      turtles.get(i).setX(i * 100 + 350);
      turtles.get(i).setY(i * 100 + 100);
    }
    for (Turtle turtle : turtles)
    {
      //have the first Turtle draw a star
      turtle.setSpeed(7);
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
