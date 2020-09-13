package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general;

public interface ApprovalFailureOverrider extends ApprovalFailureReporter {
    public boolean askToChangeReceivedToApproved(String received, String approved) throws Exception;
}