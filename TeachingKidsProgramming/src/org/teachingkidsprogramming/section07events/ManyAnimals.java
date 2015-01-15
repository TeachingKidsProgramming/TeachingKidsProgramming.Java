package org.teachingkidsprogramming.section07events;

public class ManyAnimals
{
  public ManyAnimals()
  {
    showSomeTurtles();
  }
  //create container for Turtles HINT: Use ArrayList --#2.1
  //create a window for many turtles HINT: Use MultiTurtlePanel --#1.1
  private void showSomeTurtles()
  {
    //show the panel --#1.2
    //set the size to 100 --#5.4
    //add three turtles HINT: FOR loop which 'does an action' --#2.2
    //create a turtle --#2.4
    //add the turtles to the container for turtles --#2.5
    //repeat --#2.2
    //add all turtles to the window HINT: Use a foreach loop --#3.1
    //NOTE: must call addTurtle BEFORE calling other methods --#3.3
    //add all turtles to the window --#3.4
    //repeat --#3.2
    //teleport all turtles on the window HINT: Use a FOR loop and ZERO --#4.1
    //set the X position to i*100 + 350 --#4.3
    //set the Y position to i*100 + 100 --#4.4
    //repeat --#4.2
    //set some values for all turtles HINT: Use a foreach loop --#5.1
    //set the speed of all turtle's to 7 --#5.3
    //have every turtle draw a star of the current size --#5.4
    //repeat --#5.2
  }
  public static void main(String[] args)
  {
    new ManyAnimals();
  }
}
