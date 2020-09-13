package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.reporters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MultiReporter implements ApprovalFailureReporter {
    private final Collection<src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.ApprovalFailureReporter> reporters;

    public MultiReporter(List<src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.ApprovalFailureReporter> reporters2) {
        this.reporters = reporters2;
    }

    @Override
    public void report(String received, String approved) throws Exception {
        ArrayList<Throwable> exceptions = new ArrayList<>();
        for (src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.ApprovalFailureReporter reporter : reporters) {
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
