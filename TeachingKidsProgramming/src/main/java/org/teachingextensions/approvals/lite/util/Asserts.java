package org.teachingextensions.approvals.lite.util;

public class Asserts {

    public static <T> T assertNotNull(String label, T o) {
        if (o == null) {
            throw new NullPointerException(label + " was null");
        }
        return o;
    }

    public static void equals(String label, double expected, double actual, double precision) {
        if (!NumberUtils.equals(expected, actual, precision)) {
            throw new IllegalStateException(label + " "
                    + expected + "!=" + actual);
        }
    }

}
