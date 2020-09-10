package org.teachingextensions.approvals.lite.reporters;

import java.util.ArrayList;
import java.util.Collection;

import org.teachingextensions.approvals.lite.ApprovalFailureReporter;

public class MultiReporter implements ApprovalFailureReporter {
    private final Collection<ApprovalFailureReporter> reporters;

    public MultiReporter(Collection<ApprovalFailureReporter> reporters) {
        this.reporters = reporters;
    }

    @Override
    public void report(String received, String approved) throws Exception {
        ArrayList<Throwable> exceptions = new ArrayList<>();
        for (ApprovalFailureReporter reporter : reporters) {
            try {
                reporter.report(received, approved);
            } catch (Throwable t) {
                exceptions.add(t);
            }
        }
        MultipleExceptions.rethrowExceptions(exceptions);
    }

    public ApprovalFailureReporter[] getReporters() {
        return reporters.toArray(new ApprovalFailureReporter[0]);
    }
}
