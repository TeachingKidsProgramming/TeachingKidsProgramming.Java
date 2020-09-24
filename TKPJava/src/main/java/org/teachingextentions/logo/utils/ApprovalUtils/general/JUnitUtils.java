package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general;

import static org.junit.Assume.assumeFalse;

import java.awt.GraphicsEnvironment;

public class JUnitUtils {
    public static void assumeNotHeadless() {
        boolean headless_check = GraphicsEnvironment.isHeadless();
        assumeFalse(headless_check);
    }
}
