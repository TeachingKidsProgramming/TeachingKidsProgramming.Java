package org.teachingextensions.setup;

import java.io.IOException;

import org.teachingextensions.approvals.lite.util.ObjectUtils;

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
