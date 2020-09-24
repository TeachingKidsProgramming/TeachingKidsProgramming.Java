package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.io;

public interface StackElementSelector {
    public abstract StackTraceElement selectElement(StackTraceElement[] trace) throws Exception;
}