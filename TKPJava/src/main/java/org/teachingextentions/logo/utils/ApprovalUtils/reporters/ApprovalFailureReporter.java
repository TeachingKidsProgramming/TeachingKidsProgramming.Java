package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.reporters;

public interface ApprovalFailureReporter {
    public void report(String received, String approved) throws Exception;
}