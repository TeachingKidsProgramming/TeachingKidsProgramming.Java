package org.teachingkidsprogramming.recipes.quizzes.graders;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;
import org.teachingextensions.logo.utils.LineAndShapeUtils.Paintable;
import org.teachingextensions.logo.utils.LineAndShapeUtils.Text;

import javax.swing.*;
import java.awt.*;

public class SimpleBubbleQuizGrader implements Paintable
{
  private boolean[]               answers      = new boolean[4];
  public static int               TURTLE_SPEED = 9;
  private SimpleBubbleQuizAdapter quiz;
  private void displayScreen()
  {
    QuizUtils.prepareScoringScreen(answers, this, TURTLE_SPEED);
    Tortoise.show();
    Tortoise.setX(150);
    Tortoise.setY(200);
    Tortoise.setPenColor(PenColors.Greens.GreenYellow);
    quiz.drawDiamond(100);
    quiz.question1();
    quiz.question3();
  }
  public void grade(SimpleBubbleQuizAdapter quiz)
  {
    this.quiz = quiz;
    displayScreen();
  }
  @Override
  public void paint(Graphics2D g, JPanel caller)
  {
    this.answers[0] = quiz.leftClickWiredUp;
    this.answers[2] = quiz.rightClickWiredUp;
    for (Paintable p : Tortoise.getBackgroundWindow().getCanvas().getPainters())
    {
      try
      {
        Text t = (Text) p;
        if (isAnswerToQuestion2(t))
        {
          this.answers[1] = true;
        }
        else if (isAnswerToQuestion4(t))
        {
          this.answers[3] = true;
        }
      }
      catch (Exception e)
      {
        //do nothing
      }
    }
    QuizUtils.displayScores(g, 300, answers);
    drawRewardShape(g);
  }
  private boolean isAnswerToQuestion2(Text t)
  {
    if (t.getContent() != "Single!") { return false; }
    if (t.getPenColor() != PenColors.Yellows.Yellow) { return false; }
    if (t.getX() != 155 || t.getY() != 135) { return false; }
    return true;
  }
  private boolean isAnswerToQuestion4(Text t)
  {
    if (t.getContent() != "Home Run!") { return false; }
    if (t.getPenColor() != PenColors.Greens.LimeGreen) { return false; }
    if (t.getX() != 105 || t.getY() != 235) { return false; }
    return true;
  }
  public void drawRewardShape(Graphics2D g)
  {
  }
}
