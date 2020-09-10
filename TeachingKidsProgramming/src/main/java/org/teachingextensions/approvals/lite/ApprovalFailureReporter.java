package org.teachingextensions.approvals.lite;

public interface ApprovalFailureReporter {
    public void report(String received, String approved) throws Exception;
}
