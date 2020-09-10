package logo.utils.PuzzleUtils;

import java.awt.Point;
import java.util.Arrays;

/**
 * A nine-puzzle
 *
 * @see <a href="http://en.wikipedia.org/wiki/15_puzzle">Wikipedia</a>
 */
public class Puzzle
{
  private static final int blank = 8;
  private final int[]      cells;
  public Puzzle(int[] cells)
  {
    this.cells = cells;
  }
  /**
   * Gives the position of the cell as it would appear on a 3x3 board.
   *
   * @param cell
   *     The cell to get the position for.
   * @return The position of the cell.
   */
  public static Point getPosition(int cell)
  {
    return new Point(cell % 3, cell / 3);
  }
  /**
   * Calculate the <a href="http://en.wikipedia.org/wiki/Taxicab_geometry">Manhattan Distance</a> between two positions.
   *
   * @param start
   *     The starting position.
   * @param end
   *     The ending position.
   * @return The distance between the two positions.
   */
  public static int getDistance(Point start, Point end)
  {
    return Math.abs(start.x - end.x) + Math.abs(start.y - end.y);
  }
  /**
   * Calculate the <a href="http://en.wikipedia.org/wiki/Taxicab_geometry">Manhattan Distance</a> between two cells by first converting them to positions.
   *
   * @param start
   *     The starting cell
   * @param end
   *     The ending cell
   * @return The distance between the cells.
   */
  public static int getDistance(int start, int end)
  {
    return getDistance(getPosition(start), getPosition(end));
  }
  @Override
  public int hashCode()
  {
    return Arrays.hashCode(cells);
  }
  @Override
  public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Puzzle puzzle = (Puzzle) o;
    return Arrays.equals(cells, puzzle.cells);
  }
  @Override
  public String toString()
  {
    return Arrays.toString(cells);
  }
  public boolean isSolved()
  {
    return getDistanceToGoal() == 0;
  }
  public int getBlankIndex()
  {
    for (int i = 0; i < cells.length; i++)
    {
      if (cells[i] == blank) { return i; }
    }
    return -1;
  }
  /**
   * Create a copy of the puzzle where the blank swapped with the value in the target position
   *
   * @param target
   *     move the blank to this location, and move the value from this location to the current blank location
   * @return A copy of the puzzle with the blank and target swapped.
   */
  public Puzzle swapBlank(int target)
  {
    int[] copy = Arrays.copyOf(cells, cells.length);
    int x = copy[target];
    copy[getBlankIndex()] = x;
    copy[target] = 8;
    return new Puzzle(copy);
  }
  /**
   * Calculate the distance between the goal by summing the distance between each cell and its goal.
   *
   * @return The distance to the goal.
   */
  public int getDistanceToGoal()
  {
    int distance = 0;
    for (int i = 0; i < cells.length; i++)
    {
      distance += getDistance(i, cells[i]);
    }
    return distance;
  }
  public int[] getCells()
  {
    return Arrays.copyOf(cells, cells.length);
  }
}
