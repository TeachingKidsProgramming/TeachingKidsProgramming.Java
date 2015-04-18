package org.teachingkidsprogramming.section08tdd;

import java.awt.EventQueue;
import java.util.Arrays;
import java.util.Random;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.teachingextensions.logo.Puzzle;
import org.teachingextensions.logo.PuzzleAnimation;
import org.teachingextensions.logo.PuzzleBoard;
import org.teachingextensions.logo.PuzzleState;

public class SimplePuzzle implements Runnable
{
  public Puzzle      puzzle   = null;
  public PuzzleState solution = null;
  public int[]       cells    = {0, 1, 2, 3, 4, 5, 6, 7, 8};
  //
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new SimplePuzzle());
  }
  //
  public static int[] shuffled(int[] source)
  {
    int[] copy = Arrays.copyOf(source, source.length);
    Random rnd = new Random();
    for (int i = copy.length - 1; i > 0; i--)
    {
      int index = rnd.nextInt(i + 1);
      int a = copy[index];
      copy[index] = copy[i];
      copy[i] = a;
    }
    return copy;
  }
  //
  @Override
  public void run()
  {
    this.setLookAndFeel();
    //  Do this until the player finds the solution -- #6.1
    //      Create a Message Box that shows the message "Looking for puzzle solution..." -- #4
    //      Create an array of integers named 'shuffled' which shuffles the cell array -- #2.1
    //      Make the puzzle use the cells array, run it, then use the shuffled array -- #2.2 
    puzzle = new Puzzle(cells);
    //      Create a AStarPlayer named 'player' which uses the current puzzle -- #3.1
    //      Create a solution by telling the player to solve it -- #3.2 TIP: Not all puzzles can be solved! 
    //      NOTE for teacher - have kids run it multiple times here to see that sometimes it fails
    //
    //      End of try --#5.2
    //          Create a Message Box that shows the message "This puzzle is not solvable, click ok to try again" -- #5.4
    //      End of catch --#5.3
    //
    //  End of while --#6.2
    PuzzleBoard board = new PuzzleBoard(puzzle, solution);
    //  Create a new Puzzle Window that takes a parameter named board -- #1
    new Thread(new PuzzleAnimation(board)).start();
  }
  //
  private void setLookAndFeel()
  {
    try
    {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException
        | IllegalAccessException ignored)
    {
    }
  }
}
