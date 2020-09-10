package logo.utils.PuzzleUtils;

import org.teachingextensions.WindowUtils.ProgramWindow;

import java.awt.*;

/**
 * A program window for a 9-puzzle
 */
public class PuzzleWindow extends ProgramWindow
{
  public PuzzleWindow()
  {
    super("Puzzle");
    this.getCanvas().setLayout(new BorderLayout());
  }
  public PuzzleWindow(PuzzleBoard board)
  {
    this();
    this.getCanvas().add(board);
  }
}
