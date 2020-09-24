package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.reporters.windows;

import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.reporters.FirstWorkingReporter;

public class TortoiseDiffReporter extends FirstWorkingReporter {
    public static final TortoiseDiffReporter INSTANCE = new TortoiseDiffReporter();

    public TortoiseDiffReporter() {
        super(TortoiseTextDiffReporter.INSTANCE, TortoiseImageDiffReporter.INSTANCE);
    }
}
