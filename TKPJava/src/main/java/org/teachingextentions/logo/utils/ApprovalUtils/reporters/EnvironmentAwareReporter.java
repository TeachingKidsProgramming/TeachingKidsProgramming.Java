package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.reporters;

import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.reporters.ApprovalFailureReporter;

public interface EnvironmentAwareReporter extends ApprovalFailureReporter {
    boolean isWorkingInThisEnvironment(String forFile);
}
