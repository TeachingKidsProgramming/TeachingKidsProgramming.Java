package org.teachingextensions.approvals.lite.namer;

public class ApprovalResults {
    public static void UniqueForOs() {
        NamerFactory.asMachineSpecificTest(new OsEnvironmentLabeller());
    }
}
