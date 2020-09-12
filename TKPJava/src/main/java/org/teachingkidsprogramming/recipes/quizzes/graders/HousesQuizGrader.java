package org.teachingkidsprogramming.recipes.quizzes.graders;

import java.awt.Graphics2D;

import javax.swing.JPanel;

import org.teachingextensions.approvals.lite.util.NumberUtils;
import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.Turtle;
import org.teachingextensions.logo.utils.TortoiseUtils;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;
import org.teachingextensions.logo.utils.LineAndShapeUtils.Paintable;

public class HousesQuizGrader implements Paintable
{
  private boolean[]         answers;
  public static int         TURTLE_SPEED = 9;
  private HousesQuizAdapter quiz;
  private void displayScreen()
  {
    QuizUtils.prepareScoringScreen(answers, this, TURTLE_SPEED);
    drawRewardShape();
  }
  public void grade(HousesQuizAdapter quiz)
  {
    this.quiz = quiz;
    answers = new boolean[]{grade1Small(),
        grade2Medium(),
        grade3Large(),
        grade4moveTheLength(),
        grade5turnTheCorner(),
        grade6drawASide()};
    displayScreen();
  }
  @Override
  public void paint(Graphics2D g, JPanel caller)
  {
    QuizUtils.displayScores(g, 300, answers);
  }
  public void drawRewardShape()
  {
    TortoiseUtils.setOrientation(100, 75, 90);
    for (int i = 0; i < 6; i++)
    {
      drawTriangle();
    }
  }
  private boolean grade1Small()
  {
    quiz.question1();
    return 7 == quiz.length;
  }
  private boolean grade2Medium()
  {
    quiz.question2();
    return 21 == quiz.length;
  }
  private boolean grade3Large()
  {
    quiz.question3();
    return 63 == quiz.length;
  }
  private boolean grade4moveTheLength()
  {
    Turtle turtle = QuizUtils.createTestTurtle();
    TortoiseUtils.setTurtle(turtle);
    TortoiseUtils.setOrientation(0, 0, 90);
    quiz.length = -3;
    quiz.question4();
    return NumberUtils.equals(TortoiseUtils.getTurtle().getX(), -3, 0.005);
  }
  private boolean grade5turnTheCorner()
  {
    int angle = NumberUtils.getRandomInt(130, 300);
    Turtle turtle = QuizUtils.createTestTurtle();
    TortoiseUtils.setTurtle(turtle);
    turtle.setAngleInDegrees(angle);
    quiz.question5();
    return NumberUtils.equals(turtle.getAngleInDegrees(), angle + (-360.0 / 3), 0.005);
  }
  private boolean grade6drawASide()
  {
    int angle = 180;
    Turtle turtle = QuizUtils.createTestTurtle();
    TortoiseUtils.setTurtle(turtle);
    TortoiseUtils.setOrientation(0, 0, angle);
    quiz.length = -3;
    quiz.question6();
    boolean move = NumberUtils.equals(TortoiseUtils.getTurtle().getY(), -3, 0.005);
    boolean turn = NumberUtils.equals(turtle.getAngleInDegrees(), angle + (-360.0 / 3), 0.005);
    return move && turn;
  }
  private void drawTriangle()
  {
    Tortoise.setPenUp();
    quiz.question2();
    quiz.question3();
    Tortoise.move(quiz.length);
    Tortoise.setPenDown();
    quiz.question5();
    for (int i = 0; i < 2; i++)
    {
      Tortoise.setPenWidth(3);
      Tortoise.setPenColor(PenColors.Purples.Lavender);
      quiz.question3();
      quiz.question4();
      Tortoise.turn(180);
      quiz.question4();
      Tortoise.turn(180);
      drawSmallerLine();
      quiz.question5();
    }
    Tortoise.setPenUp();
    quiz.question3();
    quiz.question4();
    Tortoise.setPenDown();
    Tortoise.turn(180);
    quiz.question5();
  }
  private void drawSmallerLine()
  {
    moveMedium();
    Tortoise.turn(360.0 / 6);
    moveMedium();
    quiz.question5();
    moveMedium();
    quiz.question5();
    Tortoise.turn(180);
    moveMedium();
  }
  private void moveMedium()
  {
    quiz.question2();
    Tortoise.setPenWidth(2);
    Tortoise.setPenColor(PenColors.Blues.LightBlue);
    quiz.question4();
    Tortoise.turn(180);
    quiz.question4();
    Tortoise.turn(180);
    drawSmallestLine();
  }
  private void drawSmallestLine()
  {
    Tortoise.setPenWidth(1);
    Tortoise.setPenColor(PenColors.Blues.PowderBlue);
    quiz.question1();
    quiz.question4();
    Tortoise.turn(360.0 / 6);
    quiz.question6();
    quiz.question6();
    Tortoise.turn(180);
    quiz.question4();
  }
}
