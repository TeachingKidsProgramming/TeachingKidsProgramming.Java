package org.teachingkidsprogramming.recipes;

import org.teachingextensions.logo.utils.Sounds;
import org.teachingextensions.windows.MessageBox;

public class HiLow
{
  public static void main(String[] args)
  {
    //    Choose a random number between 1 and 100 --#4.1 (fake!) & --#13
    //    Do the following 8 times --#9
    int guess = MessageBox.askForNumericalInput("Please guess a number. You have 8 tries.");
    int correctNumber = 20;
    if (guess == correctNumber)
    {
      Sounds.playBeep();
      MessageBox.showMessage("YOU WIN :D");
    }
    //     and exit --#10
    else if (guess > correctNumber)
    {
      MessageBox.showMessage("You is tooooooo mumbo-jumbo!!!");
    }
    //     Otherwise, if the guess is too low --#8
    //     Tell the end user that it is too low --#7
    else if (guess < correctNumber)
    {
      MessageBox.showMessage("You is toooooo teeny-weeny!!");
    }
    //    If after 8 times they haven't guessed correctly then --#12
    //     Tell them they've lost the game --#11
  }
}
