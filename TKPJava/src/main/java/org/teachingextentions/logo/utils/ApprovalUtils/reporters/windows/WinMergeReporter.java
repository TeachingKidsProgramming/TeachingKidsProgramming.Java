package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.reporters.windows;

import java.text.MessageFormat;

import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.reporters.GenericDiffReporter;

public class WinMergeReporter extends GenericDiffReporter {
    public static final WinMergeReporter INSTANCE = new WinMergeReporter();
    static final String DIFF_PROGRAM = "C:\\Program Files\\WinMerge\\WinMergeU.exe";
    static final String MESSAGE = MessageFormat.format("Unable to find WinMerge at {0}"
                    + "\nYou can install it at http://winmerge.org/",
            DIFF_PROGRAM);

    public WinMergeReporter() {
        super(DIFF_PROGRAM, MESSAGE);
    }
}
