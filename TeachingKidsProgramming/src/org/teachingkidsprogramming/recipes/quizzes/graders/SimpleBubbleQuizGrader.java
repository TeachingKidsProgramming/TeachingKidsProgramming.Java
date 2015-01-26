package org.teachingkidsprogramming.recipes.quizzes.graders;

import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import org.teachingextensions.logo.Colors;
import org.teachingextensions.logo.Paintable;
import org.teachingextensions.logo.Tortoise;
import org.teachingkidsprogramming.recipes.quizzes.graders.AdLibsQuizAdapter.Pieces;

public class SimpleBubbleQuizGrader implements Paintable
{
  private static class Model
  {
    public String three;
    public Model(String three)
    {
      this.three = three;
    }
  }
  private boolean[]               answers      = new boolean[4];
  public static int               TURTLE_SPEED = 9;
  private SimpleBubbleQuizAdapter quiz;
  private void displayScreen()
  {
    QuizUtils.prepareScoringScreen(answers, this, TURTLE_SPEED);
    Tortoise.show();
    Tortoise.setX(150);
    Tortoise.setY(200);
    Tortoise.setPenColor(Colors.Greens.GreenYellow);
    quiz.drawDiamond(100);
    quiz.question1();
    quiz.question3();
    /*for (int i = 1; i <= 4; i++)
    {
      drawNextBase();
    }*/
  }
  public void grade(SimpleBubbleQuizAdapter quiz)
  {
    this.quiz = quiz;
    displayScreen();
  }
  public void paint(Graphics2D g, JPanel caller)
  {
    QuizUtils.displayScores(g, 300, answers);
    drawRewardShape(g);
  }
  public void drawRewardShape(Graphics2D g)
  {
    drawWin(g);
    drawGame(g);
  }
  private void drawGame(Graphics2D g)
  {
    Pieces pieces = new Pieces();
    quiz.question4(pieces);
    pieces.middle = "am";
  }
  private void drawWin(Graphics2D g)
  {
    quiz.question2("n");
  }
  private void drawWord(Graphics2D g, String word, int x, int y, boolean horizontal)
  {
    char[] letters = word.toUpperCase().toCharArray();
    int dx = horizontal ? 1 : 0;
    int dy = horizontal ? 0 : 1;
    for (int i = 0; i < letters.length; i++)
    {
      char c = letters[i];
      drawLetter(getPosition(x + dx * i), getPosition(y + dy * i), c, g);
    }
  }
  private int getPosition(int i)
  {
    return 100 + i * 53;
  }
  private void drawLetter(int x, int y, char c, Graphics2D g)
  {
    g.setColor(Colors.Browns.BurlyWood);
    g.drawRect(x, y, 50, 50);
    g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 36));
    int charWidth = g.getFontMetrics().charWidth(c);
    int charHeight = g.getFontMetrics().getAscent();
    int textY = y + (40 - charHeight) / 2 + charHeight;
    int textX = x + (50 - charWidth) / 2;
    g.drawString("" + c, textX, textY);
  }
}
