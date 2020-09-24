package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.reporters;

import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.TestUtils;
import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.io.FileUtils;

public class FileLauncherReporter implements ApprovalFailureReporter {
    @Override
    public void report(String received, String approved) throws Exception {
        if (FileUtils.isNonEmptyFile(approved)) {
            TestUtils.displayFile(approved);
        }
        TestUtils.displayFile(received);
    }
}
