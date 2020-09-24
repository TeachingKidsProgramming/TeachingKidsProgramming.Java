package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general;

public interface ApprovalFailureReporter {
    public void report(String received, String approved) throws Exception;
}
