package org.teachingextensions.approvals.lite.reporters.windows;

import org.teachingextensions.approvals.lite.reporters.FirstWorkingReporter;

public class TortoiseDiffReporter extends FirstWorkingReporter {
    public static final TortoiseDiffReporter INSTANCE = new TortoiseDiffReporter();

    public TortoiseDiffReporter() {
        super(TortoiseTextDiffReporter.INSTANCE, TortoiseImageDiffReporter.INSTANCE);
    }
}
