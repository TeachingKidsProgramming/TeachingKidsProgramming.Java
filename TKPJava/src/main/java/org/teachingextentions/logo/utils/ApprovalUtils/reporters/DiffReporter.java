package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.reporters;

import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.reporters.macosx.MacDiffReporter;
import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.reporters.windows.WindowsDiffReporter;

public class DiffReporter extends FirstWorkingReporter {
    public static final DiffReporter INSTANCE = new DiffReporter();

    public DiffReporter() {
        super(WindowsDiffReporter.INSTANCE, MacDiffReporter.INSTANCE, JunitReporter.INSTANCE, QuietReporter.INSTANCE);
    }
}
