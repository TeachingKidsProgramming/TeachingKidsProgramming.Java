package src.main.java.org.teachingextentions.logo.utils.PuzzleUtils;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

import javax.swing.JPanel;

import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.StringUtils;
import src.main.java.org.teachingextentions.logo.utils.ColorUtils.PenColors;
import src.main.java.org.teachingextentions.logo.utils.InterfaceUtils.TkpPanel;

/**
 * Draws and animates a 9-puzzle
 */
public class PuzzleBoard extends JPanel
{
  private static final long     serialVersionUID = -2008156268412728375L;
  private final static int      blank            = 8;
  private final Tile[]          tiles;
  private final Queue<TileMove> solution;
  public PuzzleBoard(final Puzzle puzzle, final PuzzleState solution)
  {
    super();
    this.solution = createSolution(solution, puzzle);
    this.tiles = createTiles(puzzle.getCells());
  }
  public static Queue<TileMove> createSolution(final PuzzleState solution, final Puzzle puzzle)
  {
    if (solution == null) { return new ArrayDeque<>(); }
    int i = puzzle.getBlankIndex();
    final Queue<TileMove> moves = new ArrayDeque<>();
    for (final PuzzleState.Direction d : solution.getHistory())
    {
      final int m = d.getValue();
      final TileMove move = new TileMove(i + m, i);
      moves.add(move);
      i = move.getStart();
    }
    return moves;
  }
  private static Tile[] createTiles(final int[] cells)
  {
    final Tile[] t = new Tile[9];
    for (int i = 0; i < 9; i++)
    {
      if (cells[i] == blank)
      {
        continue;
      }
      t[i] = new Tile(i, cells[i]);
    }
    return t;
  }
  private static void drawBorder(final Graphics2D g)
  {
    g.setColor(PenColors.Blues.DarkBlue);
    g.fillRect(20, 20, 410, 410);
  }
  private static void drawField(final Graphics2D g)
  {
    g.setColor(PenColors.Blues.SkyBlue);
    g.fillRect(30, 30, 386, 386);
  }
  private static void drawTiles(final Graphics2D g, final Tile[] tiles)
  {
    for (final Tile tile : tiles)
    {
      if (tile == null)
      {
        continue;
      }
      tile.paint(g);
    }
  }
  @Override
  protected void paintComponent(final Graphics g)
  {
    super.paintComponent(g);
    final Graphics2D g2d = TkpPanel.configureGraphics2D(g);
    drawBorder(g2d);
    drawField(g2d);
    drawTiles(g2d, tiles);
    g2d.dispose();
  }
  public Tile[] getTiles()
  {
    return Arrays.copyOf(tiles, tiles.length);
  }
  public boolean hasMoves()
  {
    return !solution.isEmpty();
  }
  public TileMove getNextMove()
  {
    return solution.isEmpty() ? null : solution.remove();
  }
  @Override
  public String toString()
  {
    final StringBuilder sb = new StringBuilder();
    sb.append("PuzzleBoard" + StringUtils.NEW_LINE);
    for (int i = 0; i < tiles.length; i += 3)
    {
      sb.append(tiles[i] + ", " + tiles[i + 1] + ", " + tiles[i + 2] + StringUtils.NEW_LINE);
    }
    return sb.toString();
  }
  public void swap(final int start, final int end)
  {
    final Point p = Tile.getPosition(end);
    final Tile tile = tiles[start];
    tile.moveTo(p);
    tiles[start] = null;
    tiles[end] = tile;
  }
}
