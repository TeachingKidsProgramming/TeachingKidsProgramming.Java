package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.reporters.windows;

import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.reporters.FirstWorkingReporter;

public class WindowsDiffReporter extends FirstWorkingReporter {
    public static final WindowsDiffReporter INSTANCE = new WindowsDiffReporter();

    public WindowsDiffReporter() {
        super(TortoiseDiffReporter.INSTANCE, BeyondCompareReporter.INSTANCE, WinMergeReporter.INSTANCE);
    }
}
