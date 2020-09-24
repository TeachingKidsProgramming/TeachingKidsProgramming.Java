package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.reporters;

public interface EnvironmentAwareReporter extends ApprovalFailureReporter {
    boolean isWorkingInThisEnvironment(String forFile);
}
