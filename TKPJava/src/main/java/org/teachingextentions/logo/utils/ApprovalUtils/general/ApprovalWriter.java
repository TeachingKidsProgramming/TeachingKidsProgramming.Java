package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general;

public interface ApprovalWriter {
    public String writeReceivedFile(String received) throws Exception;

    public String getReceivedFilename(String base);

    public String getApprovalFilename(String base);
}

