/**
 *  <p>
 *  <b>Example code</b>
 *  <p>
 *  <pre>
 *   public class TestStdDraw {
 *       public static void main(String[] args) {
 *           StdDraw.setPenRadius(0.05);
 *           StdDraw.setPenColor(StdDraw.BLUE);
 *           StdDraw.point(0.5, 0.5);
 *           StdDraw.setPenColor(StdDraw.MAGENTA);
 *           StdDraw.line(0.2, 0.2, 0.8, 0.2);
 *       }
 *   }
 *  </pre>
 *  <p>
 *  <b>Points and lines.</b>
 *  <ul>
 *  <li> {@link #point(double x, double y)}
 *  <li> {@link #line(double x1, double y1, double x2, double y2)}
 *  </ul>
 *  <p>
 *  The <em>x</em>- and <em>y</em>-coordinates must be in the drawing area
 *  (between 0 and 1 and by default) or the points and lines will not be visible.
 *  <p>
 *  <b>Squares, circles, rectangles, and ellipses.</b>
 *  You can draw squares, circles, rectangles, and ellipses using
 *  the following methods:
 *  <ul>
 *  <li> {@link #circle(double x, double y, double radius)}
 *  <li> {@link #ellipse(double x, double y, double semiMajorAxis, double semiMinorAxis)}
 *  <li> {@link #square(double x, double y, double radius)}
 *  <li> {@link #rectangle(double x, double y, double halfWidth, double halfHeight)}
 *  </ul>
 *  <p>
 *  All of these methods take as arguments the location and size of the shape.
 *  The location is always specified by the <em>x</em>- and <em>y</em>-coordinates
 *  of its <em>center</em>.
 *  The size of a circle is specified by its radius and the size of an ellipse is
 *  specified by the lengths of its semi-major and semi-minor axes.
 *  The size of a square or rectangle is specified by its half-width or half-height.
 *  The convention for drawing squares and rectangles is parallel to those for
 *  drawing circles and ellipses, but may be unexpected to the uninitiated.
 *  <p>
 *  The methods above trace outlines of the given shapes. The following methods
 *  draw filled versions:
 *  <ul>
 *  <li> {@link #filledCircle(double x, double y, double radius)}
 *  <li> {@link #filledEllipse(double x, double y, double semiMajorAxis, double semiMinorAxis)}
 *  <li> {@link #filledSquare(double x, double y, double radius)}
 *  <li> {@link #filledRectangle(double x, double y, double halfWidth, double halfHeight)}
 *  </ul>
 *  <p>
 *  <b>Circular arcs.</b>
 *  You can draw circular arcs with the following method:
 *  <ul>
 *  <li> {@link #arc(double x, double y, double radius, double angle1, double angle2)}
 *  </ul>
 *  <p>
 *  The arc is from the circle centered at (<em>x</em>, <em>y</em>) of the specified radius.
 *  The arc extends from angle1 to angle2. By convention, the angles are
 *  <em>polar</em> (counterclockwise angle from the <em>x</em>-axis)
 *  and represented in degrees. For example, {@code StdDraw.arc(0.0, 0.0, 1.0, 0, 90)}
 *  draws the arc of the unit circle from 3 o'clock (0 degrees) to 12 o'clock (90 degrees).
 *  <p>
 *  <b>Polygons.</b>
 *  You can draw polygons with the following methods:
 *  <ul>
 *  <li> {@link #polygon(double[] x, double[] y)}
 *  <li> {@link #filledPolygon(double[] x, double[] y)}
 *  </ul>
 *  <p>
 *  The points in the polygon are ({@code x[i]}, {@code y[i]}).
 *  For example, the following code fragment draws a filled diamond
 *  with vertices (0.1, 0.2), (0.2, 0.3), (0.3, 0.2), and (0.2, 0.1):
 *  <pre>
 *   double[] x = { 0.1, 0.2, 0.3, 0.2 };
 *   double[] y = { 0.2, 0.3, 0.2, 0.1 };
 *   StdDraw.filledPolygon(x, y);
 *  </pre>
 *  <p>
 *  <b>Pen size.</b>
 *  The pen is circular, so that when you set the pen radius to <em>r</em>
 *  and draw a point, you get a circle of radius <em>r</em>. Also, lines are
 *  of thickness 2<em>r</em> and have rounded ends. The default pen radius
 *  is 0.005 and is not affected by coordinate scaling. This default pen
 *  radius is about 1/200 the width of the default canvas, so that if
 *  you draw 100 points equally spaced along a horizontal or vertical line,
 *  you will be able to see individual circles, but if you draw 200 such
 *  points, the result will look like a line.
 *  <ul>
 *  <li> {@link #setPenRadius(double radius)}
 *  </ul>
 *  <p>
 *  For example, {@code StdDraw.setPenRadius(0.025)} makes
 *  the thickness of the lines and the size of the points to be five times
 *  the 0.005 default.
 *  To draw points with the minimum possible radius (one pixel on typical
 *  displays), set the pen radius to 0.0.
 *  <p>
 *  <b>Pen color.</b>
 *  All geometric shapes (such as points, lines, and circles) are drawn using
 *  the current pen color. By default, it is black.
 *  You can change the pen color with the following methods:
 *  <ul>
 *  <li> {@link #setPenColor(int red, int green, int blue)}
 *  <li> {@link #setPenColor(Color color)}
 *  </ul>
 *  <p>
 *  The first method allows you to specify colors using the RGB color system.
 *  This <a href = "http://johndyer.name/lab/colorpicker/">color picker</a>
 *  is a convenient way to find a desired color.
 *  The second method allows you to specify colors using the
 *  {@link Color} data type that is discussed in Chapter 3. Until then,
 *  you can use this method with one of these predefined colors in standard drawing:
 *  {@link #BLACK}, {@link #BLUE}, {@link #CYAN}, {@link #DARK_GRAY}, {@link #GRAY},
 *  {@link #GREEN}, {@link #LIGHT_GRAY}, {@link #MAGENTA}, {@link #ORANGE},
 *  {@link #PINK}, {@link #RED}, {@link #WHITE}, and {@link #YELLOW}.
 *  For example, {@code StdDraw.setPenColor(StdDraw.MAGENTA)} sets the
 *  pen color to magenta.
 *  <p>
 *  <b>Canvas size.</b>
 *  By default, all drawing takes places in a 512-by-512 canvas.
 *  The canvas does not include the window title or window border.
 *  You can change the size of the canvas with the following method:
 *  <ul>
 *  <li> {@link #setCanvasSize(int width, int height)}
 *  </ul>
 *  <p>
 *  This sets the canvas size to be <em>width</em>-by-<em>height</em> pixels.
 *  It also erases the current drawing and resets the coordinate system,
 *  pen radius, pen color, and font back to their default values.
 *  Ordinarly, this method is called once, at the very beginning of a program.
 *  For example, {@code StdDraw.setCanvasSize(800, 800)}
 *  sets the canvas size to be 800-by-800 pixels.
 *  <p>
 *  <b>Canvas scale and coordinate system.</b>
 *  By default, all drawing takes places in the unit square, with (0, 0) at
 *  lower left and (1, 1) at upper right. You can change the default
 *  coordinate system with the following methods:
 *  <ul>
 *  <li> {@link #setXscale(double xmin, double xmax)}
 *  <li> {@link #setYscale(double ymin, double ymax)}
 *  <li> {@link #setScale(double min, double max)}
 *  </ul>
 *  <p>
 *  The arguments are the coordinates of the minimum and maximum
 *  <em>x</em>- or <em>y</em>-coordinates that will appear in the canvas.
 *  For example, if you  wish to use the default coordinate system but
 *  leave a small margin, you can call {@code StdDraw.setScale(-.05, 1.05)}.
 *  <p>
 *  These methods change the coordinate system for subsequent drawing
 *  commands; they do not affect previous drawings.
 *  These methods do not change the canvas size; so, if the <em>x</em>-
 *  and <em>y</em>-scales are different, squares will become rectangles
 *  and circles will become ellipsoidal.
 *  <p>
 *  <b>Text.</b>
 *  You can use the following methods to annotate your drawings with text:
 *  <ul>
 *  <li> {@link #text(double x, double y, String text)}
 *  <li> {@link #text(double x, double y, String text, double degrees)}
 *  <li> {@link #textLeft(double x, double y, String text)}
 *  <li> {@link #textRight(double x, double y, String text)}
 *  </ul>
 *  <p>
 *  The first two methods write the specified text in the current font,
 *  centered at (<em>x</em>, <em>y</em>).
 *  The second method allows you to rotate the text.
 *  The last two methods either left- or right-align the text at (<em>x</em>, <em>y</em>).
 *  <p>
 *  The default font is a Sans Serif font with point size 16.
 *  You can use the following method to change the font:
 *  <ul>
 *  <li> {@link #setFont(Font font)}
 *  </ul>
 *  <p>
 *  You use the {@link Font} data type to specify the font. This allows you to
 *  choose the face, size, and style of the font. For example, the following
 *  code fragment sets the font to Arial Bold, 60 point.
 *  <pre>
 *   Font font = new Font("Arial", Font.BOLD, 60);
 *   StdDraw.setFont(font);
 *   StdDraw.text(0.5, 0.5, "Hello, World");
 *  </pre>
 *  <p>
 *  <b>Images.</b>
 *  You can use the following methods to add images to your drawings:
 *  <ul>
 *  <li> {@link #picture(double x, double y, String filename)}
 *  <li> {@link #picture(double x, double y, String filename, double degrees)}
 *  <li> {@link #picture(double x, double y, String filename, double width)}
 *  <li> {@link #picture(double x, double y, String filename, double width, double degrees)}
 *  </ul>
 *  <p>
 *  These methods draw the specified image, centered at (<em>x</em>, <em>y</em>).
 *  The supported image formats are JPEG, PNG, and GIF.
 *  The image will display at its native size, independent of the coordinate system.
 *  Optionally, you can rotate the image a specified number of degrees counterclockwise
 *  or rescale it to fit inside a width-by-height pixel bounding box.
 *  <p>
 *  <b>Saving to a file.</b>
 *  You save your image to a file using the <em>File -> Save</em> menu option.
 *  You can also save a file programatically using the following method:
 *  <ul>
 *  <li> {@link #save(String filename)}
 *  </ul>
 *  <p>
 *  The supported image formats are JPEG and PNG. The filename must have either the
 *  extension .jpg or .png.
 *  We recommend using PNG for drawing that consist solely of geometric shapes and JPEG
 *  for drawings that contains pictures.
 *  <p>
 *  <b>Clearing the canvas.</b>
 *  To clearWindow the entire drawing canvas, you can use the following methods:
 *  <ul>
 *  <li> {@link #clearScreenToWhite()}
 *  <li> {@link #clearScreenToColor(Color color)}
 *  </ul>
 *  <p>
 *  The first method clears the canvas to white; the second method
 *  allows you to specify a color of your choice. For example,
 *  {@code StdDraw.clearWindow(StdDraw.LIGHT_GRAY)} clears the canvas to a shade
 *  of gray. Most often, these two methods are used in conjunction with animation mode.
 *  <p>
 *  <b>Animations.</b>
 *  Animation mode is one of the trickier features of standard drawing.
 *  The following two methods control the way in which objects are drawn:
 *  <ul>
 *  <li> {@link #show()}
 *  <li> {@link #show(int t)}
 *  </ul>
 *  <p>
 *  By default, animation mode is off, which means that as soon as you
 *  call a drawing
 *  method&mdash;such as {@code point()} or {@code line()}&mdash;the
 *  results appear on the screen. {@code StdDraw.show()} turns off
 *  animation mode.
 *  <p>
 *  You can call {@link #show(int t)} to turn on animation mode. This
 *  defers all drawing to the screen until you are aready to display them.
 *  Once you are ready to display them,
 *  you call {@link #show(int t)} again, which transfer the offscreen
 *  drawing to the screen and waits for the specified number of milliseconds.
 *  In conjuction with {@link #clearScreenToWhite()}, you can create the illusion
 *  of movement by iterating the following three steps:
 *  <ul>
 *  <li> Clear the background canvas.
 *  <li> Draw geometric objects.
 *  <li> Show the drawing and wait for a short while.
 *  </ul>
 *  <p>
 *  Waiting for a short while is essential; otherwise, the drawing will appear
 *  and disappear so quickly that your animation will flicker.
 *  <p>
 *  Here is a simple example of an animation:
 *  <p>
 *  <b>Keyboard and mouse inputs.</b>
 *  Standard drawing has very basic support for keyboard and mouse input.
 *  It is much less powerful than most user interface libraries provide, but also much simpler.
 *  You can use the following methods to intercept mouse events:
 *  <ul>
 *  <li> {@link #isMousePressed()}
 *  <li> {@link #mouseX()}
 *  <li> {@link #mouseY()}
 *  </ul>
 *  <p>
 *  The first method tells you whether a mouse button is currently being pressed.
 *  The last two methods tells you the <em>x</em>- and <em>y</em>-coordinates of the mouse's
 *  current position, using the same coordinate system as the canvas (the unit square, by default).
 *  You should use these methods in an animation loop that waits a short while before trying
 *  to poll the mouse for its current state.
 *  You can use the following methods to intercept keyboard events:
 *  <ul>
 *  <li> {@link #isNextKeyTyped()}
 *  <li> {@link #nextKeyTyped()}
 *  <li> {@link #isKeyPressed(int keycode)}
 *  </ul>
 *  <p>
 *  If the user types lots of keys, they will be saved in a list until you process them.
 *  The first method tells you whether the user has typed a key (that your program has
 *  not yet processed).
 *  The second method returns the next key that the user typed (that your program has
 *  not yet processed) and removes it from the list of saved keystrokes.
 *  The third method tells you whether a key is currently being pressed.
 *  <p>
 *  <b>Accessing control parameters.</b>
 *  You can use the following methods to access the current pen color, pen radius,
 *  and font:
 *  <ul>
 *  <li> {@link #getPenColor()}
 *  <li> {@link #getPenRadius()}
 *  <li> {@link #getFont()}
 *  </ul>
 *  <p>
 *  These methods are useful when you want to temporarily change a
 *  control parameter and reset it back to its original value.
 *  <p>
 *  <b>Corner cases.</b>
 *  To avoid clutter, the API doesn't explicitly refer to arguments that are
 *  null, infinity, or NaN.
 *  <ul>
 *  <li> Any method that is passed a {@code null} argument will throw a
 *       {@link NullPointerException}.
 *  <li> Except as noted in the APIs, drawing an object outside (or partly outside)
 *       the canvas is permitted&mdash;however, only the part of the object that
 *       appears inside the canvas will be visible.
 *  <li> Except as noted in the APIs, all methods accept {@link Double#NaN},
 *       {@link Double#POSITIVE_INFINITY}, and {@link Double#NEGATIVE_INFINITY}
 *       as arugments. An object drawn with an <em>x</em>- or <em>y</em>-coordinate
 *       that is NaN will behave as if it is outside the canvas, and will not be visible.
 *  </ul>
 *  <p>
 *  <b>Performance tricks.</b>
 *  Standard drawing is capable of drawing large amounts of data.
 *  Here are a few tricks and tips:
 *  <ul>
 *  <li> Use <em>animation mode</em> for static drawing with a large
 *       number of objects.
 *       That is, call {@code StdDraw.show(0)} before
 *       and after the sequence of drawing commands.
 *       The bottleneck operation is not drawing the geometric
 *       shapes but rather drawing them to the screen. By using animation
 *       mode, you draw all of the shapes to an offscreen buffer, then copy
 *       them all at once to the screen.
 *  <li> When using <em>animation mode</em>, call {@code show()}
 *       only once per frame, not after drawing each object.
 *  <li> If you call {@code picture()} multiple times with the same filename,
 *       Java will cache the image, so you do not incur the cost of reading
 *       from a file each time.
 *  <li> Do not call {@code setFont()} in an animation loop (unless you really
 *       need to change the font in each iteration). It can cause flicker.
 *  </ul>
 *  <p>
 *  <b>Known bugs and issues.</b>
 *  <ul>
 *  <li> The {@code picture()} methods may not draw the portion of the image that is
 *       inside the canvas if the center point (<em>x</em>, <em>y</em>) is outside the
 *       canvas.
 *       This bug appears only on some systems.
 *  <li> Some methods may not draw the portion of the geometric object that is inside the
 *       canvas if the <em>x</em>- or <em>y</em>-coordinates are infinite.
 *       This bug appears only on some systems.
 *  </ul>
 *  <p>
 *  <b>Authors</b>
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */