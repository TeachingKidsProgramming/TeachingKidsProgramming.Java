package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.reporters.windows;

import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.reporters.GenericDiffReporter;

public class TortoiseImageDiffReporter extends GenericDiffReporter {
    public static final TortoiseImageDiffReporter INSTANCE = new TortoiseImageDiffReporter();

    public TortoiseImageDiffReporter() {
        super("C:\\Program Files\\TortoiseSVN\\bin\\TortoiseIDiff.exe", "/left:\"%s\" /right:\"%s\"",
                TortoiseTextDiffReporter.MESSAGE, GenericDiffReporter.IMAGE_FILE_EXTENSIONS);
    }
}
