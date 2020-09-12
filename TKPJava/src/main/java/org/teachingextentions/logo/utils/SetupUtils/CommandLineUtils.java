package src.main.java.org.teachingextentions.logo.utils.SetupUtils;

import java.io.IOException;
import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.ObjectUtils;

public class CommandLineUtils {
  public static void launch(String commandLine, String... formattingArguments) {
    try {
      String command = String.format(commandLine,
          (Object[]) formattingArguments);
      Runtime.getRuntime().exec(command);
    } catch (IOException e) {
      ObjectUtils.throwAsError(e);
    }
  }
}
