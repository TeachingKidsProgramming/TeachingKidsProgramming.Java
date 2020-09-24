package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general;


import java.io.File;

public class SystemUtils {
    public static boolean isWindowsEnvironment() {
        return "\\".equals(File.separator);
    }

}
