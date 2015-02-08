package org.teachingkidsprogramming.recipes.quizzes.graders;

import java.awt.Graphics2D;

import javax.swing.JPanel;

import org.teachingextensions.logo.Paintable;
import org.teachingextensions.logo.PenColors;
import org.teachingextensions.logo.Tortoise;

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
  public void paint(Graphics2D g, JPanel caller)
  {
    this.answers[0] = quiz.leftClickWiredUp;
    QuizUtils.displayScores(g, 300, answers);
    drawRewardShape(g);
  }
  public void drawRewardShape(Graphics2D g)
  {
  }
}
