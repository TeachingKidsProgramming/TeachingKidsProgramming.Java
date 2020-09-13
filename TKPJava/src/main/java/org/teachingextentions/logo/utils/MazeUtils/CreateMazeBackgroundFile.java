package src.main.java.org.teachingextentions.logo.utils.MazeUtils;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.MySystem;
import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.TestUtils;
import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.ComponentApprovalWriter;
import src.main.java.org.teachingextentions.logo.utils.VirtualProctorUtils.ScreenCapture;


/*****in progress****/
public class CreateMazeBackgroundFile extends WindowAdapter
{
  public static void main(String[] args)
  {
    CoolMaze maze1 = new CoolMaze(8);
    maze1.drawWallsAndEndPoint();
    StdDraw.frame.addWindowListener(adapter);
    closeTheWindow();
  }
  private static void closeTheWindow()
  {
    StdDraw.frame.dispatchEvent(new WindowEvent(StdDraw.frame, WindowEvent.WINDOW_CLOSING));
  }
  static WindowListener adapter = new WindowListener()
  {
    @Override
    public void windowOpened(WindowEvent e)
    {
    }
    @Override
    public void windowClosing(WindowEvent e)
    {
      BufferedImage scaledMazeBackground = ScreenCapture.getScaledImageOf(e.getComponent(), 350, 350);
      System.out.println("we got the window image, now what?");
      sendImageToDisk(scaledMazeBackground);
    }
    @Override
    public void windowClosed(WindowEvent e)
    {
    }
    @Override
    public void windowIconified(WindowEvent e)
    {
    }
    @Override
    public void windowDeiconified(WindowEvent e)
    {
    }
    @Override
    public void windowActivated(WindowEvent e)
    {
    }
    @Override
    public void windowDeactivated(WindowEvent e)
    {
    }
  };
  public static BufferedImage getImageOf(Component component, int width, int height)
  {
    BufferedImage image = ComponentApprovalWriter.drawComponent(component);
    return image;
  }
  public static void sendImageToDisk(BufferedImage scaledMazeBackground)
  {
    try
    {
      Component c = StdDraw.frame.getComponent(0);
      Graphics g = scaledMazeBackground.createGraphics();
      c.paint(g);
      g.dispose();
      String filename = "./src/main/resources/mazeBackground/CoolMazeBackground.png";
      ImageIO.write(scaledMazeBackground, "png", new File(filename));
      //NOTE If you want to see the file that will be saved, uncomment the line below
      TestUtils.displayFile(filename);
    }
    catch (Exception e)
    {
      MySystem.warning(e);
    }
  }
  // NOTE: set this image as a background image for the TortoiseMaze recipe
}
