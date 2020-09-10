package org.teachingextensions.approvals.lite.reporters;

import java.awt.GraphicsEnvironment;
import java.io.File;

import org.teachingextensions.approvals.lite.util.SystemUtils;
import org.teachingextensions.approvals.lite.util.WindowUtils;

/**
 * A reporter which creates the command to accept the received
 * file as the approve file and copies it to the clipboard:<br>
 * <code>move received.txt approved.txt</code>
 */
public class ClipboardReporter implements EnvironmentAwareReporter {
    @Override
    public void report(String received, String approved) throws Exception {
        WindowUtils.copyToClipBoard(getCommandLine(received, approved), false);
    }

    public static String getCommandLine(String received, String approved) {
        File r = new File(received);
        File a = new File(approved);
        return ClipboardReporter.getAcceptApprovalText(r.getAbsolutePath(), a.getAbsolutePath());
    }

    /**
     * The clipboard will not be available in a headless environment.
     */
    @Override
    public boolean isWorkingInThisEnvironment(String forFile) {
        return !GraphicsEnvironment.isHeadless();
    }

    public static String getAcceptApprovalText(String received, String approved) {
        if (SystemUtils.isWindowsEnvironment()) {
            return String.format("move /Y \"%s\"  \"%s\"", received, approved);
        } else {
            return String.format("mv %s %s", received, approved);
        }
    }
}
