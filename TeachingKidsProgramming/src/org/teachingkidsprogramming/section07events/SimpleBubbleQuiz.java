package org.teachingkidsprogramming.section07events;

import org.teachingextensions.logo.PenColors;
import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.shapes.Text;
import org.teachingextensions.windows.MouseLeftClickListener;
import org.teachingextensions.windows.MouseRightClickListener;
import org.teachingkidsprogramming.recipes.quizzes.graders.SimpleBubbleQuizAdapter;
import org.teachingkidsprogramming.recipes.quizzes.graders.SimpleBubbleQuizGrader;

public class SimpleBubbleQuiz extends SimpleBubbleQuizAdapter
    implements
      MouseLeftClickListener,
      MouseRightClickListener
{
  public void question1()
  {
    //code: In the Tortoise background window, have this quiz listen for when the left mouse button is clicked  
    //action: YOU must left click on the first base to pass this question
  }
  public void question2()
  {
    //code: Write "Single!" on the screen in yellow at position 155,135
  }
  public void question3()
  {
    //code: In the Tortoise background window, have this quiz listen for when the right mouse button is clicked  
    //action: YOU must right click on the home plate (4th base)  to pass this question
  }
  public void question4()
  {
    //code: Write "Home Run!" on the screen in lime green at position 105,235
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
      if (counter == 0)
      {
        this.answerQuestion1();
        question2();
        Text baseHit = new Text("Keep Running!");
        baseHit.setPenColor(PenColors.Oranges.Orange);
        baseHit.setTopLeft(105, 35).addTo(Tortoise.getBackgroundWindow());
      }
      drawNextBase();
      counter = counter + 1;
    }
  }
  @Override
  public void onRightMouseClick(int x, int y)
  {
    if (counter != 3) { return; }
    this.answerQuestion3();
    question4();
    drawNextBase();
  }
}
