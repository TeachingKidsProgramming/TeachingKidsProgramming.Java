package org.teachingkidsprogramming.section07events;

import org.teachingextensions.logo.MultiTurtlePanel;
import org.teachingextensions.logo.Turtle;
import org.teachingextensions.windows.MouseLeftClickListener;

public class ManyAnimals implements MouseLeftClickListener
{
  public ManyAnimals()
  {
    showSomeTurtles();
  }
  private void showSomeTurtles()
  {
    MultiTurtlePanel mt = new MultiTurtlePanel();
    Turtle t1 = new Turtle();
    mt.addTurtle(t1);
    t1.setX(100);
    t1.setY(300);
    Turtle t2 = new Turtle();
    mt.addTurtle(t2);
    t1.setX(300);
    t1.setY(100);
    mt.showPanel();
  }
  @Override
  public void onLeftMouseClick(int x, int y)
  {
    // createTurtles (recipe below) --#8
    //------------- Recipe for createTurtles --#8
    // Remove previous Tortoise from your program window --#9
    // programWindow.removePaintable();
    // Set the count of Turtles to a random number between 10 and 50 --#2.5
    // Create a tortoise at 200, 300 --#2.1
    // Add the circle to your program window --#2.4
    //------------- End of createTurtles recipe --#8
  }
  public static void main(String[] args)
  {
    new ManyAnimals();
  }
}
