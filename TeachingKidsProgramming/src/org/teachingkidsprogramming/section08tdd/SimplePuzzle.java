package org.teachingkidsprogramming.section08tdd;

import java.awt.EventQueue;
import java.util.Arrays;
import java.util.Random;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.teachingextensions.logo.AStarPlayer;
import org.teachingextensions.logo.Puzzle;
import org.teachingextensions.logo.PuzzleAnimation;
import org.teachingextensions.logo.PuzzleBoard;
import org.teachingextensions.logo.PuzzlePlayer;
import org.teachingextensions.logo.PuzzleState;
import org.teachingextensions.logo.PuzzleWindow;

public class SimplePuzzle implements Runnable
{
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new SimplePuzzle());
  }
  @SuppressWarnings("unused")
  private static int[] shuffled(int[] source)
  {
    int[] copy = Arrays.copyOf(source, source.length);
    Random rnd = new Random();
    for (int i = copy.length - 1; i > 0; i--)
    {
      int index = rnd.nextInt(i + 1);
      // Simple swap
      int a = copy[index];
      copy[index] = copy[i];
      copy[i] = a;
    }
    return copy;
  }
  @Override
  public void run()
  {
    this.setLookAndFeel();
    //    int[] cells = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    //    int[] shuffled = shuffled(cells);
    int[] shuffled = {5, 6, 2, 4, 1, 8, 7, 0, 3}; // known to be solvable
    Puzzle puzzle = new Puzzle(shuffled);
    PuzzlePlayer player = new AStarPlayer(puzzle);
    PuzzleState solution = player.solve();
    PuzzleBoard board = new PuzzleBoard(puzzle, solution);
    PuzzleWindow pw = new PuzzleWindow(board);
    pw.setVisible(true);
    new Thread(new PuzzleAnimation(board)).start();
  }
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
