package src.main.java.org.teachingextentions.logo.utils.InterfaceUtils;

import src.main.java.org.teachingextentions.logo.utils.LineAndShapeUtils.Paintable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

@Deprecated
public class TkpPanel {

  private LazyPanel panel = new LazyPanel();

  public static Graphics2D configureGraphics2D(Graphics g) {
    Graphics2D g2d = (Graphics2D) g.create();
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
    g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
    g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
    return g2d;
  }

  public TkpPanel add(Component component) {
    this.panel.getValue().add(component);
    return this;
  }

  public TkpPanel setBackground(Color color) {
    this.panel.getValue().setBackground(color);
    return this;
  }

  public TkpPanel remove(Paintable item) {
    this.panel.getValue().remove(item);
    return this;
  }

  public TkpPanel add(Paintable item) {
    this.panel.getValue().add(item);

    return this;
  }

  public TkpPanel addTo(JFrame frame) {
    frame.getContentPane().add(this.panel.getValue());
    return this;
  }

  private class LazyPanel {

    private PaintablePanel value;

    public PaintablePanel getValue() {
      if (this.value == null) {
        this.value = new PaintablePanel();
      }

      return this.value;
    }


  }

  private class PaintablePanel extends JPanel {
    public ArrayList<Paintable> interfaceElements = new ArrayList<>();

    public PaintablePanel remove(Paintable item) {
      if (interfaceElements.contains(item)) {
        interfaceElements.remove(item);
      }

      return this;
    }

    @Override
    public void paint(Graphics g) {
      super.paint(g);
      Graphics2D g2d = TkpPanel.configureGraphics2D(g);
      for (Paintable p : interfaceElements) {
        p.paint(g2d, this);
      }
      g2d.dispose();
    }

    protected PaintablePanel add(Paintable item) {
      if (!interfaceElements.contains(item)) {
        interfaceElements.add(item);
      }
      return this;
    }
  }
}
