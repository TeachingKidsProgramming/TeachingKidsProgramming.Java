package org.teachingextensions.approvals.lite.reporters;

import org.teachingextensions.approvals.lite.reporters.macosx.KaleidoscopeDiffReporter;
import org.teachingextensions.approvals.lite.reporters.windows.BeyondCompareReporter;
import org.teachingextensions.approvals.lite.reporters.windows.TortoiseImageDiffReporter;

public class ImageReporter extends FirstWorkingReporter {
    public ImageReporter() {
        super(TortoiseImageDiffReporter.INSTANCE, BeyondCompareReporter.INSTANCE, KaleidoscopeDiffReporter.INSTANCE,
                ImageWebReporter.INSTANCE, QuietReporter.INSTANCE);
    }
}
