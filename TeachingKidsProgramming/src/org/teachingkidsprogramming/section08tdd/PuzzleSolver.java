package org.teachingkidsprogramming.section08tdd;

import java.awt.Point;

import javax.swing.SwingUtilities;

public class PuzzleSolver implements Runnable
{
  private PuzzleBoard board;
  public PuzzleSolver(PuzzleBoard board)
  {
    this.board = board;
  }
  public void run()
  {
    final PuzzleBoard b = this.board;
    Point target = b.getPositions().get(8);
    while (b.isVisible())
    {
      SwingUtilities.invokeLater(new Runnable()
      {
        public void run()
        {
          b.repaint();
        }
      });
      Tile piece = b.getPiece(7);
      if (!piece.isMovingTo(target))
      {
        piece.moveTo(target);
      }
      if (!piece.isAt(target))
      {
        piece.step();
      }
      try
      {
        Thread.sleep(10);
      }
      catch (InterruptedException e)
      {
      }
    }
  }
}
