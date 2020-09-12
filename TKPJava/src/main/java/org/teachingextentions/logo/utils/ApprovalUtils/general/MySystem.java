package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general;


import java.io.PrintWriter;
import java.util.Vector;

/**
 * A class for printing comments in a standardized format.
 *
 * @author Llewellyn
 * @version 2.0
 */
public class MySystem {
    public static boolean event = true;
    public static boolean variable = true;
    public static int hourGlass = 0;
    private static long lastTime = System.currentTimeMillis();
    private static PrintWriter SYSTEM_OUT_WRITER = new PrintWriter(System.out, true);

    private static void clearHourGlass() {
        if (hourGlass > 0) {
            System.out.println("");
            hourGlass = 0;
        }
    }

    private static String getIndent() {

        return "";
    }

    private static String timeStamp() {
        clearHourGlass();
        String text;
        long current = System.currentTimeMillis();
        java.text.DateFormat df = java.text.DateFormat.getDateTimeInstance();
        text = "[" + df.format(new java.util.Date(current)) + " ~" + padNumber(current - lastTime) + "ms]"
                + getIndent();
        lastTime = current;
        return text;
    }

    private static String padNumber(long number) {
        String text = "" + number;
        while (text.length() < 6) {
            text = "0" + text;
        }
        return text;
    }

    private static String indentMessage(String message) {
        Vector<Integer> v = new Vector<>();
        int place = 0;
        while ((place = message.indexOf('\n', place + 1)) != -1) {
            v.addElement(place);
        }
        if (v.size() == 0) {
            // no '\n'
            return message;
        }
        String theIndention = getIndent();
        StringBuilder buffer = new StringBuilder(message);
        for (int i = (v.size() - 1); i >= 0; i--) {
            int template = v.elementAt(i);
            buffer.insert(template + 1, theIndention);
        }
        return buffer.toString();
    }

    /**
     * Prints to screen any variable information to be viewed.
     *
     * @param statement The statement to print
     */
    public synchronized static void variable(String statement) {
        variable(statement, SYSTEM_OUT_WRITER);
    }

    public synchronized static void variable(String statement, PrintWriter out) {
        if (!variable) {
            return;
        }
        out.println(timeStamp() + "*=>" + statement);
    }

    /**
     * Prints to screen any variable information to be viewed.
     *
     * @param name  The value's name
     * @param value The value to print
     */
    public synchronized static void variable(String name, Object value) {
        if (!variable) {
            return;
        }
        System.out.println(timeStamp() + "*=> " + name + " = '" + (value == null ? null : value.toString()) + "'");
    }

    /**
     * Prints to screen any messages to be viewed.
     *
     * @param Statement The statement to print
     */
    public synchronized static void message(String Statement) {
        System.out.println(timeStamp() + indentMessage(Statement));
    }

    /**
     * Prints to screen any events to be viewed.
     *
     * @param Statement The statement to print
     */
    public static void event(String Statement) {
        if (!event) {
            return;
        }
        System.out.println(timeStamp() + "*--" + Statement);
    }

    /**
     * Prints to screen any warnings to be viewed.
     *
     * @param statement The statement to print
     */
    public synchronized static void warning(String statement) {
        warning(statement, null);
    }

    /**
     * Prints to screen any warnings to be viewed.
     *
     * @param throwable The throwable to print
     */
    public synchronized static void warning(Throwable throwable) {
        warning(null, throwable);
    }

    /**
     * Prints to screen any warnings to be viewed.
     *
     * @param statement The statement to print
     * @param throwable A throwable instance with error information
     */
    public synchronized static void warning(String statement, Throwable throwable) {
        warning(statement, throwable, null);
    }

    public synchronized static void warning(String statement, Throwable throwable, PrintWriter out) {
        clearHourGlass();
        dualPrintln("******************************************************************************************", out);
        dualPrintln(timeStamp(), out);
        if (statement != null) {
            dualPrintln(statement, out);
        }
        printFullTrace(throwable, false, out);
        if (throwable instanceof OutOfMemoryError) {
            dumpMemory(out);
        }
        dualPrintln("******************************************************************************************", out);
    }

    private static void dualPrintln(String string, PrintWriter out) {
        System.out.println(string);
        if (out != null) {
            out.println(string);
        }
    }

    private static void printFullTrace(Throwable throwable, boolean causedBy, PrintWriter out) {
        if (throwable != null) {
            dualPrintln((causedBy ? "Caused by : " : "") + throwable.getMessage(), out);
            throwable.printStackTrace();
            if (out != null) {
                throwable.printStackTrace(out);
            }
            if (throwable.getCause() != null) {
                printFullTrace(throwable.getCause(), true, out);
            }
        }
    }

    public static void dumpMemory(PrintWriter out) {
        System.gc();
        java.text.NumberFormat format = java.text.NumberFormat.getNumberInstance();
        long freeMemory = Runtime.getRuntime().freeMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();
        long usedMemory = totalMemory - freeMemory;
        String statement = "Memory [total, used, free] = [" + format.format(totalMemory) + " , "
                + format.format(usedMemory) + " , " + format.format(freeMemory) + "]";
        variable(statement, out);
    }
}
