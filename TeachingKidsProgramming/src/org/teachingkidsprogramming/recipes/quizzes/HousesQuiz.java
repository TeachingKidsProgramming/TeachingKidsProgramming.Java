package org.teachingkidsprogramming.recipes.quizzes;

import org.teachingextensions.logo.Tortoise;
import org.teachingkidsprogramming.recipes.quizzes.graders.HousesQuizGrader;

public class HousesQuiz extends org.teachingkidsprogramming.recipes.quizzes.graders.HousesQuiz
{
  public void question1()
  {
    length = 7;
  }
  @Override
  public void medium()
  {
    super.medium();
    length = 21;
  }
  @Override
  public void large()
  {
    super.large();
    length = 63;
  }
  @Override
  public void moveTheLength()
  {
    super.moveTheLength();
    Tortoise.move(length);
  }
  @Override
  public void turnTheCorner()
  {
    super.turnTheCorner();
    Tortoise.turn(-360 / 3);
  }
  //      Question6
  //      Create a method called drawASide
  //       that calls moveTheLength and turnTheCorner 
  @Override
  public void drawASide()
  {
    // TODO Auto-generated method stub
    super.drawASide();
    moveTheLength();
    turnTheCorner();
  }
  //
  public static void main(String[] args)
  {
    new HousesQuizGrader().grade(new HousesQuiz());
  }
}
