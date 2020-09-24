package src.main.java.org.teachingextentions.logo.utils.MazeUtils;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class StdDrawMouseEvents implements MouseListener, MouseMotionListener
{
  public static Object   mouseLock    = new Object();
  private static boolean mousePressed = false;
  private static double  mouseX       = 0;
  private static double  mouseY       = 0;
  public static boolean isMousePressed()
  {
    synchronized (mouseLock)
    {
      return mousePressed;
    }
  }
  public static double mouseX()
  {
    synchronized (mouseLock)
    {
      return mouseX;
    }
  }
  public static double mouseY()
  {
    synchronized (mouseLock)
    {
      return mouseY;
    }
  }
  @Override
  public void mouseClicked(MouseEvent e)
  {
  }
  @Override
  public void mouseEntered(MouseEvent e)
  {
  }
  @Override
  public void mouseExited(MouseEvent e)
  {
  }
  @Override
  public void mousePressed(MouseEvent e)
  {
    synchronized (mouseLock)
    {
      mouseX = StdDraw.userX(e.getX());
      mouseY = StdDraw.userY(e.getY());
      mousePressed = true;
    }
  }
  @Override
  public void mouseReleased(MouseEvent e)
  {
    synchronized (mouseLock)
    {
      mousePressed = false;
    }
  }
  @Override
  public void mouseDragged(MouseEvent e)
  {
    synchronized (mouseLock)
    {
      mouseX = StdDraw.userX(e.getX());
      mouseY = StdDraw.userY(e.getY());
    }
  }
  @Override
  public void mouseMoved(MouseEvent e)
  {
    synchronized (mouseLock)
    {
      mouseX = StdDraw.userX(e.getX());
      mouseY = StdDraw.userY(e.getY());
    }
  }
}
