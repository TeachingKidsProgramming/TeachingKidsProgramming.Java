package org.teachingkidsprogramming.recipes;

import org.teachingextensions.logo.utils.Sounds;
import org.teachingextensions.windows.MessageBox;

import com.spun.util.NumberUtils;

public class HiLow
{
  public static void main(String[] args)
  {
    int correctNumber = NumberUtils.getRandomInt(1, 100);
    int tries = MessageBox.askForNumericalInput("How many tries do you want?");
    for (int i = 1; i <= tries; i++)
    {
      int guess = MessageBox.askForNumericalInput("Please guess a number between 1 and 100. You have "
          + (tries + 1 - i) + " tries.");
      if (guess == correctNumber)
      {
        Sounds.playBeep();
        MessageBox.showMessage("Your answer was " + correctNumber + "\n\nYOU WINzip :D\n\nYou took " + i
            + " tries.");
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
    }
    MessageBox.showMessage("Yu loozez! Sukkah!!! \n\nDa ansah was " + correctNumber);
  }
}
