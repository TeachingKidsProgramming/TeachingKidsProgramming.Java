package org.teachingkidsprogramming.recipes;

import org.teachingextensions.logo.utils.Sounds;
import org.teachingextensions.windows.MessageBox;

import com.spun.util.NumberUtils;

public class HiLow
{
  public static void main(String[] args)
  {
    for (int i = 1; i <= 8; i++)
    {
      //    Choose a random number between 1 and 100 --#4.1 (fake!) & --#13
      //    Do the following 8 times --#9
      int guess = MessageBox.askForNumericalInput("Please guess a number. You have 8 tries.");
      int correctNumber = NumberUtils.getRandomInt(1, 100);
      if (guess == correctNumber)
      {
        Sounds.playBeep();
        MessageBox.showMessage("YOU WINzip :D");
        //     and exit --#10
        System.exit(0);
      }
      else if (guess > correctNumber)
      {
        MessageBox.showMessage("You is tooooooo mumbo-jumbo!!!");
      }
      else if (guess < correctNumber)
      {
        MessageBox.showMessage("You is toooooo teeny-weeny!!");
      }
      //    If after 8 times they haven't guessed correctly then --#12
      //     Tell them they've lost the game --#11
    }
    MessageBox.showMessage("Yu loozez! Sukkah!!!");
  }
}
