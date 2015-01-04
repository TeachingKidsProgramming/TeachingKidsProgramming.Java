package org.teachingkidsprogramming.section07events;

import org.teachingkidsprogramming.recipes.quizzes.graders.SimpleBubbleQuizAdapter;
import org.teachingkidsprogramming.recipes.quizzes.graders.SimpleBubbleQuizGrader;

public class SimpleBubbleQuiz extends SimpleBubbleQuizAdapter
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
    new SimpleBubbleQuizGrader().grade(new SimpleBubbleQuiz());
  }
  //this is the original quiz (from SmallBasic) - need to be translated to Java
  //Variables needed for Quiz
  //  action[1] = 15
  //  ball = 1
  //  BubbleQuiz.StartQuizAt = Question2
  //--------------------Begin Quiz --------------------
  //Question1 - Is At the bottom of this quiz. But do it 1st!
  //  Sub Question2
  // Set the 1st action to 5
  //  EndSub
  //  Sub Question3
  //Have the timer call Move every 100 milliseconds
  //  EndSub
  //  Sub Question4
  // Set the 2nd action to -6
  //  EndSub
  //  Sub Question5
  //Change the color for the next circle to be yellow
  //Make the current ball be a circle with a 11 pixel radius
  //  EndSub
  //Question1
  //Create a subroutine called Move
  // that calls Quiz.DoMovement()
}
