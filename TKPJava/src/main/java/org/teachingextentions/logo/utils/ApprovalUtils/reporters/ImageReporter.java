package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.reporters;

import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.reporters.macosx.KaleidoscopeDiffReporter;
import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.reporters.windows.BeyondCompareReporter;
import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.reporters.windows.TortoiseImageDiffReporter;

public class ImageReporter extends FirstWorkingReporter {
    public ImageReporter() {
        super(TortoiseImageDiffReporter.INSTANCE, BeyondCompareReporter.INSTANCE, KaleidoscopeDiffReporter.INSTANCE,
                ImageWebReporter.INSTANCE, QuietReporter.INSTANCE);
    }
}
