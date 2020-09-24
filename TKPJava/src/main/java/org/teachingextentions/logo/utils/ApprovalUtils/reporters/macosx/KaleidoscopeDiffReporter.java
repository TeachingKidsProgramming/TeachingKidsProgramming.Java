package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.reporters.macosx;

import java.text.MessageFormat;
import java.util.List;

import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.reporters.GenericDiffReporter;
import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.ArrayUtils;

public class KaleidoscopeDiffReporter extends GenericDiffReporter {
    private static final String DIFF_PROGRAM = "/Applications/Kaleidoscope.app/Contents/MacOS/ksdiff";
    static final String MESSAGE = MessageFormat
            .format("Unable to find Kaleidoscope at {0}",
                    DIFF_PROGRAM);
    private static List<String> fileTypes = ArrayUtils.combine(
            GenericDiffReporter.IMAGE_FILE_EXTENSIONS,
            GenericDiffReporter.TEXT_FILE_EXTENSIONS);
    public static final KaleidoscopeDiffReporter INSTANCE = new KaleidoscopeDiffReporter();

    public KaleidoscopeDiffReporter() {
        super(DIFF_PROGRAM, GenericDiffReporter.STANDARD_ARGUMENTS, MESSAGE, fileTypes);
    }
}
