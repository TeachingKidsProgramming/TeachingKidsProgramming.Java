package logo.utils.EventUtils;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import org.teachingextensions.approvals.lite.util.NumberUtils;

/**
 * <img src="http://www.mhhe.com/engcs/compsci/wu2/graphics/wu2java/common/javabook2Doc/mbox3.gif"
 * style="text-align: left" alt="A message box" height="60" width="145"> <br>
 * Fancy MessageBox is a pop up window that you can change!<br>
 * Use it to collect input from the user, or to display a message for the user to read.<br>
 */
public class FancyMessageBox
{
  private static FancyMessageBoxInstance fancyMessageBox = new FancyMessageBoxInstance();
  /**
   * Prints a request for a numerical input to the window. <br>
   * <b>Example:</b>
   * {@code  int cookies = FancyMessageBox.askForNumericalInput("How many cookies would you like?", "Cookies");}
   * 
   * @param message
   *            the text in the FancyMessageBox
   * @param title 
   *            the title of the FancyMessageBox            
   * @return the user input as a number
   */
  public static int askForNumericalInput(String message, String title)
  {
    return fancyMessageBox.askForNumericalInput(message, title);
  }
  /**
   * Prints a request for a text input to the window. <br>
   * <b>Example:</b>
   * {@code  String name = FancyMessageBox.askForTextInput("What is your nickname?", "Nicknames");}
   * 
   * @param message
   *            the text in the FancyMessageBox
    * @param title 
   *            the title of the FancyMessageBox  
   * @return the user input as a string
   */
  public static String askForTextInput(String message, String title)
  {
    return fancyMessageBox.askForTextInput(message, title);
  }
  /**
   * Prints the message to the window. <br>
   * <b>Example:</b> {@code  FancyMessageBox.showMessage("Girl programmers rule!","Just the Facts");}
   * 
   * @param message
   *            the text in the FancyMessageBox
   * @param title 
   *            the title of the FancyMessageBox 
   * @param icon
   *            a file and path that has an image for the MessageBox           
   */
  public static void showMesage(String message, String title, ImageIcon icon)
  {
    fancyMessageBox.showMessage(message, title, icon);
  }
  public static class FancyMessageBoxInstance
  {
    public static void mock(FancyMessageBoxInstance messageBoxMock)
    {
      fancyMessageBox = messageBoxMock;
    }
    public int askForNumericalInput(String message, String title)
    {
      String input = askForTextInput(message, title);
      return NumberUtils.load(input, 0);
    }
    public String askForTextInput(String message, String title)
    {
      return JOptionPane.showInputDialog(null, message, title, -1);
    }
    public void showMessage(String message, String title, ImageIcon icon)
    {
      JOptionPane.showMessageDialog(null, message, title, -1, icon);
    }
  }
}
