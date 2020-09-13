package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.reporters.windows;

import java.text.MessageFormat;

import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.reporters.GenericDiffReporter;

public class BeyondCompareReporter extends GenericDiffReporter {
    public static final BeyondCompareReporter INSTANCE = new BeyondCompareReporter();
    static final String DIFF_PROGRAM = "C:\\Program Files\\Beyond Compare 3\\BCompare.exe";
    static final String MESSAGE = MessageFormat.format(
            "Unable to find Beyond Compare at {0}", DIFF_PROGRAM);

    public BeyondCompareReporter() {
        super(DIFF_PROGRAM, MESSAGE);
    }
}
