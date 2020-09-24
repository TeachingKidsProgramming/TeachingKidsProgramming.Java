package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.reporters.macosx;

import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.reporters.FirstWorkingReporter;

public class MacDiffReporter extends FirstWorkingReporter
{
  public static final MacDiffReporter INSTANCE = new MacDiffReporter();
  public MacDiffReporter()
  {
    super(DiffMergeReporter.INSTANCE, KaleidoscopeDiffReporter.INSTANCE, P4MergeReporter.INSTANCE,
        TkDiffReporter.INSTANCE, BeyondCompareReporter.INSTANCE, BeyondCompareImageReporter.INSTANCE);
  }
}
