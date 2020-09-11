package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ComponentApprovalWriter implements ApprovalWriter {
  private ImageApprovalWriter image = null;

  public ComponentApprovalWriter(Component c) {
    BufferedImage image = drawComponent(c);
    this.image = new ImageApprovalWriter(image);
  }

  public static BufferedImage drawComponent(Component c) {
    validateComponent(c);
    BufferedImage image = new BufferedImage(c.getWidth(), c.getHeight(), BufferedImage.TYPE_INT_ARGB);
    Graphics g = image.createGraphics();
    c.paint(g);
    g.dispose();
    return image;
  }

  private static void validateComponent(Component c) {
    if (!c.isValid()) {
      if (c instanceof JFrame) {
        ((JFrame) c).pack();
      } else {
        JFrame frame = new JFrame();
        frame.getContentPane().add(c);
        frame.pack();
      }
    }
  }

  @Override
  public String writeReceivedFile(String filename) throws Exception {
    return image.writeReceivedFile(filename);
  }

  @Override
  public String getReceivedFilename(String base) {
    return image.getReceivedFilename(base);
  }

  @Override
  public String getApprovalFilename(String base) {
    return image.getApprovalFilename(base);
  }
}