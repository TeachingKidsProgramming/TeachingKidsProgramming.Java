package org.teachingkidsprogramming.recipes.quizzes.graders;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.Turtle;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;
import org.teachingextensions.logo.utils.LineAndShapeUtils.Paintable;
import org.teachingextensions.logo.utils.TortoiseUtils;

import java.awt.*;

public class QuizUtils
{
  public static void displayScores(Graphics2D g, int x, boolean[] answers)
  {
    g.setColor(PenColors.Blues.CornflowerBlue);
    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    g.setFont(new Font("Tahoma", Font.BOLD, 14));
    int y = 80;
    int correct = 0;
    for (boolean b : answers)
    {
      if (b)
      {
        correct++;
      }
    }
    g.drawString(String.format("You Scored %s out of %s", correct, answers.length), x, y);
    for (int i = 0; i < answers.length; i++)
    {
      boolean b = answers[i];
      y += 25;
      g.setColor(PenColors.Blues.LightBlue);
      g.drawString(String.format("Question %s - ", i + 1), x, y);
      if (b)
      {
        g.setColor(PenColors.Greens.ForestGreen);
        g.drawString("Pass", x + 90, y);
      }
      else
      {
        g.setColor(PenColors.Reds.Red);
        g.drawString("Fail", x + 90, y);
      }
    }
  }
  public static void prepareScoringScreen(boolean[] answers, Paintable paintable, int turtleSpeed)
  {
    TortoiseUtils.resetTurtle();
    Tortoise.setSpeed(turtleSpeed);
    Tortoise.getBackgroundWindow().setColor(Color.black);
    Tortoise.getBackgroundWindow().getCanvas().add(paintable);
    Tortoise.show();
  }
  public static Turtle createTestTurtle()
  {
    Turtle turtle = new Turtle();
    turtle.setSpeed(Turtle.TEST_SPEED);
    return turtle;
  }
}
