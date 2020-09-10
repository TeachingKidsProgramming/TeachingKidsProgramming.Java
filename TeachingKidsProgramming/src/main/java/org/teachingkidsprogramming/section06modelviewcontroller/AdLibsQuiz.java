package org.teachingkidsprogramming.section06modelviewcontroller;

import org.teachingkidsprogramming.recipes.quizzes.graders.AdLibsQuizAdapter;
import org.teachingkidsprogramming.recipes.quizzes.graders.AdLibsQuizGrader;

public class AdLibsQuiz extends AdLibsQuizAdapter
{
  @Override
  public void question1(String letter1, String letter3)
  {
    //  Set current value of word1 to be letter1 + 'o' + letter3
  }
  @Override
  public void question2(String letter1)
  {
    //  Add the letter1 to the end of word2 
  }
  @Override
  public void question3(String templateText, Object model)
  {
    //  Use the parser to combine the template and the model as word3
  }
  @Override
  public void question4(Pieces pieces)
  {
    //  Set template4 to the template which does'g' + pieces.middle + 'e'
  }
  public static void main(String[] args)
  {
    new AdLibsQuizGrader().grade(new AdLibsQuiz());
  }
}
