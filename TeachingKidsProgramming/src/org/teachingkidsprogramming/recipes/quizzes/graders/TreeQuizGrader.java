package org.teachingkidsprogramming.recipes.quizzes.graders;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

import org.teachingextensions.logo.Colors;
import org.teachingextensions.logo.Paintable;
import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.utils.TortoiseUtils;

public class TreeQuizGrader implements Paintable
{
  private boolean[]       answers;
  public static int       TURTLE_SPEED = 9;
  private TreeQuizAdapter quiz;
  private int             xTop         = 25;
  private int             yTop         = 25;
  private void displayScreen()
  {
    QuizUtils.prepareScoringScreen(answers, this, TURTLE_SPEED);
    drawRewardShape();
  }
  public void grade(TreeQuizAdapter quiz)
  {
    this.quiz = quiz;
    answers = new boolean[]{grade1DoubleLength(), grade2DecreaseTurn(), grade3SetNinety(), grade4AngleFive()};
    displayScreen();
  }
  public void paint(Graphics2D g, JPanel caller)
  {
    QuizUtils.displayScores(g, 380, answers);
    drawMaze(g);
  }
  private boolean grade1DoubleLength()
  {
    quiz.length = 111;
    quiz.question1();
    return quiz.length == 222;
  }
  private boolean grade2DecreaseTurn()
  {
    quiz.turn = -31;
    quiz.question2();
    return -32 == quiz.turn;
  }
  private boolean grade3SetNinety()
  {
    quiz.turn = -5;
    quiz.question3();
    return 90 == getAngle(-5);
  }
  public Integer getAngle(int key)
  {
    Integer v = quiz.angles.get(key);
    return v == null ? 0 : v;
  }
  private boolean grade4AngleFive()
  {
    quiz.question4();
    return 36 == getAngle(5);
  }
  public void drawRewardShape()
  {
    TortoiseUtils.setOrientation(xTop - 15, yTop + 15, 90);
    quiz.length = 15;
    quiz.question1();
    Tortoise.setPenColor(Colors.Greens.Lime);
    Tortoise.setPenWidth(2);
    int[] turns = {
        0, 90, 0, -90, 90 - 36, -90, 0, 90, -90, 0, 0, 0, -90, -90, 0, 0, 90, 0, 0, 90, 0, 0, 0, 0, 90, 90, -90,
        0, -90, 90, -90};
    for (int i = 0; i < turns.length; i++)
    {
      if (i == 4)
      {
        quiz.question4();
        quiz.angles.put(i + 1, getAngle(i + 1) + turns[i]);
      }
      else if (turns[i] != 90)
      {
        quiz.angles.put(i + 1, turns[i]);
      }
      else
      {
        quiz.turn = i + 1;
        quiz.question3();
      }
    }
    quiz.turn = 0;
    for (int i = 0; i < turns.length; i++)
    {
      quiz.question2();
      int turn = Math.abs(quiz.turn);
      int degreesToTheRight = getAngle(turn);
      Tortoise.turn(degreesToTheRight);
      Tortoise.move(quiz.length);
    }
  }
  private void drawMaze(Graphics2D g)
  {
    g.setColor(Colors.Grays.DarkGray);
    g.setStroke(new BasicStroke(4, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
    int[][] verticalLines = {
        {1, 4}, {0, 2, 3, 1}, {2, 1}, {0, 1}, {1, 3}, {1, 2}, {2, 1}, new int[0], {1, 1, 3, 2}, {2, 1}, {0, 4}};
    int[][] horizontalLines = {
        {0, 10}, {2, 1, 5, 4}, {1, 1, 3, 1, 7, 1}, {0, 1, 2, 2, 5, 3, 9, 1}, {1, 2, 4, 3, 8, 1}, {0, 10}};
    drawLines(horizontalLines, g, true);
    drawLines(verticalLines, g, false);
  }
  private void drawLines(int[][] lines, Graphics2D g, boolean addToX)
  {
    for (int line = 0; line < lines.length; line++)
    {
      for (int i = 0; i < lines[line].length; i += 2)
      {
        int grid = 30;
        int p1 = xTop + lines[line][i] * grid;
        int p2 = yTop + line * grid;
        int x1 = addToX ? p1 : p2;
        int y1 = addToX ? p2 : p1;
        int length = lines[line][i + 1] * grid;
        int x2 = addToX ? x1 + length : x1;
        int y2 = addToX ? y1 : y1 + length;
        g.draw(new Line2D.Double(x1, y1, x2, y2));
      }
    }
  }
}