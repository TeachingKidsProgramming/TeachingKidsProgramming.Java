package org.teachingextensions.approvals.lite;

import java.io.File;
import java.io.IOException;

import junit.framework.TestCase;

import org.teachingextensions.approvals.lite.namer.ApprovalNamer;
import org.teachingextensions.approvals.lite.namer.NamerFactory;
import org.teachingextensions.approvals.lite.util.ObjectUtils;
import org.teachingextensions.approvals.lite.util.io.FileUtils;

public class FileApprover implements ApprovalApprover {
    private File received;
    private File approved;
    private final ApprovalWriter writter;

    public FileApprover(ApprovalWriter writter, ApprovalNamer namer) {
        this.writter = writter;
        String base = String.format("%s%s%s", namer.getSourceFilePath(), namer.getApprovalName(),
                NamerFactory.getAndClearAdditionalInformation());
        received = new File(writter.getReceivedFilename(base));
        approved = new File(writter.getApprovalFilename(base));
    }

    public boolean approve() throws Exception {
        received = new File(writter.writeReceivedFile(received.getAbsolutePath()));
        return approveTextFile(received, approved);
    }

    public void cleanUpAfterSuccess(ApprovalFailureReporter reporter) throws Exception {
        received.delete();
        if (reporter instanceof ApprovalReporterWithCleanUp) {
            ((ApprovalReporterWithCleanUp) reporter).cleanUp(received.getAbsolutePath(), approved.getAbsolutePath());
        }
    }

    public void reportFailure(ApprovalFailureReporter reporter) throws Exception {
        reporter.report(received.getAbsolutePath(), approved.getAbsolutePath());
    }

    public void fail() {
        TestCase.assertEquals("Failed Approval", approved.getAbsolutePath(), received.getAbsolutePath());
    }

    public static boolean approveTextFile(File expected, File actual) throws IOException {
        if (!expected.exists() || !actual.exists()) {
            return false;
        }
        String t1 = FileUtils.readFile(expected);
        String t2 = FileUtils.readFile(actual);
        return ObjectUtils.isEqual(t1, t2);
    }

    public boolean askToChangeReceivedToApproved(ApprovalFailureOverrider reporter) throws Exception {
        return reporter.askToChangeReceivedToApproved(received.getAbsolutePath(), approved.getAbsolutePath());
    }
}
