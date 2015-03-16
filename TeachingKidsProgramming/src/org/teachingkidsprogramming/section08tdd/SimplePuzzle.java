package org.teachingkidsprogramming.section08tdd;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SimplePuzzle implements Runnable
{
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new SimplePuzzle());
  }
  public void run()
  {
    this.setLookAndFeel();
    PuzzleBoard board = new PuzzleBoard();
    PuzzleWindow pw = new PuzzleWindow();
    pw.add(board);
    pw.setVisible(true);
    new Thread(new PuzzleSolver(board)).start();
  }
  private void setLookAndFeel()
  {
    try
    {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch (ClassNotFoundException ex)
    {
    }
    catch (InstantiationException ex)
    {
    }
    catch (IllegalAccessException ex)
    {
    }
    catch (UnsupportedLookAndFeelException ex)
    {
    }
  }
}
