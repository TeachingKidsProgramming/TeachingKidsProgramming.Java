package org.teachingextensions.approvals.lite.util;

public class ThreadUtils {
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            // ignore
        }
    }
}
