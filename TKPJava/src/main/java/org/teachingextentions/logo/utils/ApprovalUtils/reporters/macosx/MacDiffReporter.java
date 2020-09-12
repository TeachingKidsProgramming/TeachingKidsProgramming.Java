package org.teachingextensions.approvals.lite.reporters.macosx;

import org.teachingextensions.approvals.lite.reporters.FirstWorkingReporter;

public class MacDiffReporter extends FirstWorkingReporter
{
  public static final MacDiffReporter INSTANCE = new MacDiffReporter();
  public MacDiffReporter()
  {
    super(DiffMergeReporter.INSTANCE, KaleidoscopeDiffReporter.INSTANCE, P4MergeReporter.INSTANCE,
        TkDiffReporter.INSTANCE, BeyondCompareReporter.INSTANCE, BeyondCompareImageReporter.INSTANCE);
  }
}
