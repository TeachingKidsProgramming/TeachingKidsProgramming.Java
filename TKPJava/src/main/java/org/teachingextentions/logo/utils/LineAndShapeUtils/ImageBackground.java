package src.main.java.org.teachingextentions.logo.utils.LineAndShapeUtils;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.ObjectUtils;

public class ImageBackground implements Paintable
{
  private BufferedImage image;
  public ImageBackground(String uri)
  {
    try
    {
      URL url = new URL(uri);
      image = ImageIO.read(url);
    }
    catch (Throwable e)
    {
      throw ObjectUtils.throwAsError(e);
    }
  }
  @Override
  public void paint(Graphics2D g, JPanel caller)
  {
    Image img = image;
    g.drawImage(img, 0, 0, caller.getWidth(), caller.getHeight(), 0, 0, img.getWidth(null), img.getHeight(null),
        null);
  }
}
