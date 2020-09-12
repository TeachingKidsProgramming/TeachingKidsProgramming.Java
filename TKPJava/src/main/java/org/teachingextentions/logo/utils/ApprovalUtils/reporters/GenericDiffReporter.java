package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.reporters;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.ThreadUtils;
import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.io.FileUtils;

public class GenericDiffReporter implements EnvironmentAwareReporter {
    public static final String STANDARD_ARGUMENTS = "%s %s";
    public static boolean REPORT_MISSING_FILES = false;
    protected String diffProgram;
    protected String arguments;
    protected String diffProgramNotFoundMessage;
    private List<String> validExtensions;
    public static List<String> TEXT_FILE_EXTENSIONS = Arrays.asList(".txt", ".csv", ".htm", ".html", ".xml",
            ".eml", ".java", ".css", ".js");
    public static List<String> IMAGE_FILE_EXTENSIONS = Arrays.asList(".png", ".gif", ".jpg", ".jpeg", ".bmp",
            ".tif", ".tiff");

    public GenericDiffReporter(String diffProgram, String diffProgramNotFoundMessage) {
        this(diffProgram, STANDARD_ARGUMENTS, diffProgramNotFoundMessage);
    }

    private GenericDiffReporter(String diffProgram, String argumentsFormat, String diffProgramNotFoundMessage) {
        this(diffProgram, argumentsFormat, diffProgramNotFoundMessage, TEXT_FILE_EXTENSIONS);
    }

    public GenericDiffReporter(String diffProgram, String argumentsFormat, String diffProgramNotFoundMessage,
                               List<String> validFileExtensions) {
        this.diffProgram = diffProgram;
        this.arguments = argumentsFormat;
        this.diffProgramNotFoundMessage = diffProgramNotFoundMessage;
        validExtensions = validFileExtensions;
    }

    @Override
    public void report(String received, String approved) throws Exception {
        if (!isWorkingInThisEnvironment(received)) {
            throw new RuntimeException(diffProgramNotFoundMessage);
        }
        FileUtils.createIfNeeded(approved);
        launch(received, approved);
    }

    private void launch(String received, String approved) throws IOException {
        ProcessBuilder builder = new ProcessBuilder(getCommandLine(received, approved));
        builder.start();
        ThreadUtils.sleep(500); //Give program time to start
    }

    public String[] getCommandLine(String received, String approved) {
        String[] p = arguments.split(" ");
        String r = String.format(p[0], received);
        String a = String.format(p[1], approved);
        String[] commands = new String[]{diffProgram, r, a};
        System.out.println(Arrays.toString(commands));
        return commands;
    }

    @Override
    public boolean isWorkingInThisEnvironment(String forFile) {
        return checkFileExists() && isFileExtensionHandled(forFile);
    }

    public boolean checkFileExists() {
        boolean exists = new File(diffProgram).exists();
        if (REPORT_MISSING_FILES && !exists) {
            System.out.println(String.format("%s can't find '%s'", this.getClass().getSimpleName(), diffProgram));
        }
        return exists;
    }

    public boolean isFileExtensionHandled(String forFile) {
        return isFileExtensionValid(forFile, validExtensions);
    }

    public static boolean isFileExtensionValid(String forFile, List<String> validExtensionsWithDot) {
        String extensionWithDot = FileUtils.getExtensionWithDot(forFile);
        return validExtensionsWithDot.contains(extensionWithDot);
    }
}
