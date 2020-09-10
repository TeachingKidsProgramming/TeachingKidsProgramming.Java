package org.teachingextensions.approvals.lite.util;

import java.io.File;
import java.io.IOException;

import org.teachingextensions.approvals.lite.util.io.FileUtils;
import org.teachingextensions.approvals.lite.util.io.StackElementSelector;


public class TestUtils {

    public static void displayHtml(String htmlOutput) throws IOException,
            InterruptedException {
        displayHtml(null, ".html", htmlOutput, 3);
    }

    public static void displayHtmlFile(String fileName) throws IOException {
        displayFile(fileName);
    }

    public static void displayHtmlFile(File file) throws IOException {
        if (!file.exists()) {
            return;
        }
        displayHtmlFile(file.getAbsolutePath());
    }

    public static void displayHtml(String outputFile, String fileExtension, String htmlOutput, int secondsTimeout)
            throws IOException, InterruptedException {
        File file = (outputFile == null) ? File.createTempFile("temp", fileExtension) : new File(outputFile);
        FileUtils.writeFile(file, htmlOutput);
        displayHtmlFile(file);
        Thread.sleep(secondsTimeout * 1000);
        if (outputFile == null) {
            file.deleteOnExit();
        }
    }

    public static void displayText(String output) throws IOException, InterruptedException {
        displayHtml(null, ".txt", output, 3);
    }

    public static void displayFile(String fileName) {
        String cmd;
        if (File.separatorChar == '\\') {
            cmd = "cmd /C start \"Needed Title\" \"%s\" /B";
        } else {
            cmd = "open %s";
        }
        try {
            cmd = String.format(cmd, fileName);
            Runtime.getRuntime().exec(cmd);
            Thread.sleep(2000);
        } catch (Exception e) {
            throw ObjectUtils.throwAsError(e);
        }
    }

    public static StackTraceReflectionResult getCurrentFileForMethod(StackElementSelector stackElementSelector)
            throws Error {
        try {
            StackTraceElement trace[] = new Error().getStackTrace();
            StackTraceElement element = stackElementSelector.selectElement(trace);
            return getInfo(element);
        } catch (Throwable t) {
            throw ObjectUtils.throwAsError(t);
        }
    }

    private static StackTraceReflectionResult getInfo(StackTraceElement element) throws ClassNotFoundException {
        String fullClassName = element.getClassName();
        String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
        File dir = ClassUtils.getSourceDirectory(Class.forName(fullClassName));
        return new StackTraceReflectionResult(dir, className, element.getMethodName());
    }
}