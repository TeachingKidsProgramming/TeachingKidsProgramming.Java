package org.teachingkidsprogramming.section07objects;

import org.teachingextensions.WindowUtils.MultiTurtleWindow;

public class TurtleObjects
{
  public MultiTurtleWindow mtw = new MultiTurtleWindow();
  public TurtleObjects()
  {
    showSomeTurtles();
  }
  public static void main(String[] args)
  {
    new TurtleObjects();
  }
  private void showSomeTurtles()
  {
    //  Call the makeSpeedyTurtle method --#2
    //  Call the makeSlowTurtle method --#4
    //  Call the makeCrazyTurtle method --#6
  }
  //
  //    Create the makeSpeedyTurtle method --#1.0
  //        Create a new speedyTurtle instance  
  //        Set the speed of your speedyTurtle to the fastest possible    
  //        Add your speedyTurtle to your MultiTurtleWindow
  //        Have your speedyTurtle draw a triangle with 100 pixel sides
  //    End of makeSpeedyTurtle method --#1.1 
  //
  //    Create the makeSlowTurtle method --#3.0
  //        Create a new slowTurtle instance 
  //        Add your slowTurtle to your MultiTurtleWindow
  //        Have your slowTurtle draw a upside down triangle with 50 pixel sides
  //    End of makeSlowTurtle method --#3.1
  //
  //    Create the makeCrazyTurtle method --#5.0
  //        Create a new crazyTurtle instance  
  //        Add your crazyTurtle to your MultiTurtleWindow
  //        Have your crazyTurtle draw a 55 pixel long lightning bolt
  //    End of makeCrazyTurtle method --#5.1
}
