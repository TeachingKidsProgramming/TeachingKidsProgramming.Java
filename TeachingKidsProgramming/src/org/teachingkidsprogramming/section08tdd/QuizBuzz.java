package org.teachingkidsprogramming.section08tdd;

import org.teachingkidsprogramming.recipes.quizzes.graders.QuizBuzzAdapter;
import org.teachingkidsprogramming.recipes.quizzes.graders.QuizBuzzGrader;

public class QuizBuzz extends QuizBuzzAdapter
{
  //**THIS QUIZ IS IN PROGRESS
  public void question1(String letter1, String letter3)
  {
    //set current value of word1 to be letter1 + 'o' + letter3
  }
  public void question2(String letter1)
  {
    //add the letter1 to the end of word2 
  }
  public void question3(String templateText, Object model)
  {
    //use the parser to combine the template and the model as word3
  }
  public void question4(Pieces pieces)
  {
    //set template4 to the template which does'g' + pieces.middle + 'e'
  }
  public static void main(String[] args)
  {
    new QuizBuzzGrader().grade(new QuizBuzz());
  }
}
