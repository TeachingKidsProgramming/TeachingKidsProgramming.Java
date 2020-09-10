package org.teachingkidsprogramming.section03ifs;

import org.teachingkidsprogramming.recipes.quizzes.graders.HiLowQuizGrader;

public class HiLowQuiz extends org.teachingkidsprogramming.recipes.quizzes.graders.HiLowQuiz
{
  @Override
  public void question1()
  {
    //  If the Y position of the tortoise is 115
    //  Turn the tortoise to the right 63 degrees 
  }
  @Override
  public void question2()
  {
    //  If the X position of tortoise is less than Y position of tortoise
    //  Turn the tortoise 54 degrees to the left
    //  Otherwise turn the tortoise 22 degrees to the right
  }
  @Override
  public void question3()
  {
    //  Display the message "elcomeway omehay!"
  }
  @Override
  public void question4()
  {
    //  If the Y position of tortoise is greater than 50
    //  Turn the tortoise 177 degrees to the left
  }
  public static void main(String[] args)
  {
    new HiLowQuizGrader().grade(new HiLowQuiz());
  }
}
