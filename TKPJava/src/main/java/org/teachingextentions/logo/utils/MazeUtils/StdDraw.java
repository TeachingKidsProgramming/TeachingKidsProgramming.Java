package src.main.java.org.teachingextentions.logo.utils.MazeUtils;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.DirectColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.TreeSet;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public final class StdDraw implements ActionListener, KeyListener
{
  private static final int             DEFAULT_SIZE       = 350;
  private static int                   width              = DEFAULT_SIZE;
  private static int                   height             = DEFAULT_SIZE;
  private static final double          DEFAULT_PEN_RADIUS = 0.0175;
  private static double                currentPenRadius;
  private static boolean               defer              = false;
  private static final double          BORDER             = 0.00;
  private static final double          DEFAULT_XMIN       = 0.0;
  private static final double          DEFAULT_XMAX       = 1.0;
  private static final double          DEFAULT_YMIN       = 0.0;
  private static final double          DEFAULT_YMAX       = 1.0;
  private static double                xmin, ymin, xmax, ymax;
  private static final Font            DEFAULT_FONT       = new Font("SansSerif", Font.PLAIN, 16);
  private static Font                  font;
  private static BufferedImage         offscreenImage, onscreenImage;
  private static Graphics2D            offscreen, onscreen;
  private static StdDraw               stdDraw            = new StdDraw();
  public static JFrame                 frame;
  private static Object                keyLock            = new Object();
  private static LinkedList<Character> keysTyped          = new LinkedList<Character>();
  private static TreeSet<Integer>      keysDown           = new TreeSet<Integer>();
  private static long                  nextDrawInMS       = -1;
  private StdDraw()
  {
  }
  static
  {
    init();
  }
  public static void main(String[] args)
  {
    StdDraw.square(.2, .8, .1);
    StdDraw.filledSquare(.8, .8, .2);
    StdDraw.circle(.8, .2, .2);
    StdDraw.setPenColor(StdDrawColors.BOOK_RED);
    StdDraw.setPenRadius(.02);
    StdDraw.arc(.8, .2, .1, 200, 45);
    StdDraw.setPenRadius();
    StdDraw.setPenColor(StdDrawColors.BOOK_BLUE);
    double[] x = {.1, .2, .3, .2};
    double[] y = {.2, .3, .2, .1};
    StdDraw.filledPolygon(x, y);
    StdDraw.setPenColor(StdDrawColors.BLACK);
    StdDraw.text(0.2, 0.5, "black text");
    StdDraw.setPenColor(StdDrawColors.WHITE);
    StdDraw.text(0.8, 0.8, "white text");
  }
  public static void setCanvasSize()
  {
    setCanvasSize(DEFAULT_SIZE, DEFAULT_SIZE);
  }
  public static void setCanvasSize(int canvasWidth, int canvasHeight)
  {
    if (width <= 0 || height <= 0)
      throw new IllegalArgumentException("width and height must be positive");
    width = canvasWidth;
    height = canvasHeight;
    init();
  }
  private static void init()
  {
    if (frame != null)
      frame.setVisible(false);
    frame = new JFrame();
    offscreenImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    onscreenImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    offscreen = offscreenImage.createGraphics();
    onscreen = onscreenImage.createGraphics();
    setXscale();
    setYscale();
    offscreen.setColor(StdDrawColors.DEFAULT_CLEAR_COLOR);
    offscreen.fillRect(0, 0, width, height);
    setPenColor();
    setPenRadius();
    setFont();
    clearScreenToWhite();
    RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    offscreen.addRenderingHints(hints);
    ImageIcon icon = new ImageIcon(onscreenImage);
    JLabel draw = new JLabel(icon);
    frame.setContentPane(draw);
    frame.addKeyListener(stdDraw);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close all windows
    // frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);      // closes only current window
    frame.setTitle("Amazing Maze!");
    frame.setJMenuBar(createMenuBar());
    frame.pack();
    frame.requestFocusInWindow();
    frame.setVisible(true);
    // TODO: This is not working, so mouse events won't work yet...
    //draw.addMouseListener(stdDraw);
    //draw.addMouseMotionListener(stdDraw);
    MouseListener l = null;
    draw.addMouseListener(l);
    MouseMotionListener m = null;
    draw.addMouseMotionListener(m);
  }
  private static JMenuBar createMenuBar()
  {
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("File");
    menuBar.add(menu);
    JMenuItem menuItem1 = new JMenuItem(" Save...   ");
    menuItem1.addActionListener(stdDraw);
    menuItem1.setAccelerator(
        KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
    menu.add(menuItem1);
    return menuBar;
  }
  public static void setXscale()
  {
    setXscale(DEFAULT_XMIN, DEFAULT_XMAX);
  }
  public static void setYscale()
  {
    setYscale(DEFAULT_YMIN, DEFAULT_YMAX);
  }
  public static void setScale()
  {
    setXscale();
    setYscale();
  }
  public static void setXscale(double min, double max)
  {
    double size = max - min;
    if (size == 0.0)
      throw new IllegalArgumentException("the min and max are the same");
    synchronized (StdDrawMouseEvents.mouseLock)
    {
      xmin = min - BORDER * size;
      xmax = max + BORDER * size;
    }
  }
  public static void setYscale(double min, double max)
  {
    double size = max - min;
    if (size == 0.0)
      throw new IllegalArgumentException("the min and max are the same");
    synchronized (StdDrawMouseEvents.mouseLock)
    {
      ymin = min - BORDER * size;
      ymax = max + BORDER * size;
    }
  }
  public static void setScale(double min, double max)
  {
    double size = max - min;
    if (size == 0.0)
      throw new IllegalArgumentException("the min and max are the same");
    synchronized (StdDrawMouseEvents.mouseLock)
    {
      xmin = min - BORDER * size;
      xmax = max + BORDER * size;
      ymin = min - BORDER * size;
      ymax = max + BORDER * size;
    }
  }
  private static double scaleX(double x)
  {
    return width * (x - xmin) / (xmax - xmin);
  }
  private static double scaleY(double y)
  {
    return height * (ymax - y) / (ymax - ymin);
  }
  private static double factorX(double w)
  {
    return w * width / Math.abs(xmax - xmin);
  }
  private static double factorY(double h)
  {
    return h * height / Math.abs(ymax - ymin);
  }
  static double userX(double x)
  {
    return xmin + x * (xmax - xmin) / width;
  }
  static double userY(double y)
  {
    return ymax - y * (ymax - ymin) / height;
  }
  public static void clearScreenToWhite()
  {
    clearScreenToColor(StdDrawColors.DEFAULT_CLEAR_COLOR);
  }
  public static void clearScreenToColor(Color color)
  {
    offscreen.setColor(color);
    offscreen.fillRect(0, 0, width, height);
    offscreen.setColor(StdDrawColors.currentPenColor);
    draw();
  }
  public static double getPenRadius()
  {
    return currentPenRadius;
  }
  public static void setPenRadius()
  {
    setPenRadius(DEFAULT_PEN_RADIUS);
  }
  public static void setPenRadius(double radius)
  {
    if (!(radius >= 0))
      throw new IllegalArgumentException("pen radius must be nonnegative");
    currentPenRadius = radius;
    float scaledPenRadius = (float) (radius * DEFAULT_SIZE);
    BasicStroke stroke = new BasicStroke(scaledPenRadius, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
    offscreen.setStroke(stroke);
  }
  public static Color getPenColor()
  {
    return StdDrawColors.currentPenColor;
  }
  public static void setPenColor()
  {
    setPenColor(StdDrawColors.DEFAULT_PEN_COLOR);
  }
  public static void setPenColor(Color color)
  {
    if (color == null)
      throw new NullPointerException();
    StdDrawColors.currentPenColor = color;
    offscreen.setColor(StdDrawColors.currentPenColor);
  }
  public static void setPenColor(int red, int green, int blue)
  {
    if (red < 0 || red >= 256)
      throw new IllegalArgumentException("amount of red must be between 0 and 255");
    if (green < 0 || green >= 256)
      throw new IllegalArgumentException("amount of green must be between 0 and 255");
    if (blue < 0 || blue >= 256)
      throw new IllegalArgumentException("amount of blue must be between 0 and 255");
    setPenColor(new Color(red, green, blue));
  }
  public static Font getFont()
  {
    return font;
  }
  public static void setFont()
  {
    setFont(DEFAULT_FONT);
  }
  public static void setFont(Font font)
  {
    if (font == null)
      throw new NullPointerException();
    StdDraw.font = font;
  }
  /**
   * Draws a line segment between (<em>x</em><sub>0</sub>, <em>y</em><sub>0</sub>) and
   * (<em>x</em><sub>1</sub>, <em>y</em><sub>1</sub>).
   *
   * @param  x0 the <em>x</em>-coordinate of one endpoint
   * @param  y0 the <em>y</em>-coordinate of one endpoint
   * @param  x1 the <em>x</em>-coordinate of the other endpoint
   * @param  y1 the <em>y</em>-coordinate of the other endpoint
   */
  public static void line(double x0, double y0, double x1, double y1)
  {
    offscreen.draw(new Line2D.Double(scaleX(x0), scaleY(y0), scaleX(x1), scaleY(y1)));
    draw();
  }
  /**
   * Draws one pixel at (<em>x</em>, <em>y</em>).
   * This method is private because pixels depend on the display.
   * To achieve the same effect, set the pen radius to 0 and call {@code point()}.
   *
   * @param  x the <em>x</em>-coordinate of the pixel
   * @param  y the <em>y</em>-coordinate of the pixel
   */
  private static void pixel(double x, double y)
  {
    offscreen.fillRect((int) Math.round(scaleX(x)), (int) Math.round(scaleY(y)), 1, 1);
  }
  /**
   * Draws a point centered at (<em>x</em>, <em>y</em>).
   * The point is a filled circle whose radius is equal to the pen radius.
   * To draw a single-pixel point, first set the pen radius to 0.
   *
   * @param x the <em>x</em>-coordinate of the point
   * @param y the <em>y</em>-coordinate of the point
   */
  public static void point(double x, double y)
  {
    double xs = scaleX(x);
    double ys = scaleY(y);
    double r = currentPenRadius;
    float scaledPenRadius = (float) (r * DEFAULT_SIZE);
    if (scaledPenRadius <= 1)
      pixel(x, y);
    else
      offscreen.fill(new Ellipse2D.Double(xs - scaledPenRadius / 2, ys - scaledPenRadius / 2, scaledPenRadius,
          scaledPenRadius));
    draw();
  }
  /**
   * Draws a circle of the specified radius, centered at (<em>x</em>, <em>y</em>).
   *
   * @param  x the <em>x</em>-coordinate of the center of the circle
   * @param  y the <em>y</em>-coordinate of the center of the circle
   * @param  radius the radius of the circle
   * @throws IllegalArgumentException if {@code radius} is negative
   */
  public static void circle(double x, double y, double radius)
  {
    if (!(radius >= 0))
      throw new IllegalArgumentException("radius must be nonnegative");
    double xs = scaleX(x);
    double ys = scaleY(y);
    double ws = factorX(2 * radius);
    double hs = factorY(2 * radius);
    if (ws <= 1 && hs <= 1)
      pixel(x, y);
    else
      offscreen.draw(new Ellipse2D.Double(xs - ws / 2, ys - hs / 2, ws, hs));
    draw();
  }
  /**
   * Draws a filled circle of the specified radius, centered at (<em>x</em>, <em>y</em>).
   *
   * @param  x the <em>x</em>-coordinate of the center of the circle
   * @param  y the <em>y</em>-coordinate of the center of the circle
   * @param  radius the radius of the circle
   * @throws IllegalArgumentException if {@code radius} is negative
   */
  public static void filledCircle(double x, double y, double radius)
  {
    if (!(radius >= 0))
      throw new IllegalArgumentException("radius must be nonnegative");
    double xs = scaleX(x);
    double ys = scaleY(y);
    double ws = factorX(2 * radius);
    double hs = factorY(2 * radius);
    if (ws <= 1 && hs <= 1)
      pixel(x, y);
    else
      offscreen.fill(new Ellipse2D.Double(xs - ws / 2, ys - hs / 2, ws, hs));
    draw();
  }
  /**
   * Draws an ellipse with the specified semimajor and semiminor axes,
   * centered at (<em>x</em>, <em>y</em>).
   *
   * @param  x the <em>x</em>-coordinate of the center of the ellipse
   * @param  y the <em>y</em>-coordinate of the center of the ellipse
   * @param  semiMajorAxis is the semimajor axis of the ellipse
   * @param  semiMinorAxis is the semiminor axis of the ellipse
   * @throws IllegalArgumentException if either {@code semiMajorAxis}
   *         or {@code semiMinorAxis} is negative
   */
  public static void ellipse(double x, double y, double semiMajorAxis, double semiMinorAxis)
  {
    if (!(semiMajorAxis >= 0))
      throw new IllegalArgumentException("ellipse semimajor axis must be nonnegative");
    if (!(semiMinorAxis >= 0))
      throw new IllegalArgumentException("ellipse semiminor axis must be nonnegative");
    double xs = scaleX(x);
    double ys = scaleY(y);
    double ws = factorX(2 * semiMajorAxis);
    double hs = factorY(2 * semiMinorAxis);
    if (ws <= 1 && hs <= 1)
      pixel(x, y);
    else
      offscreen.draw(new Ellipse2D.Double(xs - ws / 2, ys - hs / 2, ws, hs));
    draw();
  }
  /**
   * Draws an ellipse with the specified semimajor and semiminor axes,
   * centered at (<em>x</em>, <em>y</em>).
   *
   * @param  x the <em>x</em>-coordinate of the center of the ellipse
   * @param  y the <em>y</em>-coordinate of the center of the ellipse
   * @param  semiMajorAxis is the semimajor axis of the ellipse
   * @param  semiMinorAxis is the semiminor axis of the ellipse
   * @throws IllegalArgumentException if either {@code semiMajorAxis}
   *         or {@code semiMinorAxis} is negative
   */
  public static void filledEllipse(double x, double y, double semiMajorAxis, double semiMinorAxis)
  {
    if (!(semiMajorAxis >= 0))
      throw new IllegalArgumentException("ellipse semimajor axis must be nonnegative");
    if (!(semiMinorAxis >= 0))
      throw new IllegalArgumentException("ellipse semiminor axis must be nonnegative");
    double xs = scaleX(x);
    double ys = scaleY(y);
    double ws = factorX(2 * semiMajorAxis);
    double hs = factorY(2 * semiMinorAxis);
    if (ws <= 1 && hs <= 1)
      pixel(x, y);
    else
      offscreen.fill(new Ellipse2D.Double(xs - ws / 2, ys - hs / 2, ws, hs));
    draw();
  }
  /**
   * Draws a circular arc of the specified radius,
   * centered at (<em>x</em>, <em>y</em>), from angle1 to angle2 (in degrees).
   *
   * @param  x the <em>x</em>-coordinate of the center of the circle
   * @param  y the <em>y</em>-coordinate of the center of the circle
   * @param  radius the radius of the circle
   * @param  angle1 the starting angle. 0 would mean an arc beginning at 3 o'clock.
   * @param  angle2 the angle at the end of the arc. For example, if
   *         you want a 90 degree arc, then angle2 should be angle1 + 90.
   * @throws IllegalArgumentException if {@code radius} is negative
   */
  public static void arc(double x, double y, double radius, double angle1, double angle2)
  {
    if (radius < 0)
      throw new IllegalArgumentException("arc radius must be nonnegative");
    while (angle2 < angle1)
      angle2 += 360;
    double xs = scaleX(x);
    double ys = scaleY(y);
    double ws = factorX(2 * radius);
    double hs = factorY(2 * radius);
    if (ws <= 1 && hs <= 1)
      pixel(x, y);
    else
      offscreen.draw(new Arc2D.Double(xs - ws / 2, ys - hs / 2, ws, hs, angle1, angle2 - angle1, Arc2D.OPEN));
    draw();
  }
  /**
   * Draws a square of side length 2r, centered at (<em>x</em>, <em>y</em>).
   *
   * @param  x the <em>x</em>-coordinate of the center of the square
   * @param  y the <em>y</em>-coordinate of the center of the square
   * @param  halfLength one half the length of any side of the square
   * @throws IllegalArgumentException if {@code halfLength} is negative
   */
  public static void square(double x, double y, double halfLength)
  {
    if (!(halfLength >= 0))
      throw new IllegalArgumentException("half length must be nonnegative");
    double xs = scaleX(x);
    double ys = scaleY(y);
    double ws = factorX(2 * halfLength);
    double hs = factorY(2 * halfLength);
    if (ws <= 1 && hs <= 1)
      pixel(x, y);
    else
      offscreen.draw(new Rectangle2D.Double(xs - ws / 2, ys - hs / 2, ws, hs));
    draw();
  }
  /**
   * Draws a filled square of the specified size, centered at (<em>x</em>, <em>y</em>).
   *
   * @param  x the <em>x</em>-coordinate of the center of the square
   * @param  y the <em>y</em>-coordinate of the center of the square
   * @param  halfLength one half the length of any side of the square
   * @throws IllegalArgumentException if {@code halfLength} is negative
   */
  public static void filledSquare(double x, double y, double halfLength)
  {
    if (!(halfLength >= 0))
      throw new IllegalArgumentException("half length must be nonnegative");
    double xs = scaleX(x);
    double ys = scaleY(y);
    double ws = factorX(2 * halfLength);
    double hs = factorY(2 * halfLength);
    if (ws <= 1 && hs <= 1)
      pixel(x, y);
    else
      offscreen.fill(new Rectangle2D.Double(xs - ws / 2, ys - hs / 2, ws, hs));
    draw();
  }
  /**
   * Draws a rectangle of the specified size, centered at (<em>x</em>, <em>y</em>).
   *
   * @param  x the <em>x</em>-coordinate of the center of the rectangle
   * @param  y the <em>y</em>-coordinate of the center of the rectangle
   * @param  halfWidth one half the width of the rectangle
   * @param  halfHeight one half the height of the rectangle
   * @throws IllegalArgumentException if either {@code halfWidth} or {@code halfHeight} is negative
   */
  public static void rectangle(double x, double y, double halfWidth, double halfHeight)
  {
    if (!(halfWidth >= 0))
      throw new IllegalArgumentException("half width must be nonnegative");
    if (!(halfHeight >= 0))
      throw new IllegalArgumentException("half height must be nonnegative");
    double xs = scaleX(x);
    double ys = scaleY(y);
    double ws = factorX(2 * halfWidth);
    double hs = factorY(2 * halfHeight);
    if (ws <= 1 && hs <= 1)
      pixel(x, y);
    else
      offscreen.draw(new Rectangle2D.Double(xs - ws / 2, ys - hs / 2, ws, hs));
    draw();
  }
  /**
   * Draws a filled rectangle of the specified size, centered at (<em>x</em>, <em>y</em>).
   *
   * @param  x the <em>x</em>-coordinate of the center of the rectangle
   * @param  y the <em>y</em>-coordinate of the center of the rectangle
   * @param  halfWidth one half the width of the rectangle
   * @param  halfHeight one half the height of the rectangle
   * @throws IllegalArgumentException if either {@code halfWidth} or {@code halfHeight} is negative
   */
  public static void filledRectangle(double x, double y, double halfWidth, double halfHeight)
  {
    if (!(halfWidth >= 0))
      throw new IllegalArgumentException("half width must be nonnegative");
    if (!(halfHeight >= 0))
      throw new IllegalArgumentException("half height must be nonnegative");
    double xs = scaleX(x);
    double ys = scaleY(y);
    double ws = factorX(2 * halfWidth);
    double hs = factorY(2 * halfHeight);
    if (ws <= 1 && hs <= 1)
      pixel(x, y);
    else
      offscreen.fill(new Rectangle2D.Double(xs - ws / 2, ys - hs / 2, ws, hs));
    draw();
  }
  /**
   * Draws a polygon with the vertices
   * (<em>x</em><sub>0</sub>, <em>y</em><sub>0</sub>),
   * (<em>x</em><sub>1</sub>, <em>y</em><sub>1</sub>), ...,
   * (<em>x</em><sub><em>n</em>&minus;1</sub>, <em>y</em><sub><em>n</em>&minus;1</sub>).
   *
   * @param  x an array of all the <em>x</em>-coordinates of the polygon
   * @param  y an array of all the <em>y</em>-coordinates of the polygon
   * @throws IllegalArgumentException unless {@code x[]} and {@code y[]}
   *         are of the same length
   */
  public static void polygon(double[] x, double[] y)
  {
    if (x == null)
      throw new NullPointerException();
    if (y == null)
      throw new NullPointerException();
    int n1 = x.length;
    int n2 = y.length;
    if (n1 != n2)
      throw new IllegalArgumentException("arrays must be of the same length");
    int n = n1;
    GeneralPath path = new GeneralPath();
    path.moveTo((float) scaleX(x[0]), (float) scaleY(y[0]));
    for (int i = 0; i < n; i++)
      path.lineTo((float) scaleX(x[i]), (float) scaleY(y[i]));
    path.closePath();
    offscreen.draw(path);
    draw();
  }
  /**
   * Draws a polygon with the vertices
   * (<em>x</em><sub>0</sub>, <em>y</em><sub>0</sub>),
   * (<em>x</em><sub>1</sub>, <em>y</em><sub>1</sub>), ...,
   * (<em>x</em><sub><em>n</em>&minus;1</sub>, <em>y</em><sub><em>n</em>&minus;1</sub>).
   *
   * @param  x an array of all the <em>x</em>-coordinates of the polygon
   * @param  y an array of all the <em>y</em>-coordinates of the polygon
   * @throws IllegalArgumentException unless {@code x[]} and {@code y[]}
   *         are of the same length
   */
  public static void filledPolygon(double[] x, double[] y)
  {
    if (x == null)
      throw new NullPointerException();
    if (y == null)
      throw new NullPointerException();
    int n1 = x.length;
    int n2 = y.length;
    if (n1 != n2)
      throw new IllegalArgumentException("arrays must be of the same length");
    int n = n1;
    GeneralPath path = new GeneralPath();
    path.moveTo((float) scaleX(x[0]), (float) scaleY(y[0]));
    for (int i = 0; i < n; i++)
      path.lineTo((float) scaleX(x[i]), (float) scaleY(y[i]));
    path.closePath();
    offscreen.fill(path);
    draw();
  }
  private static Image getImageFromFile(String filename)
  {
    if (filename == null)
      throw new NullPointerException();
    ImageIcon icon = new ImageIcon(filename);
    if ((icon == null) || (icon.getImageLoadStatus() != MediaTracker.COMPLETE))
    {
      try
      {
        URL url = new URL(filename);
        icon = new ImageIcon(url);
      }
      catch (Exception e)
      {
      }
    }
    if ((icon == null) || (icon.getImageLoadStatus() != MediaTracker.COMPLETE))
    {
      // in case file is inside a .jar (classpath relative to StdDraw)
      URL url = StdDraw.class.getResource(filename);
      if (url != null)
        icon = new ImageIcon(url);
    }
    if ((icon == null) || (icon.getImageLoadStatus() != MediaTracker.COMPLETE))
    {
      // in case file is inside a .jar (classpath relative to root of jar)
      URL url = StdDraw.class.getResource("/" + filename);
      if (url == null)
        throw new IllegalArgumentException("image " + filename + " not found");
      icon = new ImageIcon(url);
    }
    return icon.getImage();
  }
  /**
   * Draws the specified image centered at (<em>x</em>, <em>y</em>).
   * The supported image formats are JPEG, PNG, and GIF.
   * As an optimization, the picture is cached, so there is no performance
   * penalty for redrawing the same image multiple times (e.g., in an animation).
   * However, if you change the picture file after drawing it, subsequent
   * calls will draw the original picture.
   *
   * @param  x the center <em>x</em>-coordinate of the image
   * @param  y the center <em>y</em>-coordinate of the image
   * @param  filename the name of the image/picture, e.g., "ball.gif"
   * @throws IllegalArgumentException if the image filename is invalid
   */
  public static void picture(double x, double y, String filename)
  {
    Image image = getImageFromFile(filename);
    double xs = scaleX(x);
    double ys = scaleY(y);
    int ws = image.getWidth(null);
    int hs = image.getHeight(null);
    if (ws < 0 || hs < 0)
      throw new IllegalArgumentException("image " + filename + " is corrupt");
    offscreen.drawImage(image, (int) Math.round(xs - ws / 2.0), (int) Math.round(ys - hs / 2.0), null);
    draw();
  }
  /**
   * Draws the specified image centered at (<em>x</em>, <em>y</em>),
   * rotated given number of degrees.
   * The supported image formats are JPEG, PNG, and GIF.
   *
   * @param  x the center <em>x</em>-coordinate of the image
   * @param  y the center <em>y</em>-coordinate of the image
   * @param  filename the name of the image/picture, e.g., "ball.gif"
   * @param  degrees is the number of degrees to rotate counterclockwise
   * @throws IllegalArgumentException if the image filename is invalid
   */
  public static void picture(double x, double y, String filename, double degrees)
  {
    Image image = getImageFromFile(filename);
    double xs = scaleX(x);
    double ys = scaleY(y);
    int ws = image.getWidth(null);
    int hs = image.getHeight(null);
    if (ws < 0 || hs < 0)
      throw new IllegalArgumentException("image " + filename + " is corrupt");
    offscreen.rotate(Math.toRadians(-degrees), xs, ys);
    offscreen.drawImage(image, (int) Math.round(xs - ws / 2.0), (int) Math.round(ys - hs / 2.0), null);
    offscreen.rotate(Math.toRadians(+degrees), xs, ys);
    draw();
  }
  /**
   * Draws the specified image centered at (<em>x</em>, <em>y</em>),
   * rescaled to the specified bounding box.
   * The supported image formats are JPEG, PNG, and GIF.
   *
   * @param  x the center <em>x</em>-coordinate of the image
   * @param  y the center <em>y</em>-coordinate of the image
   * @param  filename the name of the image/picture, e.g., "ball.gif"
   * @param  scaledWidth the width of the scaled image in pixels
   * @param  scaledHeight the height of the scaled image in pixels
   * @throws IllegalArgumentException if either {@code scaledWidth}
   *         or {@code scaledHeight} is negative
   * @throws IllegalArgumentException if the image filename is invalid
   */
  public static void picture(double x, double y, String filename, double scaledWidth, double scaledHeight)
  {
    Image image = getImageFromFile(filename);
    if (scaledWidth < 0)
      throw new IllegalArgumentException("width is negative: " + scaledWidth);
    if (scaledHeight < 0)
      throw new IllegalArgumentException("height is negative: " + scaledHeight);
    double xs = scaleX(x);
    double ys = scaleY(y);
    double ws = factorX(scaledWidth);
    double hs = factorY(scaledHeight);
    if (ws < 0 || hs < 0)
      throw new IllegalArgumentException("image " + filename + " is corrupt");
    if (ws <= 1 && hs <= 1)
      pixel(x, y);
    else
    {
      offscreen.drawImage(image, (int) Math.round(xs - ws / 2.0), (int) Math.round(ys - hs / 2.0),
          (int) Math.round(ws), (int) Math.round(hs), null);
    }
    draw();
  }
  /**
   * Draws the specified image centered at (<em>x</em>, <em>y</em>), rotated
   * given number of degrees, and rescaled to the specified bounding box.
   * The supported image formats are JPEG, PNG, and GIF.
   *
   * @param  x the center <em>x</em>-coordinate of the image
   * @param  y the center <em>y</em>-coordinate of the image
   * @param  filename the name of the image/picture, e.g., "ball.gif"
   * @param  scaledWidth the width of the scaled image in pixels
   * @param  scaledHeight the height of the scaled image in pixels
   * @param  degrees is the number of degrees to rotate counterclockwise
   * @throws IllegalArgumentException if either {@code scaledWidth}
   *         or {@code scaledHeight} is negative
   * @throws IllegalArgumentException if the image filename is invalid
   */
  public static void picture(double x, double y, String filename, double scaledWidth, double scaledHeight,
      double degrees)
  {
    if (scaledWidth < 0)
      throw new IllegalArgumentException("width is negative: " + scaledWidth);
    if (scaledHeight < 0)
      throw new IllegalArgumentException("height is negative: " + scaledHeight);
    Image image = getImageFromFile(filename);
    double xs = scaleX(x);
    double ys = scaleY(y);
    double ws = factorX(scaledWidth);
    double hs = factorY(scaledHeight);
    if (ws < 0 || hs < 0)
      throw new IllegalArgumentException("image " + filename + " is corrupt");
    if (ws <= 1 && hs <= 1)
      pixel(x, y);
    offscreen.rotate(Math.toRadians(-degrees), xs, ys);
    offscreen.drawImage(image, (int) Math.round(xs - ws / 2.0), (int) Math.round(ys - hs / 2.0),
        (int) Math.round(ws), (int) Math.round(hs), null);
    offscreen.rotate(Math.toRadians(+degrees), xs, ys);
    draw();
  }
  /**
   * Write the given text string in the current font, centered at (<em>x</em>, <em>y</em>).
   *
   * @param  x the center <em>x</em>-coordinate of the text
   * @param  y the center <em>y</em>-coordinate of the text
   * @param  text the text to write
   */
  public static void text(double x, double y, String text)
  {
    if (text == null)
      throw new NullPointerException();
    offscreen.setFont(font);
    FontMetrics metrics = offscreen.getFontMetrics();
    double xs = scaleX(x);
    double ys = scaleY(y);
    int ws = metrics.stringWidth(text);
    int hs = metrics.getDescent();
    offscreen.drawString(text, (float) (xs - ws / 2.0), (float) (ys + hs));
    draw();
  }
  /**
   * Write the given text string in the current font, centered at (<em>x</em>, <em>y</em>) and
   * rotated by the specified number of degrees.
   * @param  x the center <em>x</em>-coordinate of the text
   * @param  y the center <em>y</em>-coordinate of the text
   * @param  text the text to write
   * @param  degrees is the number of degrees to rotate counterclockwise
   */
  public static void text(double x, double y, String text, double degrees)
  {
    if (text == null)
      throw new NullPointerException();
    double xs = scaleX(x);
    double ys = scaleY(y);
    offscreen.rotate(Math.toRadians(-degrees), xs, ys);
    text(x, y, text);
    offscreen.rotate(Math.toRadians(+degrees), xs, ys);
  }
  /**
   * Write the given text string in the current font, left-aligned at (<em>x</em>, <em>y</em>).
   * @param  x the <em>x</em>-coordinate of the text
   * @param  y the <em>y</em>-coordinate of the text
   * @param  text the text
   */
  public static void textLeft(double x, double y, String text)
  {
    if (text == null)
      throw new NullPointerException();
    offscreen.setFont(font);
    FontMetrics metrics = offscreen.getFontMetrics();
    double xs = scaleX(x);
    double ys = scaleY(y);
    int hs = metrics.getDescent();
    offscreen.drawString(text, (float) xs, (float) (ys + hs));
    draw();
  }
  /**
   * Write the given text string in the current font, right-aligned at (<em>x</em>, <em>y</em>).
   *
   * @param  x the <em>x</em>-coordinate of the text
   * @param  y the <em>y</em>-coordinate of the text
   * @param  text the text to write
   */
  public static void textRight(double x, double y, String text)
  {
    if (text == null)
      throw new NullPointerException();
    offscreen.setFont(font);
    FontMetrics metrics = offscreen.getFontMetrics();
    double xs = scaleX(x);
    double ys = scaleY(y);
    int ws = metrics.stringWidth(text);
    int hs = metrics.getDescent();
    offscreen.drawString(text, (float) (xs - ws), (float) (ys + hs));
    draw();
  }
  public static void show(int t)
  {
    long millis = System.currentTimeMillis();
    if (millis < nextDrawInMS)
    {
      try
      {
        Thread.sleep(nextDrawInMS - millis);
      }
      catch (InterruptedException e)
      {
        System.out.println("Error sleeping");
      }
      millis = nextDrawInMS;
    }
    defer = false;
    draw();
    defer = true;
    nextDrawInMS = millis + t;
  }
  /**
   * Display on-screen and turn off animation mode:
   * subsequent calls to
   * drawing methods such as {@code line()}, {@code circle()},
   * and {@code square()} will be displayed on screen when called.
   * This is the default.
   */
  public static void show()
  {
    defer = false;
    nextDrawInMS = -1;
    draw();
  }
  private static void draw()
  {
    if (defer)
      return;
    onscreen.drawImage(offscreenImage, 0, 0, null);
    frame.repaint();
  }
  /**
   * Saves the drawing to using the specified filename.
   * The supported image formats are JPEG and PNG;
   * the filename suffix must be <tt>.jpg</tt> or <tt>.png</tt>.
   *
   * @param  filename the name of the file with one of the required suffixes
   */
  public static void save(String filename)
  {
    if (filename == null)
      throw new NullPointerException();
    File file = new File(filename);
    String suffix = filename.substring(filename.lastIndexOf('.') + 1);
    if (suffix.toLowerCase().equals("png"))
    {
      try
      {
        ImageIO.write(onscreenImage, suffix, file);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    else if (suffix.toLowerCase().equals("jpg"))
    {
      WritableRaster raster = onscreenImage.getRaster();
      WritableRaster newRaster;
      newRaster = raster.createWritableChild(0, 0, width, height, 0, 0, new int[]{0, 1, 2});
      DirectColorModel cm = (DirectColorModel) onscreenImage.getColorModel();
      DirectColorModel newCM = new DirectColorModel(cm.getPixelSize(), cm.getRedMask(), cm.getGreenMask(),
          cm.getBlueMask());
      BufferedImage rgbBuffer = new BufferedImage(newCM, newRaster, false, null);
      try
      {
        ImageIO.write(rgbBuffer, suffix, file);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      System.out.println("Invalid image file type: " + suffix);
    }
  }
  @Override
  public void actionPerformed(ActionEvent e)
  {
    FileDialog chooser = new FileDialog(StdDraw.frame, "Use a .png or .jpg extension", FileDialog.SAVE);
    chooser.setVisible(true);
    String filename = chooser.getFile();
    if (filename != null)
    {
      StdDraw.save(chooser.getDirectory() + File.separator + chooser.getFile());
    }
  }
  public static boolean isNextKeyTyped()
  {
    synchronized (keyLock)
    {
      return !keysTyped.isEmpty();
    }
  }
  /**
   * Returns the next key that was typed by the user (that your program has not already processed).
   * This method should be preceded by a call to {@link #isNextKeyTyped()} to ensure
   * that there is a next key to process.
   * This method returns a Unicode character corresponding to the key
   * typed (such as {@code 'a'} or {@code 'A'}).
   * It cannot identify action keys (such as F1 and arrow keys)
   * or modifier keys (such as control).
   *
   * @return the next key typed by the user (that your program has not already processed).
   * @throws NoSuchElementException if there is no remaining key
   */
  public static char nextKeyTyped()
  {
    synchronized (keyLock)
    {
      if (keysTyped
          .isEmpty()) { throw new NoSuchElementException("your program has already processed all keystrokes"); }
      return keysTyped.removeLast();
    }
  }
  /**
   * Returns true if the given key is being pressed.
   * <p>
   * This method takes the keycode (corresponding to a physical key)
  *  as an argument. It can handle action keys
   * (such as F1 and arrow keys) and modifier keys (such as shift and control).
   * See {@link KeyEvent} for a description of key codes.
   *
   * @param  keycode the key to check if it is being pressed
   * @return <tt>true</tt> if {@code keycode} is currently being pressed;
   *         <tt>false</tt> otherwise
   */
  public static boolean isKeyPressed(int keycode)
  {
    synchronized (keyLock)
    {
      return keysDown.contains(keycode);
    }
  }
  @Override
  public void keyTyped(KeyEvent e)
  {
    synchronized (keyLock)
    {
      keysTyped.addFirst(e.getKeyChar());
    }
  }
  @Override
  public void keyPressed(KeyEvent e)
  {
    synchronized (keyLock)
    {
      keysDown.add(e.getKeyCode());
    }
  }
  @Override
  public void keyReleased(KeyEvent e)
  {
    synchronized (keyLock)
    {
      keysDown.remove(e.getKeyCode());
    }
  }
}
