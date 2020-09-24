package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.reporters;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface UseReporter {
    Class<? extends ApprovalFailureReporter>[] value();
}
