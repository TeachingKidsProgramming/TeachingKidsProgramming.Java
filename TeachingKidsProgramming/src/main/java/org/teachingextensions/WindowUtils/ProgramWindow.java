package org.teachingextensions.WindowUtils;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.teachingextensions.approvals.lite.util.FrameCloser;
import org.teachingextensions.approvals.lite.util.WindowUtils;
import org.teachingextensions.approvals.lite.writers.ComponentApprovalWriter;
import org.teachingextensions.logo.utils.ColorUtils.PenColors;
import org.teachingextensions.logo.utils.EventUtils.LeftClickMouseAdapter;
import org.teachingextensions.logo.utils.EventUtils.MouseLeftClickListener;
import org.teachingextensions.logo.utils.EventUtils.MouseRightClickListener;
import org.teachingextensions.logo.utils.EventUtils.RightClickMouseAdapter;
import org.teachingextensions.logo.utils.InterfaceUtils.CanvasPanel;
import org.teachingextensions.logo.utils.InterfaceUtils.TurtleFrame;
import org.teachingextensions.logo.utils.LineAndShapeUtils.ImageBackground;
import org.teachingextensions.logo.utils.LineAndShapeUtils.Paintable;
import org.teachingextensions.virtualproctor.VirtualProctorWeb;

/**
 * <img src="http://ftpmirror.your.org/pub/wikimedia/images/wikibooks/de/2/2c/JPanel_Add_JButton_PAGE_END.JPG" style="text-align: left" alt="A window image" height="50" width="75" > Program Window
 * allows you to change the color of the background and more...
 */
public class ProgramWindow
{
  private final LazyCanvas canvas = new LazyCanvas();
  private JFrame           frame;
  public ProgramWindow(String title)
  {
    this();
    this.frame = new JFrame(title);
    this.canvas.addTo(this.frame);
    ProgramWindow.createStandardFrame(getFrame());
  }
  public ProgramWindow()
  {
    this.canvas.setPreferredSize(new Dimension(627, 442));
    setColor(PenColors.Whites.White);
  }
  public static void createStandardFrame(JFrame frame)
  {
    WindowUtils.testFrame(frame, new VirtualProctorWeb(), new FrameCloser());
  }
  /**
   * Adds a button instance to a window
   * <p><b>Example:</b> {@code programWindow.addButton(myButton)}</p>
   *
   * @param button
   *     A button instance
   */
  public void addButton(JButton button)
  {
    this.canvas.add(button);
  }
  public void setColor(Color backgroundColor)
  {
    this.canvas.setBackground(backgroundColor);
  }
  public ProgramWindow clearWindow()
  {
    this.canvas.clear();
    return this;
  }
  /**
   * Adds a right mouse click listener instance to a window
   * <p><b>Example:</b> {@code programWindow.addMouseRightClickListener(myRightClickListener)}</p>
   *
   * @param listener
   *     A listener instance
   */
  public void addMouseRightClickListener(MouseRightClickListener listener)
  {
    this.canvas.addMouseListener(new RightClickMouseAdapter(listener));
  }
  /**
   * Adds a left mouse click listener instance to a window
   * <p><b>Example:</b> {@code programWindow.addMouseLeftClickListener(myLeftClickListener)}</p>
   *
   * @param listener
   *     A listener instance
   */
  public void addMouseLeftClickListener(MouseLeftClickListener listener)
  {
    this.canvas.addMouseListener(new LeftClickMouseAdapter(listener));
  }
  /**
   * Adds a background image to a window
   * <p><b>Example:</b> {@code programWindow.setBackgroundImage("http://www.coolpicture.com/sunshine.jpg")}</p>
   *
   * @param url
   *     A URL path to an image
   */
  public void setBackgroundImage(String url)
  {
    add(new ImageBackground(url));
  }
  public JFrame getFrame()
  {
    return frame;
  }
  public void setWindowVisible(boolean b)
  {
    this.frame.setVisible(b);
    this.canvas.getValue().setVisible(b);
  }
  @Deprecated
  public ProgramWindow add(Paintable painter)
  {
    this.canvas.getValue().add(painter);
    return this;
  }
  @Deprecated
  public ProgramWindow remove(Paintable painter)
  {
    this.canvas.getValue().remove(painter);
    return this;
  }
  public final BufferedImage getWindowImage()
  {
    return ComponentApprovalWriter.drawComponent(this.canvas.getValue());
  }
  public ProgramWindow addTo(TurtleFrame frame)
  {
    frame.addContent(this.canvas.getValue());
    return this;
  }
  public ProgramWindow repaint()
  {
    this.canvas.getValue().repaint();
    return this;
  }
  public ProgramWindow setVisible(boolean visible)
  {
    this.canvas.getValue().setVisible(visible);
    return this;
  }
  public ProgramWindow setCursor(int cursor)
  {
    this.setCursor(Cursor.getPredefinedCursor(cursor));
    return this;
  }
  public ProgramWindow setCursor(Cursor predefinedCursor)
  {
    this.canvas.getValue().setCursor(predefinedCursor);
    return this;
  }
  public ProgramWindow setBackground(Color color)
  {
    this.canvas.setBackground(color);
    return this;
  }
  public CanvasPanel getCanvas()
  {
    return this.canvas.getValue();
  }
  private class LazyCanvas
  {
    private CanvasPanel panel;
    public LazyCanvas addTo(JFrame frame)
    {
      frame.getContentPane().add(this.getValue());
      return this;
    }
    public CanvasPanel getValue()
    {
      if (this.panel == null)
      {
        this.panel = new CanvasPanel();
      }
      return panel;
    }
    public LazyCanvas setPreferredSize(Dimension dimension)
    {
      this.getValue().setPreferredSize(dimension);
      return this;
    }
    public LazyCanvas add(JButton button)
    {
      this.getValue().add(button);
      return this;
    }
    public LazyCanvas setBackground(Color color)
    {
      this.getValue().setBackground(color);
      return this;
    }
    public LazyCanvas clear()
    {
      this.getValue().clear();
      return this;
    }
    public LazyCanvas addMouseListener(MouseListener adapter)
    {
      this.getValue().addMouseListener(adapter);
      return this;
    }
    @SuppressWarnings("unused")
    public LazyCanvas setImageBackground(ImageBackground imageBackground)
    {
      this.getValue().setBackground(imageBackground);
      return this;
    }
  }
}
