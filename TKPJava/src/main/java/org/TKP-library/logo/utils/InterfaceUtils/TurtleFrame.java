package logo.utils.InterfaceUtils;

import javax.swing.JComponent;
import javax.swing.JFrame;

import org.teachingextensions.approvals.lite.util.FrameCloser;
import org.teachingextensions.approvals.lite.util.WindowUtils;
import org.teachingextensions.virtualproctor.VirtualProctorWeb;

public class TurtleFrame
{
  public static final String TITLE = "TKPJava Turtle";
  private LazyFrame          frame;
  private String             title;
  public TurtleFrame(JFrame frame)
  {
    if (frame == null) { throw new IllegalArgumentException(
        "frame must not be null when creating a TurtleFrame"); }
    this.frame = new LazyFrame(frame);
  }
  public TurtleFrame(String title)
  {
    if (title == null)
    {
      title = TITLE;
    }
    this.frame = new LazyFrame(title);
  }
  public TurtleFrame()
  {
    this(TITLE);
  }
  public static void createStandardFrame(JFrame frame)
  {
    WindowUtils.testFrame(frame, new VirtualProctorWeb(), new FrameCloser());
  }
  public TurtleFrame addContent(JComponent panel)
  {
    this.frame.getValue().getContentPane().add(panel);
    return this;
  }
  public TurtleFrame setVisible(boolean visible)
  {
    this.frame.getValue().setVisible(visible);
    return this;
  }
  public TurtleFrame setStandardLayout()
  {
    createStandardFrame(this.frame.getValue());
    return this;
  }
  private class LazyFrame
  {
    private String title;
    private JFrame frame;
    public LazyFrame(String title)
    {
      if (title == null) { throw new IllegalArgumentException(
          "title must not be null when creating a LazyFrame"); }
      this.title = title;
    }
    public LazyFrame(JFrame frame)
    {
      this.frame = frame;
    }
    public JFrame getValue()
    {
      if (this.frame == null)
      {
        this.frame = new JFrame(this.title);
      }
      return this.frame;
    }
  }
}
