package src.main.java.org.teachingextentions.logo.utils.TKPLogoUtils;

import org.teachingkidsprogramming.section01forloops.MakeALogo;
import src.main.java.org.teachingextentions.logo.Tortoise;
import src.main.java.org.teachingextentions.logo.utils.ColorUtils.ColorWheel;
import src.main.java.org.teachingextentions.logo.utils.ColorUtils.PenColors;

/**
 * <img src="https://avatars0.githubusercontent.com/u/4691010?v=3&s=200" style="text-align: left" alt="The TKP logo" height="40">
 * The TKPLogo allows <b>you</b> to create a super cool TKP logo on your window
 */
public class TKPLogo
{
  /**
   * Sets up a particular set of Colors on the Color Wheel
   * <div><b>Example:</b> {@code TKPLogo.setupColorWheel();}</div>
   */
  public static void setupColorWheel()
  {
    ColorWheel.addColor(PenColors.Grays.Gray);
    ColorWheel.addColor(PenColors.Greens.Green);
    ColorWheel.addColor(PenColors.Pinks.Pink);
    ColorWheel.addColor(PenColors.Purples.Purple);
    ColorWheel.addColor(PenColors.Blues.Blue);
    ColorWheel.addColor(PenColors.Yellows.Yellow);
    ColorWheel.addColor(PenColors.Browns.Brown);
    ColorWheel.addColor(PenColors.Oranges.Orange);
    ColorWheel.addColor(PenColors.Reds.Red);
    ColorWheel.addColor(PenColors.Whites.White);
    setupBackgroundAndLines();
  }
  private static void setupBackgroundAndLines()
  {
    Tortoise.getBackgroundWindow()
        .setBackground(ColorWheel.getRandomColorFromWheel());
    Tortoise.setPenWidth(4);
  }
  /**
   * Draws an <i>amazing</> TKP inner P
   * <div><b>Example:</b> {@code TKPLogo.draw_inner_tkp_P();}</div>
   */
  public static void draw_inner_tkp_P()
  {
    Tortoise.setX(MakeALogo.XValue + 355);
    Tortoise.setY(MakeALogo.YValue - 135);
    Tortoise.turn(180);
    Tortoise.move(10);
    TKPLogo.curve6();
    Tortoise.move(10);
    Tortoise.turn(90);
    Tortoise.move(50);
    Tortoise.hide();
    Tortoise.turn(1);
  }
  /**
   * Draws an <i>awesome</> TKP outer P
   * <div><b>Example:</b> {@code TKPLogo.draw_outer_tkp_P();}</div>
   */
  public static void draw_outer_tkp_P()
  {
    Tortoise.setAngle(180);
    Tortoise.setX(MakeALogo.XValue + 320);
    Tortoise.setY(MakeALogo.YValue);
    Tortoise.turn(180);
    Tortoise.move(15);
    Tortoise.turn(80);
    Tortoise.move(10);
    Tortoise.turn(-80);
    Tortoise.move(120);
    Tortoise.turn(-80);
    Tortoise.move(10);
    Tortoise.turn(80);
    Tortoise.move(15);
    Tortoise.turn(90);
    Tortoise.move(47);
    TKPLogo.curve5();
    Tortoise.move(12);
    Tortoise.turn(-90);
    Tortoise.move(50);
    Tortoise.turn(-80);
    Tortoise.move(10);
    Tortoise.turn(80);
    Tortoise.move(15);
    Tortoise.turn(90);
    Tortoise.move(43);
  }
  /**
   * Draws an <i>outstanding</> TKP right bracket
   * <div><b>Example:</b> {@code TKPLogo.drawRightBracket();}</div>
   */
  public static void drawRightBracket()
  {
    Tortoise.setAngle(-90);
    Tortoise.setX(MakeALogo.XValue + 250);
    Tortoise.setY(MakeALogo.YValue - 20);
    Tortoise.turn(180);
    Tortoise.move(30);
    TKPLogo.curve3();
    Tortoise.move(40);
    TKPLogo.curve4();
    Tortoise.move(10);
    Tortoise.turn(-90);
    Tortoise.move(10);
    Tortoise.turn(-90);
    Tortoise.move(10);
    TKPLogo.curve4();
    Tortoise.move(40);
    TKPLogo.curve3();
    Tortoise.move(30);
    Tortoise.turn(-90);
    Tortoise.move(10);
    Tortoise.turn(-90);
    Tortoise.move(15);
    TKPLogo.curve1();
    Tortoise.move(35);
    TKPLogo.curve2();
    Tortoise.turn(180);
    TKPLogo.curve2();
    Tortoise.move(35);
    TKPLogo.curve1();
    Tortoise.move(15);
    Tortoise.turn(-90);
    Tortoise.move(11);
  }
  /**
   * Draws an <i>original</> TKP left bracket
   * <div><b>Example:</b> {@code TKPLogo.drawLeftBracket();}</div>
   */
  public static void drawLeftBracket()
  {
    Tortoise.setAngle(-90);
    Tortoise.setX(MakeALogo.XValue + 130);
    Tortoise.setY(MakeALogo.YValue - 20);
    Tortoise.move(30);
    TKPLogo.curve1();
    Tortoise.move(40);
    TKPLogo.curve2();
    Tortoise.move(10);
    Tortoise.turn(90);
    Tortoise.move(10);
    Tortoise.turn(90);
    Tortoise.move(10);
    TKPLogo.curve2();
    Tortoise.move(40);
    TKPLogo.curve1();
    Tortoise.move(30);
    Tortoise.turn(90);
    Tortoise.move(10);
    Tortoise.turn(90);
    Tortoise.move(15);
    TKPLogo.curve3();
    Tortoise.move(35);
    TKPLogo.curve4();
    Tortoise.turn(180);
    TKPLogo.curve4();
    Tortoise.move(35);
    TKPLogo.curve3();
    Tortoise.move(15);
    Tortoise.turn(90);
    Tortoise.move(10);
  }
  /**
   * Draws an <i>incredible</> TKP T
   * <div><b>Example:</b> {@code TKPLogo.draw_tkp_T();}</div>
   */
  public static void draw_tkp_T()
  {
    Tortoise.setX(MakeALogo.XValue);
    Tortoise.setY(MakeALogo.YValue);
    Tortoise.move(15);
    Tortoise.turn(80);
    Tortoise.move(10);
    Tortoise.turn(-80);
    Tortoise.move(120);
    Tortoise.turn(-90);
    Tortoise.move(15);
    Tortoise.turn(-75);
    Tortoise.move(10);
    Tortoise.turn(75);
    Tortoise.move(15);
    Tortoise.turn(90);
    Tortoise.move(35);
    Tortoise.turn(90);
    Tortoise.move(95);
    Tortoise.turn(90);
    Tortoise.move(35);
    Tortoise.turn(90);
    Tortoise.move(15);
    Tortoise.turn(75);
    Tortoise.move(10);
    Tortoise.turn(-75);
    Tortoise.move(15);
    Tortoise.turn(-90);
    Tortoise.move(120);
    Tortoise.turn(-80);
    Tortoise.move(10);
    Tortoise.turn(80);
    Tortoise.move(15);
    Tortoise.turn(90);
    Tortoise.move(50);
  }
  /**
   * Draws an <i>impressive</> TKP K
   * <div><b>Example:</b> {@code TKPLogo.draw_tkp_K();}</div>
   */
  public static void draw_tkp_K()
  {
    Tortoise.setAngle(180);
    Tortoise.setX(MakeALogo.XValue + 150);
    Tortoise.setY(MakeALogo.YValue + 15);
    Tortoise.turn(180);
    Tortoise.move(200);
    Tortoise.turn(90);
    Tortoise.move(30);
    Tortoise.turn(90);
    Tortoise.move(128);
    Tortoise.turn(-150);
    Tortoise.move(70);
    Tortoise.turn(90);
    Tortoise.move(30);
    Tortoise.turn(90);
    Tortoise.move(70);
    Tortoise.turn(-80);
    Tortoise.move(80);
    Tortoise.turn(140);
    Tortoise.move(40);
    Tortoise.turn(40);
    Tortoise.move(60);
    Tortoise.turn(-130);
    Tortoise.move(45);
    Tortoise.turn(90);
    Tortoise.move(30);
    Tortoise.turn(2);
  }
  private static void curve6()
  {
    for (int i = 0; i < 180; i++)
    {
      double size = 0.43;
      Tortoise.turn(1);
      Tortoise.move(size);
    }
  }
  private static void curve5()
  {
    for (int i = 0; i < 180; i++)
    {
      double size = 0.75;
      Tortoise.turn(1);
      Tortoise.move(size);
      Tortoise.move(-size);
      Tortoise.move(size);
    }
  }
  private static void curve4()
  {
    for (int i = 0; i < 90; i++)
    {
      double size = 0.15;
      Tortoise.turn(1);
      Tortoise.move(size);
    }
  }
  private static void curve2()
  {
    for (int i = 0; i < 90; i++)
    {
      double size = 0.15;
      Tortoise.turn(-1);
      Tortoise.move(size);
    }
  }
  private static void curve1()
  {
    for (int i = 0; i < 90; i++)
    {
      double size = 0.25;
      Tortoise.turn(1);
      Tortoise.move(size);
    }
  }
  private static void curve3()
  {
    for (int i = 0; i < 90; i++)
    {
      double size = 0.25;
      Tortoise.turn(-1);
      Tortoise.move(size);
    }
  }
}
