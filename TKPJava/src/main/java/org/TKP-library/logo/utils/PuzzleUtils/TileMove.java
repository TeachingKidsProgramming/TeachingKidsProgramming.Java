package logo.utils.PuzzleUtils;

/**
 * Describes a tile swap.
 */
public class TileMove
{
  private final int start;
  private final int end;
  public TileMove(int start, int end)
  {
    this.start = start;
    this.end = end;
  }
  @Override
  public String toString()
  {
    return "TileMove{" + "start=" + start + ", end=" + end + '}';
  }
  public int getStart()
  {
    return start;
  }
  public int getEnd()
  {
    return end;
  }
}
