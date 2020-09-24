package src.main.java.org.teachingextentions.logo.utils.EventUtils;

import javax.swing.JOptionPane;

import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.NumberUtils;

/**
 * <img src=
 * "http://www.mhhe.com/engcs/compsci/wu2/graphics/wu2java/common/javabook2Doc/mbox3.gif"
 * style="text-align: left" alt="A message box" height="60" width="145"> <br>
 * MessageBox is a pop up window. Use it to collect input from the user, or to display a message for the user to read.<br>
 */
public class MessageBox
{
  private static MessageBoxInstance messageBox = new MessageBoxInstance();
  /**
   * Prints a request for a numerical input to the window. <br>
   * <b>Example:</b>
   * {@code  int cookies = MessageBox.askForNumericalInput("How many cookies would you like?");}
   * 
   * @param message
   *            the text to be displayed
   * @return the user input
   */
  public static int askForNumericalInput(String message)
  {
    return messageBox.askForNumericalInput(message);
  }
  /**
   * Prints a request for a text input to the window. <br>
   * <b>Example:</b>
   * {@code  String name = MessageBox.askForTextInput("What is your nickname?");}
   * 
   * @param message
   *            the text to be displayed
   * @return the user input
   */
  public static String askForTextInput(String message)
  {
    return messageBox.askForTextInput(message);
  }
  /**
   * Prints the message to the window. <br>
   * <b>Example:</b> {@code  MessageBox.showMessage("Girl programmers rule!");}
   * 
   * @param message
   *            the text to be displayed
   * @param title 
   */
  public static void showMessage(String message)
  {
    messageBox.showMessage(message);
  }
  public static void mock(MessageBoxInstance messageBoxMock)
  {
    messageBox = messageBoxMock;
  }
  public static class MessageBoxInstance
  {
    public int askForNumericalInput(String message)
    {
      String input = askForTextInput(message);
      return NumberUtils.load(input, 0);
    }
    public String askForTextInput(String message)
    {
      return JOptionPane.showInputDialog(message);
    }
    public void showMessage(String message)
    {
      JOptionPane.showMessageDialog(null, message);
    }
  }
}
