package org.teachingextensions.approvals.lite.util;

import java.io.File;

public class SystemUtils {
    public static boolean isWindowsEnvironment() {
        return "\\".equals(File.separator);
    }

}
