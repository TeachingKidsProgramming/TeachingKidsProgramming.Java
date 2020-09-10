package org.teachingextensions.approvals.lite.reporters;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.teachingextensions.approvals.lite.ApprovalFailureReporter;

@Retention(RetentionPolicy.RUNTIME)
public @interface UseReporter {
    Class<? extends ApprovalFailureReporter>[] value();
}
