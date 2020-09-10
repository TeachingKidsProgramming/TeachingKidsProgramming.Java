package org.teachingextensions.approvals.lite.reporters;


import org.teachingextensions.approvals.lite.ApprovalFailureReporter;
import org.teachingextensions.approvals.lite.util.TestUtils;
import org.teachingextensions.approvals.lite.util.io.FileUtils;

public class FileLauncherReporter implements ApprovalFailureReporter {
    @Override
    public void report(String received, String approved) throws Exception {
        if (FileUtils.isNonEmptyFile(approved)) {
            TestUtils.displayFile(approved);
        }
        TestUtils.displayFile(received);
    }
}
