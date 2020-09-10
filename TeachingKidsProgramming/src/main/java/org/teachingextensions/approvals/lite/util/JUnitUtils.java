package org.teachingextensions.approvals.lite.util;

import static org.junit.Assume.assumeFalse;

import java.awt.GraphicsEnvironment;

public class JUnitUtils {
    public static void assumeNotHeadless() {
        boolean headless_check = GraphicsEnvironment.isHeadless();
        assumeFalse(headless_check);
    }
}
