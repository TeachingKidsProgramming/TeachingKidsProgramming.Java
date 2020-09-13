package src.main.java.org.teachingkidsprogramming.recipes.quizzes.graders;

import src.main.java.org.teachingextentions.logo.utils.EventUtils.MessageBox.MessageBoxInstance;

public class MessageBoxMock extends MessageBoxInstance
{
  public String lastMessage;
  @Override
  public void showMessage(String message)
  {
    lastMessage = message;
  }
}
