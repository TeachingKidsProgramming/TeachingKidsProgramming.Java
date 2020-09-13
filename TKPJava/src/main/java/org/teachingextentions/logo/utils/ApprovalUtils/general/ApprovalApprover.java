package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general;

public interface ApprovalApprover {
    boolean approve() throws Exception;

    public void cleanUpAfterSuccess(ApprovalFailureReporter reporter) throws Exception;

    void fail();

    void reportFailure(ApprovalFailureReporter reporter) throws Exception;
}