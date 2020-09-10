package org.teachingextensions.approvals.lite;


public interface ApprovalWriter {
    public String writeReceivedFile(String received) throws Exception;

    public String getReceivedFilename(String base);

    public String getApprovalFilename(String base);
}
