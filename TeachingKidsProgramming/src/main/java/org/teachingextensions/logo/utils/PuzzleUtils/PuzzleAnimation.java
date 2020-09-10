package org.teachingextensions.logo.utils.PuzzleUtils;

import javax.swing.SwingUtilities;

/**
 * Animates a puzzle from its initial state to its solution.
 */
public class PuzzleAnimation implements Runnable
{
  private final PuzzleBoard board;
  public PuzzleAnimation(PuzzleBoard board)
  {
    this.board = board;
  }
  private static void update(PuzzleBoard board)
  {
    boolean done = animate(board);
    if (!done) { return; }
    moveNextTile(board);
  }
  private static void moveNextTile(PuzzleBoard board)
  {
    if (board.hasMoves())
    {
      TileMove move = board.getNextMove();
      board.swap(move.getStart(), move.getEnd());
    }
  }
  private static boolean animate(PuzzleBoard board)
  {
    Tile[] tiles = board.getTiles();
    for (Tile tile : tiles)
    {
      if (tile != null && !tile.isAtTarget())
      {
        tile.step();
        return false;
      }
    }
    return true;
  }
  @Override
  public void run()
  {
    while (board.isVisible())
    {
      SwingUtilities.invokeLater(new Runnable()
      {
        @Override
        public void run()
        {
          board.repaint();
        }
      });
      update(board);
      try
      {
        Thread.sleep(10);
      }
      catch (InterruptedException ignored)
      {
      }
    }
  }
}
