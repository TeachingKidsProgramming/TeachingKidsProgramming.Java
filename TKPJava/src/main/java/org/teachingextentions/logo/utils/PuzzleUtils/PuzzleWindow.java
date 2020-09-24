package src.main.java.org.teachingextentions.logo.utils.PuzzleUtils;

import src.main.java.org.teachingextentions.logo.utils.TurtleWindowUtils.ProgramWindow;
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
