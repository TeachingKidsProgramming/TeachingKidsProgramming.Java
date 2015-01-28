package org.teachingkidsprogramming.section07events;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.windows.MouseLeftClickListener;
import org.teachingextensions.windows.MouseRightClickListener;
import org.teachingkidsprogramming.recipes.quizzes.graders.SimpleBubbleQuizAdapter;
import org.teachingkidsprogramming.recipes.quizzes.graders.SimpleBubbleQuizGrader;

public class SimpleBubbleQuiz extends SimpleBubbleQuizAdapter
    implements
      MouseLeftClickListener,
      MouseRightClickListener
{
  //**THIS QUIZ IS IN PROGRESS
  public void question1()
  {
    //code: wire up left click to draw first base
    Tortoise.getBackgroundWindow().addMouseLeftClickListener(this);
    //action: tortoise move to corner and draw a base
  }
  public void question2(String letter1)
  {
    //code: add text 'You got a single' and then left click on the first base
    //action: fail first in all case, draw base and pass after click
  }
  public void question3()
  {
    //wire up right click to get a home run
    Tortoise.getBackgroundWindow().addMouseRightClickListener(this);
    //so that when you click the Tortoise will move to home plate and draw it
  }
  public void question4()
  {
    //code: add text 'You got a home run' and then right click on the home plate
    //action: fail first in all case, draw base and pass after click
  }
  public static void main(String[] args)
  {
    new SimpleBubbleQuizGrader().grade(new SimpleBubbleQuiz());
  }
  @Override
  public void onLeftMouseClick(int x, int y)
  {
    if (counter < 3)
    {
      drawNextBase();
      counter = counter + 1;
    }
  }
  @Override
  public void onRightMouseClick(int x, int y)
  {
    if (counter != 3) { return; }
    drawNextBase();
  }
}
