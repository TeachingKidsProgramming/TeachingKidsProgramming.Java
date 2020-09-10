package org.teachingkidsprogramming.recipes.quizzes.graders;

import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;
import org.teachingextensions.logo.utils.LineAndShapeUtils.Paintable;
import org.teachingextensions.logo.utils.MVCUtils.Parser;
import org.teachingkidsprogramming.recipes.quizzes.graders.AdLibsQuizAdapter.Pieces;

public class AdLibsQuizGrader implements Paintable
{
  private static class Model
  {
    @SuppressWarnings("unused")
    public String three;
    public Model(String three)
    {
      this.three = three;
    }
  }
  private boolean[]         answers;
  public static int         TURTLE_SPEED = 9;
  private AdLibsQuizAdapter quiz;
  private void displayScreen()
  {
    QuizUtils.prepareScoringScreen(answers, this, TURTLE_SPEED);
  }
  public void grade(AdLibsQuizAdapter quiz)
  {
    this.quiz = quiz;
    answers = new boolean[]{grade1You(), grade2Won(), grade3The(), grade4Game()};
    displayScreen();
  }
  @Override
  public void paint(Graphics2D g, JPanel caller)
  {
    QuizUtils.displayScores(g, 300, answers);
    Tortoise.hide();
    drawRewardShape(g);
  }
  public void drawRewardShape(Graphics2D g)
  {
    drawYou(g);
    drawWin(g);
    drawThe(g);
    drawGame(g);
  }
  private void drawGame(Graphics2D g)
  {
    quiz.template4 = "";
    Pieces pieces = new Pieces();
    quiz.question4(pieces);
    pieces.middle = "am";
    String word = Parser.parse(quiz.template4, pieces);
    drawWord(g, word, 0, 4, true);
  }
  private void drawThe(Graphics2D g)
  {
    quiz.word3 = "";
    Pieces model = new Pieces();
    model.middle = "H";
    quiz.question3("T{middle}E", model);
    drawWord(g, quiz.word3, 3, 2, false);
  }
  private void drawWin(Graphics2D g)
  {
    quiz.word2 = "WO";
    quiz.question2("n");
    drawWord(g, quiz.word2, 1, 0, false);
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
  private void drawYou(Graphics2D g)
  {
    quiz.word1 = "NOT";
    quiz.question1("y", "u");
    drawWord(g, quiz.word1, 0, 1, true);
  }
  private void drawLetter(int x, int y, char c, Graphics2D g)
  {
    g.setColor(PenColors.Browns.BurlyWood);
    g.drawRect(x, y, 50, 50);
    g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 36));
    int charWidth = g.getFontMetrics().charWidth(c);
    int charHeight = g.getFontMetrics().getAscent();
    int textY = y + (40 - charHeight) / 2 + charHeight;
    int textX = x + (50 - charWidth) / 2;
    g.drawString("" + c, textX, textY);
  }
  private boolean grade1You()
  {
    quiz.word1 = "fake";
    quiz.question1("f", "o");
    return "foo".equals(quiz.word1);
  }
  private boolean grade2Won()
  {
    quiz.word2 = "passe";
    quiz.question2("d");
    return "passed".equals(quiz.word2);
  }
  private boolean grade3The()
  {
    quiz.word3 = "fake";
    quiz.question3("12{three}4", new Model("3"));
    return "1234".equals(quiz.word3);
  }
  private boolean grade4Game()
  {
    quiz.template4 = "fake";
    quiz.question4(new Pieces());
    return "g{middle}e".equals(quiz.template4);
  }
}
