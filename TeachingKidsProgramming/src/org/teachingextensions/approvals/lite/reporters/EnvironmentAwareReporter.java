package org.teachingextensions.approvals.lite.reporters;

import org.teachingextensions.approvals.lite.ApprovalFailureReporter;

public interface EnvironmentAwareReporter extends ApprovalFailureReporter {
    boolean isWorkingInThisEnvironment(String forFile);
}
