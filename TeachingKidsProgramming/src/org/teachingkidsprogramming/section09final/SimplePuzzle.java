package org.teachingkidsprogramming.section09final;

import java.awt.EventQueue;
import java.util.Arrays;
import java.util.Random;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.teachingextensions.logo.utils.PuzzleUtils.Puzzle;
import org.teachingextensions.logo.utils.PuzzleUtils.PuzzleAnimation;
import org.teachingextensions.logo.utils.PuzzleUtils.PuzzleBoard;
import org.teachingextensions.logo.utils.PuzzleUtils.PuzzleState;

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
    PuzzleState solution = null;
    //  Do this until the player finds a solution --#6.1
    //      Create a Message Box that shows the message "Looking for puzzle solution..." --#4
    //
    //      Try to solve the puzzle --#5.1
    //          Create an array of integers named 'shuffled' which shuffles the cell array --#2.1
    //          Run the new puzzle (uses the cells array), Then update it to use the shuffled array --#2.2 
    //
    puzzle = new Puzzle(cells);
    //            
    //          Create a new AStarPlayer named player (of type PuzzlePlayer) which uses the current puzzle -- #3.1
    //          NOTE for teacher - have kids run it multiple times here to see that sometimes it fails
    //          Create a solution (of type PuzzleState) by telling the player to solve it (TIP: Not all puzzles can be solved!) --#3.2  
    // 
    PuzzleBoard board = new PuzzleBoard(puzzle, solution);
    // 
    //           Create a new Puzzle Window that takes a parameter named board -- #1.1
    //            
    new Thread(new PuzzleAnimation(board)).start();
    //           Set the current puzzle window visibility to be true --#1.2             
    //            
    //      End of try --#5.2
    //          Create a Message Box that shows the message "This puzzle is not solvable, click ok to try again" --#5.4
    //      End of catch --#5.3
    //
    //  End of while --#6.2
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
