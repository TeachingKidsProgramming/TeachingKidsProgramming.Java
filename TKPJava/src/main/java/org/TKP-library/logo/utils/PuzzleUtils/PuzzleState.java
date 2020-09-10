package logo.utils.PuzzleUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/**
 * Represents a node in the puzzle-solving graph.  Keeps track of the current puzzle arrangement and the actions
 * required to arrive at the current arrangement from the starting arrangement.
 */
public class PuzzleState implements Comparator<PuzzleState>, Comparable<PuzzleState>
{
  private final Puzzle           puzzle;
  private final Stack<Direction> history;
  public PuzzleState(Puzzle puzzle)
  {
    this(puzzle, new Stack<Direction>());
  }
  public PuzzleState(Puzzle puzzle, Stack<Direction> history)
  {
    this.puzzle = puzzle;
    this.history = history;
  }
  public boolean isSolution()
  {
    return puzzle.isSolved();
  }
  public List<PuzzleState> getBranches()
  {
    List<PuzzleState> branches = new ArrayList<>(4);
    int blank = puzzle.getBlankIndex();
    int x = blank % 3;
    int y = blank / 3;
    for (Direction d : Direction.values())
    {
      if (d == Direction.Left && x == 0)
      {
        continue;
      }
      if (d == Direction.Right && x == 2)
      {
        continue;
      }
      if (d == Direction.Up && y == 0)
      {
        continue;
      }
      if (d == Direction.Down && y == 2)
      {
        continue;
      }
      Stack<Direction> h = new Stack<>();
      h.addAll(history);
      h.push(d);
      branches.add(new PuzzleState(puzzle.swapBlank(blank + d.getValue()), h));
    }
    return branches;
  }
  public Iterable<Direction> getHistory()
  {
    return this.history;
  }
  public Puzzle getPuzzle()
  {
    return this.puzzle;
  }
  public int getActualCost()
  {
    return this.history.size();
  }
  @Override
  public int compare(PuzzleState o1, PuzzleState o2)
  {
    return o1.getActualCost() - o2.getActualCost();
  }
  @Override
  public int compareTo(PuzzleState o)
  {
    return compare(this, o);
  }
  @Override
  public int hashCode()
  {
    return puzzle.hashCode();
  }
  @Override
  public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    PuzzleState that = (PuzzleState) o;
    return puzzle.equals(that.puzzle);
  }
  @Override
  public String toString()
  {
    StringBuilder b = new StringBuilder();
    if (!history.isEmpty())
    {
      b.append(history.peek());
      b.append(" to ");
    }
    b.append(puzzle);
    return b.toString();
  }
  public int getEstimatedCost()
  {
    return puzzle.getDistanceToGoal();
  }
  public enum Direction {
    Left(-1), Right(1), Up(-3), Down(3);
    private final int value;
    private Direction(int i)
    {
      this.value = i;
    }
    public int getValue()
    {
      return value;
    }
    @Override
    public String toString()
    {
      return "{" + super.toString() + " = " + value + '}';
    }
  }
}
