package org.teachingextensions.approvals.lite.util.io;

public interface StackElementSelector {
    public abstract StackTraceElement selectElement(StackTraceElement[] trace) throws Exception;
}